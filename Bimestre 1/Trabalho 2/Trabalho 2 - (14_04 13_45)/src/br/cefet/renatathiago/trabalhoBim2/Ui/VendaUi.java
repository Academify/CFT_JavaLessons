
package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Controle.EstoqueControle;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class VendaUi {
    public static void testesVenda() throws DaoException, Exception{
        EstoqueControle estoque = new EstoqueControle();
        Venda vTeste = new Venda();
        List <Venda> ListaV = new ArrayList();
        
        //CRIAR OBJETOS - VENDA
        
        Venda v = new Venda();
        v.setData("01/01/2001");
        v.setFormaPg("D");
        v.setCodCliente(2);
        v.setValorTotal(100);
        
        Venda v2 = new Venda();
        v2.setData("02/01/2001");
        v2.setFormaPg("D");
        v2.setCodCliente(3);
        v2.setValorTotal(100);
        
        try{
            //INSERINDO OBJETOS
            estoque.inserirVenda(v);
            estoque.inserirVenda(v);
            estoque.inserirVenda(v2);
            estoque.inserirVenda(v2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaV = estoque.consultarVendas();
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            estoque.alterarVenda(1, v2);
            ListaV = estoque.consultarVendas();
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            vTeste = estoque.consultarVendaPorCod(2);
            System.out.println(vTeste.getData());
            
            //CONSULTANDO OBJETO POR CLIENTE
            System.out.println("\n Todos os objetos de Cliente de código 2");
            ListaV = estoque.consultarVendasPorCliente(2);
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData() + " " + ListaV.get(i).getCodCliente());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            estoque.excluirVenda(1);
            ListaV = estoque.consultarVendas();
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData());
            }
        }catch(DaoException e){
            throw new DaoException("Erro no método testesVenda");
        }catch (Exception e){
            throw new Exception ("Erro no método testesVenda");
        }
    }
}
