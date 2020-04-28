package br.cefet.renatathiago.trabalhoBim2.Ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PrincipalUi {

    static Scanner scn = new Scanner(System.in);

    static String resposta;
    AdministradorUi admUi = new AdministradorUi();
    ClienteUi clienteUi = new ClienteUi();
    CompraUi compraUi = new CompraUi();
    FornecedorUi fornUi = new FornecedorUi();
    ProdutoUi produtoUi = new ProdutoUi();
    VendaUi vendaUi = new VendaUi();

    public static void MenuPrincipal() throws Exception {
        do {
            resposta = JOptionPane.showInputDialog("---------------------Menu Principal-----------------------\n "
                    + "Qual teste realizar?\n\n "
                    + "1- Testes Administrador \n "
                    + "2- Testes Clientes \n"
                    + "3- Testes Fornecedor \n"
                    + "4- Testes Compra \n"
                    + "5- Testes Produto \n"
                    + "6- Testes Venda \n"
                    + "7- Sair");

            try{    
                switch (resposta) {
                    case "1":
                        AdministradorUi.testesAdministrador();
                        break;
                    case "2":
                        ClienteUi.testesCliente();
                        break;
                    case "3":
                        FornecedorUi.testesFornecedor();
                        break;
                    case "4":
                        CompraUi.testesCompra();
                        break;
                    case "5":
                        ProdutoUi.testesProduto();
                        break;
                    case "6":
                        VendaUi.testesVenda();
                        break;
                    case "7":
                        System.out.println("Bye Bye!");
                    default:
                        System.out.println("Opcão inválida");    
                }
            }catch(InputMismatchException e){
		System.out.println("Valor inválido");
		scn.next();  
            }    

        } while (!resposta.equals("7"));
    }
}
