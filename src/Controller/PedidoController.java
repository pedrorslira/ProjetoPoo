package Controller;

import Model.Pedido;
import DAO.PedidoDAOBridge;
import java.util.ArrayList;

public class PedidoController {

    private PedidoDAOBridge interfacePedido;

    public PedidoController() {
        this.interfacePedido = Singleton.GetInstanciaPedido();
    }

    public void CadastrarPedido(Pedido p) {
        this.interfacePedido.Efetuar(p);
    }

    public int RemoverPedido(int cod) {
        return this.interfacePedido.Cancelar(cod);
    }

    public Pedido ConsultarPedido(int cod) {
        return this.interfacePedido.Consultar(cod);
    }

    public void AlterarPedido(int cod, Pedido novoP) {
        this.interfacePedido.Alterar(cod, novoP);
    }

    public ArrayList<Pedido> ListarPedidos() {
        return this.interfacePedido.Listar();
    }
}
