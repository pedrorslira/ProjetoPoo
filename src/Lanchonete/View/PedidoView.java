package Lanchonete.View;

import Lanchonete.Controller.PedidoController;
import Lanchonete.Controller.ProdutoController;
import Lanchonete.Controller.FuncionarioController;
import Lanchonete.Model.Pedido;
import Lanchonete.Model.Produto;
import Lanchonete.Model.Funcionario;
import Lanchonete.Model.Item;
import Lanchonete.Model.FormaDePagamento;
import Lanchonete.Model.StatusAlterado;
import Lanchonete.Model.StatusEfetuado;
import Lanchonete.Model.StatusNovo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PedidoView extends Telas {

    PedidoController controllerPedido = new PedidoController();
    ProdutoController controllerProduto = new ProdutoController();
    FuncionarioController controllerFuncionario = new FuncionarioController();

    @Override
    public void Menu() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            System.out.println("\t\t\t\t--------Menu de Pedidos--------");
            System.out.println("Informe o que deseja fazer: ");
            System.out.println("1- Efetuar Pedido");
            System.out.println("2-Cancelar Pedido");
            System.out.println("3-Consultar Pedido");
            System.out.println("4-Alterar Pedido");
            System.out.println("5-Listar Pedidos");
            System.out.println("6-Voltar para o Menu Principal");
            op = in.nextInt();
            switch (op) {
                case 1:
                    this.Cadastrar();
                    break;
                case 2:
                    this.Remover();
                    break;
                case 3:
                    this.Consultar();
                    break;
                case 4:
                    this.Alterar();
                    break;
                case 5:
                    this.Listar();
                    break;
                default:
                    break;
            }
        } while (op != 6);
    }

    @Override
    public void Cadastrar() {
        int qtd_produto, qtd_produto_total, op, qtd_aux = 0;
        double salario_func, bonus;
        String codigo, codigo_produto, codigo_funcionario;
        Date data = new Date();
        FormaDePagamento formapgto = FormaDePagamento.NAO_INFORMADO;
        Item item;
        Funcionario func;
        Produto produto, produto_aux;
        Pedido p = new Pedido(data, formapgto);
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o código do funcionário responsável pelo atendimento"); //verificar se o funcionário trabalha na lanchonete
        codigo_funcionario = in.next();
        func = controllerFuncionario.ConsultarFuncionario(codigo_funcionario);
        if (func == null) {
            System.out.println("Nenhum funcionário tem esse código");
            return;
        } //se o funcionário trabalhar na lanchonete:
        p.setStatus(new StatusNovo());
        System.out.println(p.getStatus().estado());
        do {
            System.out.println("Informe a forma de pagamento: ");
            System.out.println("1- À vista");
            System.out.println("2- Crédito");
            System.out.println("3- Débito");
            op = in.nextInt();
        } while (op < 1 || op > 3);
        switch (op) {
            case 1:
                formapgto = FormaDePagamento.A_VISTA;
                break;
            case 2:
                formapgto = FormaDePagamento.CREDITO;
                break;
            case 3:
                formapgto = FormaDePagamento.DEBITO;
                break;
            default:
                break;
        }
        do {
            System.out.println("Informe o código do produto a ser adicionado"); //verificar se o produto existe na lanchonete
            codigo_produto = in.next();
            produto = controllerProduto.ConsultarProduto(codigo_produto);
            if (produto == null) {
                System.out.println("O código do produto informado não existe no sistema");
                return;
            } //se o produto existir na lanchonete:
            do {
                qtd_produto_total = controllerProduto.ConsultarQtdProduto(codigo_produto);
                if (qtd_produto_total == 0) {
                    System.out.print("\n");
                    System.out.println("O produto buscado está esgotado");
                    return;
                }
                System.out.println("Quantidade do produto buscado em estoque: " + qtd_produto_total);
                System.out.println("Informe a quantidade do produto a ser adicionada");
                qtd_produto = in.nextInt();
            } while (qtd_produto > qtd_produto_total);
            item = new Item(qtd_produto);
            do { //adicionar produto em item e retirar o produto do estoque quando ele for levado pelo cliente
                produto_aux = controllerProduto.ConsultarProduto(codigo_produto);
                item.AddProduto(produto_aux);
                controllerProduto.RemoverProduto(codigo_produto);
                qtd_aux++;
            } while (qtd_aux != qtd_produto);
            qtd_aux = 0;
            p.AddItem(item); //adicionar item em pedido
            System.out.println("Deseja inserir mais algum item de produto?");
            System.out.println("1- Adicionar mais produtos");
            System.out.println("2- Finalizar a Compra");
            op = in.nextInt();
        } while (op == 1);
        p.setStatus(new StatusEfetuado());
        data = new Date();
        p.setData(data);
        p.setFormapgto(formapgto);
        p.setCodigo(p.NovoCodigo()); //randomizar o código de pedido
        controllerPedido.CadastrarPedido(p);
        p.setStatus(new StatusEfetuado());
        System.out.println(p.getStatus().estado());
        codigo = p.getCodigo();
        System.out.println("Código do Pedido: " + codigo);
        func.setQtdVendas(func.getQtdVendas() + 1);
        bonus = p.getPrecoTotal() * 0.02; //bônus de 2% de cada venda no salário do funcionário
        salario_func = func.getSalario();
        salario_func += bonus;
        func.setSalario(salario_func);
    }

    @Override
    public void Remover() {
        int retorno;
        Scanner in = new Scanner(System.in);
        String codigo;
        System.out.println("Informe o código do pedido a ser cancelado");
        codigo = in.next();
        retorno = controllerPedido.RemoverPedido(codigo);
        if (retorno == 0) {
            System.out.println("Pedido não cadastrado");
        } else {
            System.out.println("Pedido cancelado com sucesso!");
        }
    }

    @Override
    public void Consultar() {
        Scanner in = new Scanner(System.in);
        int i = 0;
        String cod;
        Pedido p;

        System.out.println("Informe o código do pedido buscado: ");
        cod = in.next();
        p = controllerPedido.ConsultarPedido(cod);
        if (p == null) {
            System.out.println("Produto não encontrado ");
        } else {
            System.out.println("Código: " + p.getCodigo());
            System.out.println("Data: " + p.getData());
            System.out.println("Status: " + p.getStatus().estado());
            System.out.println("Forma de Pagamento: " + p.getFormapgto());
            System.out.print("\n");
            System.out.println("Compras: ");
            System.out.print("\n");
            for (Item item : p.getItens()) {
                System.out.println("Nome do Produto: " + item.getProduto().get(i).getNome());
                System.out.println("Código do Produto: " + item.getProduto().get(i).getCodigo());
                System.out.println("Preço do Produto: " + item.PrecoTotalItem());
                System.out.println("Quantidade do Produto: " + item.getQuantidade());
                i++;
            }
            System.out.print("\n");
            System.out.println("Preço total dos Produtos: " + p.getPrecoTotal());
        }
    }

    @Override
    public void Alterar() {
        Scanner in = new Scanner(System.in);
        int op;
        String codigo;
        FormaDePagamento novaforma_pgto;
        Pedido novop, antigop;
        System.out.println("Informe o código do pedido a ser modificado: ");
        codigo = in.next();
        antigop = controllerPedido.ConsultarPedido(codigo);
        if (antigop == null) {
            System.out.println("Pedido não encontrado");
        } else {
            do {
                System.out.println("Informe a nova forma de pagamento do pedido");
                System.out.println("1- À vista");
                System.out.println("2- Crédito");
                System.out.println("3- Débito");
                op = in.nextInt();
            } while (op < 1 || op > 3);
            switch (op) {
                case 1:
                    novaforma_pgto = FormaDePagamento.A_VISTA;
                    break;
                case 2:
                    novaforma_pgto = FormaDePagamento.CREDITO;
                    break;
                default:
                    novaforma_pgto = FormaDePagamento.DEBITO;
                    break;
            }
            novop = new Pedido(antigop.getData(), novaforma_pgto);
            novop.setCodigo(codigo);
            novop.setStatus(new StatusAlterado());
            System.out.println(novop.getStatus().estado());
            controllerPedido.AlterarPedido(codigo, novop);

        }
    }

    @Override
    public void Listar() {
        ArrayList<Pedido> pedidos = controllerPedido.ListarPedidos();
        if (pedidos.isEmpty() == true) {
            System.out.println("Nenhum pedido está cadastrado no sistema");
        } else {
            for (Pedido p : pedidos) {
                System.out.println("Código: " + p.getCodigo());
                System.out.println("Data do Pedido: " + p.getData());
                System.out.println("Status: " + p.getStatus().estado());
                System.out.println("Forma de Pagamento: " + p.getFormapgto());
                for (Item i : p.getItens()) {
                    System.out.println("Nome do Produto: " + i.getProduto().get(0).getNome());
                    System.out.println("Código do Produto: " + i.getProduto().get(0).getCodigo());
                    System.out.println("Preço do Produto: " + i.PrecoTotalItem());
                    System.out.println("Quantidade do Produto: " + i.getQuantidade());
                }
                System.out.print("\n");
                System.out.println("Preço total dos Produtos: " + p.getPrecoTotal());
            }
        }
    }
}
