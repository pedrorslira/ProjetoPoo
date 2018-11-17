package Lanchonete.Model.State;

import Lanchonete.Model.Pedido;

public class StatusAlterado implements State {
    
        @Override
        public String estado(Pedido p) {
            p.setStatus(Status.ALTERADO);
            return "Pedido Alterado";
        }
    
}
