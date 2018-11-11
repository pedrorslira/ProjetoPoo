package Lanchonete.DAO;

import Lanchonete.Model.Pedido;
import java.util.ArrayList;

public class PedidoDAO implements PedidoBridge {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private static PedidoDAO instancia_pedido = null;

    private PedidoDAO() {

    }

    public static PedidoDAO GetInstanciaPedido() {
        if (instancia_pedido == null) {
            instancia_pedido = new PedidoDAO();
        }
        return instancia_pedido;
    }

    @Override
    public Pedido Consultar(String cod) {
        for (Pedido p : pedidos) {
            if (p.getCodigo().equals(cod)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void Efetuar(Pedido p) {
        pedidos.add(p);
    }

    @Override
    public int Cancelar(String cod) {
        Pedido p = Consultar(cod);
        if (p != null) {
            pedidos.remove(p);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void Alterar(String cod, Pedido novoP) {
        this.Cancelar(cod);
        this.Efetuar(novoP);
    }

    @Override
    public ArrayList<Pedido> Listar() {
        return pedidos;

    }
}
