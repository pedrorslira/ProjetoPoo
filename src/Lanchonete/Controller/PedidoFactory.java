package Lanchonete.Controller;

import Lanchonete.DAO.PedidoDAO;

public class PedidoFactory {

     public enum Tipo{
        ARRAY_LIST,
        ARQUIVO
    }
    
    public static PedidoDAO TipoArmazenamento(Tipo t) {
        switch (t) {
            case ARRAY_LIST: 
                return PedidoDAO.GetInstanciaPedido();
            case ARQUIVO: 
                throw new UnsupportedOperationException();
            default:
                return null;
        }

    }

}
