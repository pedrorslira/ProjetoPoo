package Lanchonete.Controller;

import Lanchonete.Model.Funcionario;
import java.util.ArrayList;
import Lanchonete.DAO.FuncionarioBridge;

public class FuncionarioController {

    private FuncionarioBridge interfaceFuncionario;

    public FuncionarioController() {
        this.interfaceFuncionario = FuncionarioFactory.TipoArmazenamento(1);
    }

    public void CadastrarFuncionario(Funcionario f) {
        this.interfaceFuncionario.CadastrarFuncionario(f);
    }

    public int RemoverFuncionario(String codigo) {
        return this.interfaceFuncionario.RemoverFuncionario(codigo);
    }

    public Funcionario ConsultarFuncionario(String codigo) {
        return this.interfaceFuncionario.ConsultarFuncionario(codigo);
    }

    public void AlterarFuncionario(String codigo, Funcionario novoF) {
        this.interfaceFuncionario.AlterarFuncionario(codigo, novoF);
    }

    public ArrayList<Funcionario> ListarFuncionarios() {
        return this.interfaceFuncionario.ListarFuncionarios();
    }
}
