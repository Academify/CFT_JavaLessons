package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Controle.EstoqueControle;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class CompraUi {
    
    public static void testesCompra() throws DaoException, Exception{
        
        ProdutoDao pDao = new ProdutoDao();
        EstoqueControle estoque = new EstoqueControle();
        Compra coTeste = new Compra();
        List <Compra> ListaComp = new ArrayList();
        
        Compra c = new Compra();
        c.setData("01/01/2001");
        c.setFormaPg("D");
        c.setCodFornecedor(2);
        List<ProdutoCV> listaP1 = new ArrayList();
        ProdutoCV pcv = new ProdutoCV();
        pcv = pDao.consultarPorCod(3);
        ProdutoCV pcv2 = new ProdutoCV();
        pcv2 = pDao.deProdutoParaProdutoCVCompra(pDao.consultarPorCod(2), 15);
        listaP1.add(pcv);
        listaP1.add(pcv2);
        c.setListaP(listaP1);
                
        Compra c2 = new Compra();
        c2.setData("02/01/2001");
        c2.setFormaPg("D");
        c2.setCodFornecedor(3);
        List<ProdutoCV> listaP2 = new ArrayList();
        ProdutoCV pcv3 = new ProdutoCV();
        pcv3 = pDao.deProdutoParaProdutoCVCompra(pDao.consultarPorCod(3), 11);
        ProdutoCV pcv4 = new ProdutoCV();
        pcv4 = pDao.deProdutoParaProdutoCVCompra(pDao.consultarPorCod(2), 17);
        listaP2.add(pcv3);
        listaP2.add(pcv4);  
        c2.setListaP(listaP2);
        
        try{
            //INSERINDO OBJETOS
            estoque.inserirCompra(c);
            estoque.inserirCompra(c2);
            estoque.inserirCompra(c);
            estoque.inserirCompra(c2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaComp = estoque.consultarCompras();
            
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println("Data da Compra: " + ListaComp.get(i).getData());
                System.out.println("Valor: " + ListaComp.get(i).getValorTotal());
                System.out.println("Lista de Produtos: ");
                for (int j = 0; j<ListaComp.get(i).getListaP().size(); j++){
                    System.out.println("Produto: " + ListaComp.get(i).getListaP().get(j).getNome());
                    System.out.println("Quantidade " + ListaComp.get(i).getListaP().get(j).getQtd());
                }
                System.out.println("\n");
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
                System.out.println(ListaComp.get(i).getData() + " de fornecedor " + ListaComp.get(i).getCodFornecedor());
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
