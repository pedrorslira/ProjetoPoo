package View;

import Controller.FuncionarioController;
import Model.Funcionario;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioView {

    FuncionarioController controller = new FuncionarioController();

    public void MenuFuncionario() {
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
                    this.CadastrarFuncionario();
                    break;
                case 2:
                    this.RemoverFuncionario();
                    break;
                case 3:
                    this.ConsultarFuncionario();
                    break;
                case 4:
                    this.AlterarFuncionario();
                    break;
                case 5:
                    this.ListarFuncionarios();
                    break;
                default:
                    break;
            }
        } while (op != 6);
    }

    public void CadastrarFuncionario() {
        int numero;
        String nome, cpf, endereco;
        double salario;
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário");
        nome = in.nextLine();
        System.out.println("Informe o endereço do funcionário");
        endereco = in.nextLine();
        System.out.println("Informe o numero do funcionário");
        numero = in.nextInt();
        System.out.println("Informe o cpf do funcionário");
        cpf = in.next();
        System.out.println("Informe o salario do funcionário");
        salario = in.nextDouble();
        Funcionario f = new Funcionario(numero, endereco, salario, nome, cpf);
        controller.CadastrarNovoFuncionario(f);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void RemoverFuncionario() {
        int retorno;
        Scanner in = new Scanner(System.in);
        int numero;
        System.out.println("Informe o número do funcionário a ser removido do cadastro: ");
        numero = in.nextInt();
        retorno = controller.RemoverUmFuncionario(numero);
        if (retorno == 0) {
            System.out.println("Funcionário não encontrado");
        } else {
            System.out.println("Funcionário Removido com sucesso");
        }
    }

    public void ConsultarFuncionario() {
        Scanner in = new Scanner(System.in);
        int numero, op;
        String cpf;
        Funcionario f;
        do {
            System.out.println("Você deseja buscar funcionário por código ou cpf?");
            System.out.println("1- Número");
            System.out.println("2- CPF");
            op = in.nextInt();
        } while (op < 1 || op > 2);
        if (op == 1) {
            System.out.println("Informe o número do funcionário a ser buscado: ");
            numero = in.nextInt();
            f = controller.ConsultarUmFuncionario(numero);
        } else {
            System.out.println("Informe o cpf do funcionário a ser buscado: ");
            cpf = in.next();
            f = controller.ConsultarUmFuncionario(cpf);
        }
        if (f == null) {
            System.out.println("Funcionário não encontrado ");
        } else {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Numero: " + f.getNumero());
            System.out.println("CPF: " + f.getCpf());
            System.out.println("Endereço: " + f.getEndereco());
            System.out.println("Salário: " + f.getSalario());
        }
    }

    private void AlterarFuncionario() {
        Scanner in = new Scanner(System.in);
        int numero, novonumero;
        String novonome, novoendereco, novocpf;
        double novosalario;
        Funcionario novof, antigof;
        System.out.println("Informe o número do funcionário a ser modificado: ");
        numero = in.nextInt();
        antigof = controller.ConsultarUmFuncionario(numero);
        if (antigof == null) {
            System.out.println("Funcionário não encontrado");
        } else {
            System.out.println("Informe o novo nome desse funcionário: ");
            novonome = in.nextLine();
            System.out.println("Informe o novo endereço desse funcionário: ");
            novoendereco = in.nextLine();
            System.out.println("Informe o novo número desse funcionário: ");
            novonumero = in.nextInt();
            System.out.println("Informe o novo cpf desse funcionário: ");
            novocpf = in.next();
            System.out.println("Informe o novo salário desse funcionário: ");
            novosalario = in.nextDouble();
            novof = new Funcionario(novonumero, novoendereco, novosalario, novonome, novocpf);
            controller.AlterarDadosFuncionario(numero, novof);
            System.out.println("Funcionário alterado com sucesso!");
        }

    }

    private void ListarFuncionarios() {
        ArrayList<Funcionario> funcionarios = controller.ListarFuncionariosNoCadastro();
        if (funcionarios.isEmpty() == true) {
            System.out.println("Nenhum funcionário cadastrado");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println("Nome: " + f.getNome());
                System.out.println("Número: " + f.getNumero());
                System.out.println("Endereço: " + f.getEndereco());
                System.out.println("Salário: " + f.getSalario());
            }
        }
    }
}
