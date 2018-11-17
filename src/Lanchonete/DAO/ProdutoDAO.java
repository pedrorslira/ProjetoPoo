package Lanchonete.DAO;

import Lanchonete.Model.Produto;
import java.util.ArrayList;

public class ProdutoDAO implements ProdutoBridge {

    private ArrayList<Produto> produtos = new ArrayList<>();

    private static ProdutoDAO instancia_produto = null;

    private ProdutoDAO() {

    }

    public static ProdutoDAO GetInstanciaProduto() {
        if (instancia_produto == null) {
            instancia_produto = new ProdutoDAO();
        }
        return instancia_produto;
    }

    @Override
    public Produto Consultar(String cod) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(cod)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void Cadastrar(Produto p) {
        produtos.add(p);
    }

    @Override
    public int Remover(String cod) {
        Produto p = Consultar(cod);
        if (p != null) {
            produtos.remove(p);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void Alterar(String cod, Produto novoP) {
        this.Remover(cod);
        this.Cadastrar(novoP);
    }

    @Override
    public ArrayList<Produto> Listar() {
        return produtos;
    }

    @Override
    public int GetQuantidadeTotal() {
        return produtos.size();
    }

    @Override
    public int ConsultarQtdProduto(String cod) {
        int qtd = 0;
        for (Produto p : produtos) {
            if (p.getCodigo().equals(cod)) {
                qtd++;
            }
        }
        return qtd;
    }
}
