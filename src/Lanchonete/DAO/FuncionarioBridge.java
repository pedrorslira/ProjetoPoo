package Lanchonete.DAO;

import Lanchonete.Model.Funcionario;
import java.util.ArrayList;

public interface FuncionarioBridge {

    public void CadastrarFuncionario(Funcionario f);

    public int RemoverFuncionario(int numero);

    public Funcionario ConsultarFuncionario(int numero);

    public Funcionario ConsultarFuncionario(String cpf);

    public void AlterarFuncionario(int numero, Funcionario novoF);

    public ArrayList<Funcionario> ListarFuncionarios();
}
