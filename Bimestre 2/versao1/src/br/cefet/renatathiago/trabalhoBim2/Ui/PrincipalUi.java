package br.cefet.renatathiago.trabalhoBim2.Ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PrincipalUi {

    static Scanner scn = new Scanner(System.in);

    private static String resposta;
    private AdministradorUi admUi = new AdministradorUi();
    private ClienteUi clienteUi = new ClienteUi();
    private CompraUi compraUi = new CompraUi();
    private FornecedorUi fornUi = new FornecedorUi();
    private ProdutoUi produtoUi = new ProdutoUi();
    private VendaUi vendaUi = new VendaUi();
    private AdmJFrame admJFrame = new AdmJFrame();
    private static MenuJFrame menuJFrame = new MenuJFrame();

    public void TelaBusca(){

            menuJFrame.telaBusca();
   
    }
}
