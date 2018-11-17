package Lanchonete.Model.Strategy;

import Lanchonete.Model.Produto;

public class CalculoPrecoLeve implements Strategy {

    
        @Override
        public void aplicar(Produto produto) {
            double aux;
            produto.setCategoria(Categoria.LEVE);
            aux = produto.getPeso() * 0.1;
            produto.setPrecoEmbalagem(produto.getPreco() * aux);
            produto.setPreco(produto.getPreco() + produto.getPrecoEmbalagem());
        }

}
