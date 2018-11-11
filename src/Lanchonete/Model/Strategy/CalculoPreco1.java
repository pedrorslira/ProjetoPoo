
package Lanchonete.Model.Strategy;

import Lanchonete.Model.Produto;


public class CalculoPreco1 implements Strategy {

    @Override
    public void aplicar(Produto produto) {
        double aux;
        aux = produto.getPeso() - 1.0;
        aux /= 0.1;           
        produto.setPreco(produto.getPreco() + (aux * 0.05));
    }
}
