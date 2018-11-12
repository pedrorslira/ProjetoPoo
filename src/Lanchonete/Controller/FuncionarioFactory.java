package Lanchonete.Controller;

import Lanchonete.DAO.FuncionarioDAO;

public class FuncionarioFactory {

    public static FuncionarioDAO TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1: //ArrayList
                return FuncionarioDAO.GetInstanciaFuncionario();
            case 2: //Arquivo
                throw new UnsupportedOperationException();
            default:
                return null;
        }

    }
}
