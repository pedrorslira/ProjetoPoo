package Lanchonete.Controller;

import Lanchonete.DAO.ProdutoSingleton;
import Lanchonete.DAO.ProdutoBridge;

public class ProdutoFactory {

    public static ProdutoBridge TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1:
                return ProdutoSingleton.GetInstanciaProdutoArrayList();

            case 2:
                throw new UnsupportedOperationException();
            //return SingletonProduto.GetInstanciaProdutoArquivo();

            default:
                return null;
        }
    }

}
