package Lanchonete.DAO;

import Lanchonete.Model.Funcionario;

import java.util.ArrayList;

public class FuncionarioDAO implements FuncionarioBridge {

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    private static FuncionarioDAO instancia_funcionario = null;

    private FuncionarioDAO() {

    }

    public static FuncionarioDAO GetInstanciaFuncionario() {
        if (instancia_funcionario == null) {
            instancia_funcionario = new FuncionarioDAO();
        }
        return instancia_funcionario;
    }

    @Override
    public Funcionario ConsultarFuncionario(String codigo) {
        for (Funcionario f : funcionarios) {
            if (f.getCodigo().equals(codigo)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void CadastrarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    @Override
    public int RemoverFuncionario(String codigo) {
        Funcionario f = ConsultarFuncionario(codigo);
        if (f != null) {
            funcionarios.remove(f);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void AlterarFuncionario(String codigo, Funcionario novoF) {
        this.RemoverFuncionario(codigo);
        this.CadastrarFuncionario(novoF);
    }

    @Override
    public ArrayList<Funcionario> ListarFuncionarios() {
        return funcionarios;
    }
}
