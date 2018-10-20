package Lanchonete.DAO;

import Lanchonete.Model.Pedido;
import java.util.ArrayList;

public interface PedidoBridge {

    public void Efetuar(Pedido p);

    public int Cancelar(int cod);

    public Pedido Consultar(int cod);

    public void Alterar(int cod, Pedido novoP);

    public ArrayList<Pedido> Listar();
}
