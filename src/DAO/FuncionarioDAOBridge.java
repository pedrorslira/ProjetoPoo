package DAO;

import Model.Funcionario;
import java.util.ArrayList;

public interface FuncionarioDAOBridge {

    public void CadastrarFuncionario(Funcionario f);

    public int RemoverFuncionario(int numero);

    public Funcionario ConsultarFuncionario(int numero);

    public Funcionario ConsultarFuncionario(String cpf);

    public void AlterarFuncionario(int numero, Funcionario novoF);

    public ArrayList<Funcionario> ListarFuncionarios();
}
