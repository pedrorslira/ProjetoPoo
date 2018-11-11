package Lanchonete.Controller;

import Lanchonete.Model.Pedido;
import java.util.ArrayList;
import Lanchonete.DAO.PedidoBridge;

public class PedidoController {

    private PedidoBridge interfacePedido;

    public PedidoController() {
        this.interfacePedido = PedidoFactory.TipoArmazenamento(1);
    }

    public void CadastrarPedido(Pedido p) {
        this.interfacePedido.Efetuar(p);
    }

    public int RemoverPedido(String cod) {
        return this.interfacePedido.Cancelar(cod);
    }

    public Pedido ConsultarPedido(String cod) {
        return this.interfacePedido.Consultar(cod);
    }

    public void AlterarPedido(String cod, Pedido novoP) {
        this.interfacePedido.Alterar(cod, novoP);
    }

    public ArrayList<Pedido> ListarPedidos() {
        return this.interfacePedido.Listar();
    }
}
