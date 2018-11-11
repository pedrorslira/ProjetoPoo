package Lanchonete.Model;

public class StatusNovo implements Status {

    @Override
    public String estado() {
        return "Novo Pedido em andamento";
    }
}
