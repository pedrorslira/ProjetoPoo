package Lanchonete.Controller;

import Lanchonete.DAO.PedidoDAO;

public class PedidoFactory {

    public static PedidoDAO TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1: //ArrayList
                return PedidoDAO.GetInstanciaPedido();
            case 2: //Arquivo
                throw new UnsupportedOperationException();
            default:
                return null;
        }

    }

}
