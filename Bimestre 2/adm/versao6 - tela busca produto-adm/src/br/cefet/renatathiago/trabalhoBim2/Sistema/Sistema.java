package br.cefet.renatathiago.trabalhoBim2.Sistema;


import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Ui.PrincipalUi;


public class Sistema {

   public static void main(String[] args) throws DaoException, Exception{
       
       PrincipalUi principalUi = new PrincipalUi();
       principalUi.TelaInicial();
    }
}