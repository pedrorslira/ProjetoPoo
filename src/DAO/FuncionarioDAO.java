package DAO;

import Model.Funcionario;

import java.util.ArrayList;

public class FuncionarioDAO implements FuncionarioDAOBridge {

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static FuncionarioDAO instancia = null;

    private FuncionarioDAO() {

    }

    public static FuncionarioDAO GetInstancia() {
        if (instancia == null) {
            instancia = new FuncionarioDAO();
        }
        return instancia;
    }

    @Override
    public Funcionario ConsultarFuncionario(int numero) { //Consulta pelo número do funcionário
        for (Funcionario f : funcionarios) {
            if (f.getNumero() == numero) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Funcionario ConsultarFuncionario(String cpf) { //Consulta pelo cpf do funcionário
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
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
    public int RemoverFuncionario(int numero) {
        Funcionario f = ConsultarFuncionario(numero);
        if (f != null) {
            funcionarios.remove(f);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void AlterarFuncionario(int numero, Funcionario novoF) {
        this.RemoverFuncionario(numero);
        this.CadastrarFuncionario(novoF);
    }

    @Override
    public ArrayList<Funcionario> ListarFuncionarios() {
        return funcionarios;
    }
}
