package Lanchonete.View;

import Lanchonete.Controller.ProdutoController;
import Lanchonete.Controller.FuncionarioController;
import Lanchonete.Model.Produto;
import Lanchonete.Model.Funcionario;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoView extends Telas {

    ProdutoController controller = new ProdutoController();
    FuncionarioController controllerFuncionario = new FuncionarioController();

    @Override
    public void Menu() {
        Scanner in = new Scanner(System.in);
        Funcionario func;
        String codigo_funcionario;
        int op;
        System.out.println("Informe o código do funcionário responsável pelo atendimento"); //verificar se o funcionário trabalha na lanchonete
        codigo_funcionario = in.next();
        func = controllerFuncionario.ConsultarFuncionario(codigo_funcionario);
        if (func == null) {
            System.out.println("Nenhum funcionário tem esse código");
            return;
        }
        do {
            System.out.println("\t\t\t\t--------Menu de Produtos--------");
            System.out.println("Informe o que deseja fazer: ");
            System.out.println("1- Cadastrar Produto");
            System.out.println("2-Remover Produto");
            System.out.println("3-Consultar Produto");
            System.out.println("4-Alterar Produto");
            System.out.println("5-Listar Produtos");
            System.out.println("6-Voltar para o Menu Principal");
            op = in.nextInt();
            switch (op) {
                case 1:
                    Cadastrar();
                    break;
                case 2:
                    Remover();
                    break;
                case 3:
                    Consultar();
                    break;
                case 4:
                    Alterar();
                    break;
                case 5:
                    Listar();
                    break;
                default:
                    break;
            }
        } while (op != 6);
    }

    @Override
    public void Cadastrar() {
        String codigo;
        String nome, descricao;
        double preco, peso;
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o nome do produto");
        nome = in.nextLine();
        System.out.println("Informe a descrição do produto");
        descricao = in.nextLine();
        System.out.println("Informe o código do produto");
        codigo = in.next();
        System.out.println("Informe o preço do produto");
        preco = in.nextDouble();
        System.out.println("Informe o peso do produto (em kg)");
        peso = in.nextDouble();
        Produto p = new Produto(codigo, nome, descricao, preco, peso);
        p.NovoPreco();
        controller.CadastrarProduto(p);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public void Remover() {
        Scanner in = new Scanner(System.in);
        String cod;
        Produto p_consulta;
        System.out.println("Informe o código do produto a ser removido do cadastro: ");
        cod = in.next();
        p_consulta = controller.ConsultarProduto(cod);
        controller.RemoverProduto(cod);
        if (p_consulta == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println("Produto Removido com sucesso!");
        }
    }

    @Override
    public void Consultar() {
        Scanner in = new Scanner(System.in);
        String cod;
        Produto p;
        System.out.println("Informe o código do produto buscado: ");
        cod = in.next();
        p = controller.ConsultarProduto(cod);
        if (p == null) {
            System.out.println("Produto não encontrado ");
        } else {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Código: " + p.getCodigo());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Peso: " + p.getPeso());
        }
    }

    @Override
    public void Alterar() {
        Scanner in = new Scanner(System.in);
        String novonome, novadesc, cod, novocod;
        double novopreco, novopeso;
        Produto novop, antigop;
        System.out.println("Informe o código do produto a ser modificado: ");
        cod = in.next();
        antigop = controller.ConsultarProduto(cod);
        if (antigop == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println("Informe o novo nome desse produto: ");
            novonome = in.nextLine();
            System.out.println("Informe a nova descrição desse produto: ");
            novadesc = in.nextLine();
            System.out.println("Informe o novo código desse produto: ");
            novocod = in.next();
            System.out.println("Informe o novo preço desse produto: ");
            novopreco = in.nextDouble();
            System.out.println("Informe o novo peso desse produto: ");
            novopeso = in.nextDouble();
            novop = new Produto(novocod, novonome, novadesc, novopreco, novopeso);
            controller.AlterarProduto(cod, novop);
            System.out.println("Produto alterado com sucesso!");
        }
    }

    @Override
    public void Listar() {
        ArrayList<Produto> produtos = controller.ListarProdutos();
        if (produtos.isEmpty() == true) {
            System.out.println("Nenhum produto cadastrado");
        } else {
            for (Produto p : produtos) {
                System.out.println("Código: " + p.getCodigo());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Descrição: " + p.getDescricao());
                System.out.println("Peso: " + p.getPeso());
                System.out.println("Preço: " + p.getPreco());
            }
        }
    }
}
