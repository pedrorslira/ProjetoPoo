package Lanchonete.Controller;

import Lanchonete.DAO.ProdutoDAO;

public class ProdutoFactory {

     public enum Tipo{
        ARRAY_LIST,
        ARQUIVO
    }
    
    public static ProdutoDAO TipoArmazenamento(Tipo t) {
        switch (t) {
            case ARRAY_LIST:
                return ProdutoDAO.GetInstanciaProduto();
            case ARQUIVO: 
                throw new UnsupportedOperationException();
            default:
                return null;
        }

    }

}
