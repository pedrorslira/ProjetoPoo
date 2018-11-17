package Lanchonete.View;

import Lanchonete.Controller.PedidoController;
import Lanchonete.Controller.ProdutoController;
import Lanchonete.Controller.FuncionarioController;
import Lanchonete.Model.Pedido;
import Lanchonete.Model.Produto;
import Lanchonete.Model.Funcionario;
import Lanchonete.Model.Item;
import Lanchonete.Model.FormaDePagamento;
import Lanchonete.Model.State.*;
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

    public Funcionario FuncionarioExistente() { //verificar se o funcionário trabalha na lanchonete
        String codigo;
        Funcionario func;
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o código do funcionário responsável pelo atendimento");
        codigo = in.next();
        func = controllerFuncionario.ConsultarFuncionario(codigo);
        if (func == null) {
            System.out.println("Nenhum funcionário tem esse código");
            return null;
        }
        return func;
    }

    public Produto ProdutoExistente() { //verificar se o produto existe na lanchonete
        String codigo;
        Produto produto;
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o código do produto a ser adicionado");
        codigo = in.next();
        produto = controllerProduto.ConsultarProduto(codigo);
        if (produto == null) {
            System.out.println("O código do produto informado não existe no sistema");
            return null;
        }
        return produto;
    }

    public void TelaFormaDePagamento(Pedido p) {
        int op;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Informe a forma de pagamento: ");
            System.out.println("1- À vista");
            System.out.println("2- Crédito");
            System.out.println("3- Débito");
            op = in.nextInt();
        } while (op < 1 || op > 3);
        p.setFormapgto(op);
    }

    @Override
    public void Cadastrar() {
        int op, qtd_produto, qtd_produto_total, qtd_aux = 0;
        String codigo;
        FormaDePagamento formapgto = FormaDePagamento.NAO_INFORMADO;
        Item item;
        Produto produto;
        Funcionario func;
        Pedido p = new Pedido(formapgto);
        State status = new StatusNovo();
        Scanner in = new Scanner(System.in);

        func = FuncionarioExistente();
        if (func == null) {
            return;
        }
        System.out.println(status.estado(p));
        TelaFormaDePagamento(p);
        do {
            produto = ProdutoExistente();
            if (produto == null) {
                return;
            }
            do {
                qtd_produto_total = controllerProduto.ConsultarQtdProduto(produto.getCodigo());
                if (qtd_produto_total == 0) {
                    System.out.println("O produto buscado está esgotado\n");
                    return;
                }
                System.out.println("Quantidade do produto buscado em estoque: " + qtd_produto_total);
                System.out.println("Informe a quantidade do produto a ser adicionada");
                qtd_produto = in.nextInt();
            } while (qtd_produto > qtd_produto_total);
            item = new Item(qtd_produto);
            do { //adicionar produto em item e retirar o produto do estoque quando ele for levado pelo cliente
                produto = controllerProduto.ConsultarProduto(produto.getCodigo());
                item.AddProduto(produto);
                controllerProduto.RemoverProduto(produto.getCodigo());
                qtd_aux++;
            } while (qtd_aux != qtd_produto);
            qtd_aux = 0;
            p.AddItem(item); //adicionar item em pedido
            System.out.println("Deseja inserir mais algum item de produto?");
            System.out.println("1- Adicionar mais produtos");
            System.out.println("2- Finalizar a Compra");
            op = in.nextInt();
        } while (op == 1);
        status = new StatusEfetuado();
        System.out.println(status.estado(p));
        Date data = new Date();
        p.setData(data);
        p.setCodigo(p.NovoCodigo()); //randomizar o código de pedido
        controllerPedido.CadastrarPedido(p);
        codigo = p.getCodigo();
        System.out.println("Código do Pedido: " + codigo);
        func.setQtdVendas(func.getQtdVendas() + 1);
        func.BonusSalario(p.getPrecoTotal());
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
            System.out.println("Status: " + p.getStatus());
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
        String codigo;
        Pedido novop, antigop;
        State status = new StatusAlterado();
        System.out.println("Informe o código do pedido a ser modificado: ");
        codigo = in.next();
        antigop = controllerPedido.ConsultarPedido(codigo);
        if (antigop == null) {
            System.out.println("Pedido não encontrado");
        } else {
            TelaFormaDePagamento(antigop);
            novop = new Pedido(antigop.getFormapgto());
            novop.setCodigo(codigo);
            System.out.println(status.estado(novop));
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
                System.out.println("Status: " + p.getStatus());
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
