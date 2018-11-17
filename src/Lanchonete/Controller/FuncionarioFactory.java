package Lanchonete.Controller;

import Lanchonete.DAO.FuncionarioDAO;

public class FuncionarioFactory {

    public enum Tipo{
        ARRAY_LIST,
        ARQUIVO
    }
    
    public static FuncionarioDAO TipoArmazenamento (Tipo t) {
        switch (t) {
            case ARRAY_LIST: 
                return FuncionarioDAO.GetInstanciaFuncionario();
            case ARQUIVO: 
                throw new UnsupportedOperationException();
            default:
                return null;
        }

    }
}
