package Lanchonete.DAO;

import Lanchonete.Model.Pedido;
import java.util.ArrayList;

public interface PedidoBridge {

    public void Efetuar(Pedido p);

    public int Cancelar(String cod);

    public Pedido Consultar(String cod);

    public void Alterar(String cod, Pedido novoP);

    public ArrayList<Pedido> Listar();
}
