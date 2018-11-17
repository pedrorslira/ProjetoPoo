package Lanchonete.Model.State;

import Lanchonete.Model.Pedido;

public class StatusNovo implements State {

        @Override
        public String estado(Pedido p) {
            p.setStatus(Status.NOVO);
            return "Novo Pedido em andamento";
        }
}
