package Lanchonete.Controller;

import Lanchonete.DAO.PedidoSingleton;
import Lanchonete.DAO.PedidoBridge;

public class PedidoFactory {

    public static PedidoBridge TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1:
                return PedidoSingleton.GetInstanciaPedidoArrayList();

            case 2:
                throw new UnsupportedOperationException();
            //return SingletonPedido.GetInstanciaPedidoArquivo();

            default:
                return null;
        }
    }

}
