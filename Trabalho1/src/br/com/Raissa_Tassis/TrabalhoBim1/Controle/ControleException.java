package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

public class ControleException extends Exception{
    
    public ControleException(String message) {
        super(message);
    }

    public ControleException(String message, Throwable cause) {
        super(message, cause);
    }
}
