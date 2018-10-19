package DAO;

import Model.Produto;
import java.util.ArrayList;

public class ProdutoArrayList implements ProdutoDAOBridge {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public ProdutoArrayList() {

    }

    @Override
    public Produto Consultar(int cod) {
        for (Produto p : produtos) {
            if (p.getCodigo() == cod) {
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
    public int Remover(int cod) {
        Produto p = Consultar(cod);
        if (p != null) {
            produtos.remove(p);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void Alterar(int cod, Produto novoP) {
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
    public int ConsultarQtdProduto(int cod) {
        int qtd = 0;
        for (Produto p : produtos) {
            if (p.getCodigo() == cod) {
                qtd++;
            }
        }
        return qtd;
    }
}
