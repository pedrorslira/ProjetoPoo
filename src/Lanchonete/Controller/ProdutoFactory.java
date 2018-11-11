package Lanchonete.Controller;

import Lanchonete.DAO.ProdutoDAO;

public class ProdutoFactory {

    public static ProdutoDAO TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1: //ArrayList
                return ProdutoDAO.GetInstanciaProduto();
            case 2: //Arquivo
                throw new UnsupportedOperationException();
            default:
                return null;
        }

    }

}
