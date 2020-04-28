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
    private AdministradorUi admUi = new AdministradorUi();
    private ClienteUi clienteUi = new ClienteUi();
    private CompraUi compraUi = new CompraUi();
    private FornecedorUi fornUi = new FornecedorUi();
    private ProdutoUi produtoUi = new ProdutoUi();
    private VendaUi vendaUi = new VendaUi();
    private AdmJFrame admJFrame = new AdmJFrame();
    private TelaBuscaJFrame buscaJFrame = new TelaBuscaJFrame();
    private TelaInicialJFrame inicialJFrame = new TelaInicialJFrame();

    public void TelaInicial(){
            inicialJFrame.telaInicial();
    }
    public void TelaBusca(){
            buscaJFrame.telaBusca();
    }
}
