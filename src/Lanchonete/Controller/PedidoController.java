package Lanchonete.Controller;

import Lanchonete.Model.Pedido;
import java.util.ArrayList;
import Lanchonete.DAO.PedidoBridge;

public class PedidoController {

    private PedidoBridge interfacePedido;

    public PedidoController(int tipo) {
        this.interfacePedido = PedidoFactory.TipoArmazenamento(tipo);
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
