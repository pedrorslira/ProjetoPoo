package Lanchonete.DAO;

public class PedidoSingleton {

    private static PedidoArrayList instancia_pedido = null;

    private PedidoSingleton() {

    }

    public static PedidoArrayList GetInstanciaPedidoArrayList() {
        if (instancia_pedido == null) {
            instancia_pedido = new PedidoArrayList();
        }
        return instancia_pedido;
    }

    /*public static PedidoArquivo GetInstanciaPedidoArquivo() {
        if (instancia_pedido == null) {
            instancia_pedido = new PedidoArquivo();
        }
        return instancia_pedido;
        
    }*/
}
