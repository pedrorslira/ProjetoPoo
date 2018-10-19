package Controller;

import DAO.FuncionarioArrayList;

public class FuncionarioFactory {

    public enum TipoArmazenamento {
        ARRAY_LIST,
        ARQUIVO
    }

    public static FuncionarioArrayList TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1:
                return new FuncionarioArrayList();
                
            case 2:
                throw new UnsupportedOperationException(); //implementar só se der tempo
                
            default:
                throw new IllegalArgumentException("Tipo de armazenamento não existente");
        }
    }
}
