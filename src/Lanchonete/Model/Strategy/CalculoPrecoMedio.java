package Lanchonete.Model.Strategy;

import Lanchonete.Model.Produto;

public class CalculoPrecoMedio implements Strategy {

    @Override
    public void aplicar(Produto produto) {
        double aux;
        produto.setCategoria(Categoria.MEDIO);
        aux = produto.getPeso() * 0.2;
        produto.setPreco_embalagem(produto.getPreco() * aux);
    }
}
