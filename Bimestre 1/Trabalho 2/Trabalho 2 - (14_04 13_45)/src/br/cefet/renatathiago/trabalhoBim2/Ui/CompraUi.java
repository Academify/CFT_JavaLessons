package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Controle.EstoqueControle;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class CompraUi {
    public static void testesCompra() throws DaoException, Exception{
        EstoqueControle estoque = new EstoqueControle();
        Compra coTeste = new Compra();
        List <Compra> ListaComp = new ArrayList();
        
        Compra c = new Compra();
        c.setData("01/01/2001");
        c.setFormaPg("D");
        c.setCodFornecedor(2);
        c.setValorTotal(100);
        // criar e preencher o list de produtosCV 
        
        Compra c2 = new Compra();
        c2.setData("02/01/2001");
        c2.setFormaPg("D");
        c2.setCodFornecedor(3);
        c2.setValorTotal(100);
        // criar e preencher o list de produtosCV 
        
        try{
            //INSERINDO OBJETOS
            estoque.inserirCompra(c);
            estoque.inserirCompra(c);
            estoque.inserirCompra(c2);
            estoque.inserirCompra(c2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaComp = estoque.consultarCompras();
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            estoque.alterarCompra(1, c2);
            ListaComp = estoque.consultarCompras();
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            coTeste = estoque.consultarCompraPorCod(2);
            System.out.println(coTeste.getData());
            
            //CONSULTANDO OBJETO POR FORNECEDOR
            System.out.println("\n Todos os objetos de Fornecedor de código 2");
            ListaComp = estoque.consultarCompraPorFornecedor(2);
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData() + " " + ListaComp.get(i).getCodFornecedor());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            estoque.excluirCompra(1);
            ListaComp = estoque.consultarCompras();
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData());
            }
        } catch(DaoException e){
            throw new DaoException("Erro no método testesCompra");
        } catch(Exception e){
            throw new Exception("Erro no método testesCompra");
        }
    }
}
