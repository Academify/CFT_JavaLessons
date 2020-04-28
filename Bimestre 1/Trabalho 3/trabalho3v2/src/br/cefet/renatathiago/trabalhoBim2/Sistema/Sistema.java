package br.cefet.renatathiago.trabalhoBim2.Sistema;


import br.cefet.renatathiago.trabalhoBim2.Excecoes.ControleException;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import br.cefet.renatathiago.trabalhoBim2.Ui.PrincipalUi;


public class Sistema {

   public static void main(String[] args) throws ControleException, DaoException, Exception{
       
       boolean fim =false;
       
       while(fim != true){
          fim = PrincipalUi.MenuPrincipal();
       }
    }
}