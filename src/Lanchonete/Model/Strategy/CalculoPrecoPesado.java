package Lanchonete.Model.Strategy;

import Lanchonete.Model.Produto;

public class CalculoPrecoPesado implements Strategy {


        @Override
        public void aplicar(Produto produto) {
            double aux;
            produto.setCategoria(Categoria.PESADO);
            aux = produto.getPeso() * 0.3;
            produto.setPrecoEmbalagem(produto.getPreco() * aux);
            produto.setPreco(produto.getPreco() + produto.getPrecoEmbalagem());
        }

}
