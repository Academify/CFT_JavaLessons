package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Ui.JFrames.TelaBuscaJFrame;
import br.cefet.renatathiago.trabalhoBim2.Ui.JFrames.AdmJFrame;
import br.cefet.renatathiago.trabalhoBim2.Ui.JFrames.TelaInicialJFrame;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PrincipalUi {

    static Scanner scn = new Scanner(System.in);

    private static String resposta;
    private CompraUi compraUi = new CompraUi();
    private VendaUi vendaUi = new VendaUi();
    private AdmJFrame admJFrame = new AdmJFrame();
    private TelaBuscaJFrame buscaJFrame = new TelaBuscaJFrame();
    private TelaInicialJFrame inicialJFrame = new TelaInicialJFrame();

    public void TelaInicial(){
            inicialJFrame.telaInicial();
    }
}
