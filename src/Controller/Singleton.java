
package Controller;

import DAO.FuncionarioDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;

public class Singleton {
   private static FuncionarioDAO instancia_funcionario = null;
   private static PedidoDAO instancia_pedido = null;
   private static ProdutoDAO instancia_produto = null; 
   
   private Singleton(){
       
   }
   
     public static FuncionarioDAO GetInstanciaFuncionario() {
        if (instancia_funcionario == null) {
            instancia_funcionario = new FuncionarioDAO();
        }
        return instancia_funcionario;
    }
    
     public static PedidoDAO GetInstanciaPedido() {
        if (instancia_pedido == null) {
            instancia_pedido = new PedidoDAO();
        }
        return instancia_pedido;
    }
     
      public static ProdutoDAO GetInstanciaProduto() {
        if (instancia_produto == null) {
            instancia_produto = new ProdutoDAO();
        }
        return instancia_produto;
    }
      
}
