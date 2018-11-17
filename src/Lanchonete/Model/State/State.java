package Lanchonete.Model.State;

import Lanchonete.Model.Pedido;

public interface State {

    public enum Status{
        NOVO,EFETUADO,ALTERADO
    }
    
    public String estado(Pedido p);
}
