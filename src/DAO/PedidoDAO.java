package DAO;

import Model.Pedido;
import java.util.ArrayList;

public class PedidoDAO implements PedidoDAOBridge {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public PedidoDAO() {

    }

    @Override
    public Pedido Consultar(int cod) {
        for (Pedido p : pedidos) {
            if (p.getCodigo() == cod) {
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
    public int Cancelar(int cod) {
        Pedido p = Consultar(cod);
        if (p != null) {
            pedidos.remove(p);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void Alterar(int cod, Pedido novoP) {
        this.Cancelar(cod);
        this.Efetuar(novoP);
    }

    @Override
    public ArrayList<Pedido> Listar() {
        return pedidos;

    }
}
