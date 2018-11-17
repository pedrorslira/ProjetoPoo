package Lanchonete.Model.State;

import Lanchonete.Model.Pedido;

public class StatusEfetuado implements State {
 
        @Override
        public String estado(Pedido p) {
            p.setStatus(Status.EFETUADO);
            return "Pedido Efetuado";
        }
}
