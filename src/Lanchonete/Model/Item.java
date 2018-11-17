package Lanchonete.Model;

import java.util.ArrayList;

public class Item {

    private ArrayList<Produto> produto;
    private double quantidade;

    public Item(double quantidade) {
        this.produto = new ArrayList<>();
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public ArrayList<Produto> getProduto() {
        return produto;
    }

    public void setProduto(ArrayList<Produto> produto) {
        this.produto = produto;
    }

    public double PrecoTotalItem() {
        double preco_t = 0;
        for (Produto p : this.produto) {
            preco_t = p.getPreco() + p.getPrecoEmbalagem();
        }
        return preco_t;
    }

    public void AddProduto(Produto p) {
        this.produto.add(p);
    }
}
