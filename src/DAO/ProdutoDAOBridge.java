package DAO;

import Model.Produto;
import java.util.ArrayList;

public interface ProdutoDAOBridge {

    public void Cadastrar(Produto p);

    public int Remover(int cod);

    public Produto Consultar(int cod);

    public void Alterar(int cod, Produto novoP);

    public ArrayList<Produto> Listar();

    public int GetQuantidadeTotal();

    public int ConsultarQtdProduto(int cod);
}
