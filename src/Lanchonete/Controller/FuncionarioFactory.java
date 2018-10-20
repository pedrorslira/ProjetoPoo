package Lanchonete.Controller;

import Lanchonete.DAO.FuncionarioSingleton;
import Lanchonete.DAO.FuncionarioBridge;

public class FuncionarioFactory {

    public static FuncionarioBridge TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1:
                return FuncionarioSingleton.GetInstanciaFuncionarioArrayList();

            case 2:
                throw new UnsupportedOperationException();
                //return SingletonFuncionario.GetInstanciaFuncionarioArquivo();

            default:
                return null;
        }
    }
}
