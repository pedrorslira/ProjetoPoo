package Lanchonete;

import Lanchonete.Model.Administrador;
import Lanchonete.View.FuncionarioView;
import Lanchonete.View.ProdutoView;
import Lanchonete.View.PedidoView;

import java.util.Scanner;
import Lanchonete.View.Telas;

public class LanchoneteMain {

    public static void main(String[] args) {
        int op;
        String input;
        Scanner in = new Scanner(System.in);
        Telas interface_views;
        Administrador admin = new Administrador();
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
                    interface_views = new ProdutoView();
                    interface_views.Menu();
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
                    interface_views = new FuncionarioView();
                    interface_views.Menu();
                    break;
                case 3:
                    interface_views = new PedidoView();
                    interface_views.Menu();
                    break;
                default:
                    break;
            }
        } while (op != 4);
    }
}


 
