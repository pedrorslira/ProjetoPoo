package DAO;

import Model.Pedido;
import java.util.ArrayList;

public interface PedidoDAOBridge {

    public void Efetuar(Pedido p);

    public int Cancelar(int cod);

    public Pedido Consultar(int cod);

    public void Alterar(int cod, Pedido novoP);

    public ArrayList<Pedido> Listar();
}
