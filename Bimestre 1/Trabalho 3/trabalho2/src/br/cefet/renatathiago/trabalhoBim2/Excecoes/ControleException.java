package br.cefet.renatathiago.trabalhoBim2.Excecoes;

public class ControleException extends Exception {
    
    public ControleException(String message) {
        super(message);
    }
    
    public ControleException(String message, Throwable cause) {
        super(message, cause);
    }
}
