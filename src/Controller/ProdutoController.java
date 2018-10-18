package Controller;

import Model.Produto;
import DAO.ProdutoDAOBridge;
import java.util.ArrayList;

public class ProdutoController {

    private ProdutoDAOBridge interfaceProduto;

    public ProdutoController() {
        this.interfaceProduto = Singleton.GetInstanciaProduto(); //talvez implementar factory pra cá e singleton pra outro lugar (no 2ºGQ)
    }

    public void CadastrarProduto(Produto p) {
        this.interfaceProduto.Cadastrar(p);
    }

    public int RemoverProduto(int cod) {
        return this.interfaceProduto.Remover(cod);
    }

    public Produto ConsultarProduto(int cod) {
        return this.interfaceProduto.Consultar(cod);
    }

    public void AlterarProduto(int cod, Produto novoP) {
        this.interfaceProduto.Alterar(cod, novoP);
    }

    public ArrayList<Produto> ListarProdutos() {
        return this.interfaceProduto.Listar();
    }

    public int GetQuantidadeTotal() {
        return this.interfaceProduto.GetQuantidadeTotal();
    }

    public int ConsultarQtdProduto(int cod) {
        return this.interfaceProduto.ConsultarQtdProduto(cod);
    }
}
