package View;

import Model.Administrador;
import java.util.Scanner;

public class LanchoneteMain {

    public static void main(String[] args) {
        String input, nome = "Big Boss", cpf = "96342158746";
        Administrador admin = new Administrador(nome, cpf);
        ProdutoView produto = new ProdutoView();
        FuncionarioView funcionario = new FuncionarioView();
        PedidoView pedido = new PedidoView();
        Scanner in = new Scanner(System.in);
        int op;
        do {
            System.out.println("\t\t\t\t--------Menu Principal--------");
            System.out.println("Informe o módulo que deseja acessar: ");
            System.out.println("1- Produto");
            System.out.println("2- Funcionário");
            System.out.println("3- Pedido");
            System.out.println("4- Sair do Programa");
            op = in.nextInt();
            switch (op) {
                case 1:
                    produto.MenuProduto();
                    break;
                case 2:
                    do {
                        System.out.println("Informe o usuário do administrador");
                        input = in.next();
                    } while (input.equals(admin.getUsuario()) == false);
                    do {
                        System.out.println("Informe a senha do administrador");
                        input = in.next();
                    } while (input.equals(admin.getSenha()) == false);
                    System.out.println("Bem Vindo " + admin.getNome());
                    funcionario.MenuFuncionario();
                    break;
                case 3:
                    pedido.MenuPedido();
                    break;
                default:
                    break;
            }
        } while (op != 4);
    }
}

/*O QUE FALTA (2º GQ): 
1- Implementar Factory Method
2- Implementar mais 2 padrões de projeto (dar uma olhada no builder (pro administrador) e no decorator)
3-SE DER TEMPO (tem que dar): Implementar interfaces para as views (menu,cadastrar,remover,etc) e cada view vai implementar os métodos dessa interface (override)
4-ACHO que LanchoneteMain fica fora de todos os packages do MVC
5-Remover o Herobrine
*/