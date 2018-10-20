package Controller;

import DAO.FuncionarioDAOBridge;
import DAO.FuncionarioArrayList;

public class FuncionarioFactory {

    public static FuncionarioDAOBridge TipoArmazenamento(int tipo) {
        switch (tipo) {
            case 1:
                return new FuncionarioArrayList();

            case 2:
                throw new UnsupportedOperationException(); //implementar só se der tempo

            default:
                return null;
        }
    }
}
