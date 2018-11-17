package Lanchonete.Model.Strategy;

import Lanchonete.Model.Produto;

public interface Strategy {
    
    public enum Categoria{
        LEVE, MEDIO, PESADO  
    }

    public void aplicar(Produto produto);

}
