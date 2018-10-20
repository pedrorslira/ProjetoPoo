package Lanchonete.DAO;

public class FuncionarioSingleton {

    private static FuncionarioArrayList instancia_funcionario = null;

    private FuncionarioSingleton() {

    }

    public static FuncionarioArrayList GetInstanciaFuncionarioArrayList() {
        if (instancia_funcionario == null) {
            instancia_funcionario = new FuncionarioArrayList();
        }
        return instancia_funcionario;
    }

    /*public static FuncionarioArquivo GetInstanciaFuncionarioArquivo() {
        if (instancia_funcionario == null) {
            instancia_funcionario = new FuncionarioArquivo();
        }
        return instancia_funcionario;
        
    }*/
}
