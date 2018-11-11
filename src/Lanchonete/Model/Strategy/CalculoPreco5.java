
package Lanchonete.Model.Strategy;

import Lanchonete.Model.Produto;


public class CalculoPreco5 implements Strategy {

    @Override
    public void aplicar(Produto produto) {
        double aux;
        aux = produto.getPeso() - 3.0;
        aux /= 0.1;           
        produto.setPreco(produto.getPreco() + (aux * 0.15));
    }
}

