package br.cefet.renatathiago.trabalhoBim2.Excecoes;

public class DaoException extends Exception {
    
    public DaoException(String message) {
        super(message);
    }
    
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
