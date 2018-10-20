package Controller;

import DAO.Singleton;
import Model.Funcionario;
import DAO.FuncionarioDAOBridge;
import java.util.ArrayList;

public class FuncionarioController {

    private FuncionarioDAOBridge interfaceFuncionario;

    public FuncionarioController() {
        this.interfaceFuncionario = Singleton.GetInstanciaFuncionario(); 
    }

    public void CadastrarNovoFuncionario(Funcionario f) {
        this.interfaceFuncionario.CadastrarFuncionario(f);
    }

    public int RemoverUmFuncionario(int numero) {
        return this.interfaceFuncionario.RemoverFuncionario(numero);
    }

    public Funcionario ConsultarUmFuncionario(int numero) {
        return this.interfaceFuncionario.ConsultarFuncionario(numero);
    }

    public Funcionario ConsultarUmFuncionario(String cpf) {
        return this.interfaceFuncionario.ConsultarFuncionario(cpf);
    }

    public void AlterarDadosFuncionario(int numero, Funcionario novoF) {
        this.interfaceFuncionario.AlterarFuncionario(numero, novoF);
    }

    public ArrayList<Funcionario> ListarFuncionariosNoCadastro() {
        return this.interfaceFuncionario.ListarFuncionarios();
    }
}
