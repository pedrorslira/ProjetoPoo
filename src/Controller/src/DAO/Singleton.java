
package DAO;

public class Singleton {
   private static FuncionarioArrayList instancia_funcionario = null;
   private static PedidoArrayList instancia_pedido = null;
   private static ProdutoArrayList instancia_produto = null; 
   //lembrar de dividir em 3 singletons depois
   private Singleton(){
       
   }
   
     public static FuncionarioArrayList GetInstanciaFuncionario() {
        if (instancia_funcionario == null) {
            instancia_funcionario = new FuncionarioArrayList();
        }
        return instancia_funcionario;
    }
    
     public static PedidoArrayList GetInstanciaPedido() {
        if (instancia_pedido == null) {
            instancia_pedido = new PedidoArrayList();
        }
        return instancia_pedido;
    }
     
      public static ProdutoArrayList GetInstanciaProduto() {
        if (instancia_produto == null) {
            instancia_produto = new ProdutoArrayList();
        }
        return instancia_produto;
    }
      
}
