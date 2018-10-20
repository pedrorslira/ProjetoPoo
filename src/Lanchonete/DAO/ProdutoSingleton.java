package Lanchonete.DAO;

public class ProdutoSingleton {

    private static ProdutoArrayList instancia_produto = null;

    private ProdutoSingleton() {

    }

    public static ProdutoArrayList GetInstanciaProdutoArrayList() {
        if (instancia_produto == null) {
            instancia_produto = new ProdutoArrayList();
        }
        return instancia_produto;
    }

    /*public static ProdutoArquivo GetInstanciaProdutoArquivo() {
        if (instancia_produto == null) {
            instancia_produto = new ProdutoArquivo();
        }
        return instancia_produto;
        
    }*/
}
