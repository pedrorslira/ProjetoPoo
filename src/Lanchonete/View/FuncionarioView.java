package Lanchonete.View;

import Lanchonete.Controller.FuncionarioController;
import Lanchonete.Model.Funcionario;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioView extends Telas {

    FuncionarioController controller = new FuncionarioController();

    @Override
    public void Menu() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            System.out.println("\t\t\t\t--------Menu de Funcionários--------");
            System.out.println("Informe o que deseja fazer: ");
            System.out.println("1- Cadastrar Funcionário");
            System.out.println("2-Remover Funcionário");
            System.out.println("3-Consultar Funcionário");
            System.out.println("4-Alterar Funcionário");
            System.out.println("5-Listar Funcionários");
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
        String nome, cpf, endereco;
        double salario;
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário");
        nome = in.nextLine();
        System.out.println("Informe o endereço do funcionário");
        endereco = in.nextLine();
        System.out.println("Informe o cpf do funcionário");
        cpf = in.next();
        System.out.println("Informe o salario do funcionário");
        salario = in.nextDouble();
        Funcionario f = new Funcionario(endereco, salario, nome, cpf);
        f.setCodigo(f.NovoCodigo()); //randomizar o código do funcionário
        controller.CadastrarFuncionario(f);
        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println("Código do Funcionário: " + f.getCodigo());
    }

    @Override
    public void Remover() {
        int retorno;
        String codigo;
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o número do funcionário a ser removido do cadastro: ");
        codigo = in.next();
        retorno = controller.RemoverFuncionario(codigo);
        if (retorno == 0) {
            System.out.println("Funcionário não encontrado");
        } else {
            System.out.println("Funcionário Removido com sucesso");
        }
    }

    @Override
    public void Consultar() {
        Scanner in = new Scanner(System.in);
        String codigo;
        Funcionario f;
        System.out.println("Informe o código do funcionário a ser buscado: ");
        codigo = in.next();
        f = controller.ConsultarFuncionario(codigo);
        if (f == null) {
            System.out.println("Funcionário não encontrado ");
        } else {
            System.out.println("Nome: " + f.getNome());
            System.out.println("CPF: " + f.getCpf());
            System.out.println("Código: " + f.getCodigo());
            System.out.println("Endereço: " + f.getEndereco());
            System.out.println("Salário: " + f.getSalario());
            System.out.println("Vendas Realizadas: " + f.getQtdVendas());
        }
    }

    @Override
    public void Alterar() {
        Scanner in = new Scanner(System.in);
        String codigo, novonome, novoendereco, novocpf;
        double novosalario;
        Funcionario novof, antigof;
        System.out.println("Informe o código do funcionário a ser modificado: ");
        codigo = in.next();
        antigof = controller.ConsultarFuncionario(codigo);
        if (antigof == null) {
            System.out.println("Funcionário não encontrado");
        } else {
            System.out.println("Informe o novo nome desse funcionário: ");
            novonome = in.nextLine();
            System.out.println("Informe o novo endereço desse funcionário: ");
            novoendereco = in.nextLine();
            System.out.println("Informe o novo cpf desse funcionário: ");
            novocpf = in.next();
            System.out.println("Informe o novo salário desse funcionário: ");
            novosalario = in.nextDouble();
            novof = new Funcionario(novoendereco, novosalario, novonome, novocpf);
            novof.setCodigo(codigo);
            controller.AlterarFuncionario(codigo, novof);
            System.out.println("Funcionário alterado com sucesso!");
        }

    }

    @Override
    public void Listar() {
        ArrayList<Funcionario> funcionarios = controller.ListarFuncionarios();
        if (funcionarios.isEmpty() == true) {
            System.out.println("Nenhum funcionário cadastrado");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println("Nome: " + f.getNome());
                System.out.println("CPF: " + f.getCpf());
                System.out.println("Código: " + f.getCodigo());
                System.out.println("Endereço: " + f.getEndereco());
                System.out.println("Salário: " + f.getSalario());
                System.out.println("Vendas Realizadas: " + f.getQtdVendas());
            }
        }
    }
}
