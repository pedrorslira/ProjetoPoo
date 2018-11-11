package Lanchonete.Controller;

import Lanchonete.Model.Produto;
import java.util.ArrayList;
import Lanchonete.DAO.ProdutoBridge;

public class ProdutoController {

    private ProdutoBridge interfaceProduto;

    public ProdutoController() {
        this.interfaceProduto = ProdutoFactory.TipoArmazenamento(1);
    }

    public void CadastrarProduto(Produto p) {
        this.interfaceProduto.Cadastrar(p);
    }

    public int RemoverProduto(String cod) {
        return this.interfaceProduto.Remover(cod);
    }

    public Produto ConsultarProduto(String cod) {
        return this.interfaceProduto.Consultar(cod);
    }

    public void AlterarProduto(String cod, Produto novoP) {
        this.interfaceProduto.Alterar(cod, novoP);
    }

    public ArrayList<Produto> ListarProdutos() {
        return this.interfaceProduto.Listar();
    }

    public int GetQuantidadeTotal() {
        return this.interfaceProduto.GetQuantidadeTotal();
    }

    public int ConsultarQtdProduto(String cod) {
        return this.interfaceProduto.ConsultarQtdProduto(cod);
    }
}
