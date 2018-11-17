package Lanchonete.DAO;

import Lanchonete.Model.Produto;
import java.util.ArrayList;

public interface ProdutoBridge {

    public void Cadastrar(Produto p);

    public int Remover(String cod);

    public Produto Consultar(String cod);

    public void Alterar(String cod, Produto novoP);

    public ArrayList<Produto> Listar();

    public int GetQuantidadeTotal();

    public int ConsultarQtdProduto(String cod);
}
