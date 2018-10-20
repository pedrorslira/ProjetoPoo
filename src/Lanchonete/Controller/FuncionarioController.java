package Lanchonete.Controller;

import Lanchonete.Model.Funcionario;
import java.util.ArrayList;
import Lanchonete.DAO.FuncionarioBridge;

public class FuncionarioController {

    private FuncionarioBridge interfaceFuncionario;

    public FuncionarioController(int tipo) {
        this.interfaceFuncionario = FuncionarioFactory.TipoArmazenamento(tipo);
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
