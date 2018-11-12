package Lanchonete.DAO;

import Lanchonete.Model.Funcionario;
import java.util.ArrayList;

public interface FuncionarioBridge {

    public void CadastrarFuncionario(Funcionario f);

    public int RemoverFuncionario(String codigo);

    public Funcionario ConsultarFuncionario(String codigo);

    public void AlterarFuncionario(String codigo, Funcionario novoF);

    public ArrayList<Funcionario> ListarFuncionarios();
}
