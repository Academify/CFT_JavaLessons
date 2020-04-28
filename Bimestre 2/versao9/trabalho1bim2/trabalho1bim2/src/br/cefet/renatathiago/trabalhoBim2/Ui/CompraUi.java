package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Controle.CompraControle;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class CompraUi {
    
    public static void testesCompra() throws DaoException, Exception{
        
        CompraControle cControle = new CompraControle();
        Compra coTeste = new Compra();
        List<Compra> listaComp = new ArrayList();
        List<ProdutoCV> listaProd = new ArrayList();
        List<ProdutoCV> listaProd2 = new ArrayList();
        ProdutoDao pDao = new ProdutoDao();
        ProdutoCV p = new ProdutoCV();
        List<ProdutoCV> listaProdutos = new ArrayList();
        
        Compra c = new Compra();
        c.setData("01/01/2001");
        c.setFormaPg("D");
        c.setCodFornecedor(2);
        p = pDao.deProdutoParaProdutoCVCompra( pDao.consultarPorCod(2), 50);
        listaProd.add(p);
        p = pDao.deProdutoParaProdutoCVCompra( pDao.consultarPorCod(3), 100);
        listaProd.add(p);
                
        Compra c2 = new Compra();
        c2.setData("02/02/2002");
        c2.setFormaPg("D");
        c2.setCodFornecedor(3);
        p = pDao.deProdutoParaProdutoCVCompra( pDao.consultarPorCod(3), 150);
        listaProd2.add(p);
        p = pDao.deProdutoParaProdutoCVCompra( pDao.consultarPorCod(2), 100);
        listaProd2.add(p);
        
        try{
            //INSERINDO OBJETOS
            cControle.inserirCompra(c, listaProd );
            cControle.inserirCompra(c2, listaProd2);
            cControle.inserirCompra(c, listaProd);
            cControle.inserirCompra(c2, listaProd2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            listaComp = cControle.consultarCompras();
            
            
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println("Data da Compra: " + listaComp.get(i).getData());
                System.out.println("Valor: " + listaComp.get(i).getValorTotal());
                System.out.println("Lista de Produtos: ");
                listaProdutos = cControle.consultarProdutos(listaComp.get(i).getCod());
                for (int j = 0; j<listaProdutos.size(); j++){
                    System.out.println("Produto: " + listaProdutos.get(j).getNome());
                    System.out.println("Quantidade " + listaProdutos.get(j).getQtd());
                }
                System.out.println("\n");
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            cControle.alterarCompra(1, c2);
            listaComp = cControle.consultarCompras();
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println(listaComp.get(i).getData());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            coTeste = cControle.consultarPorCod(2);
            System.out.println(coTeste.getData());
            
            //CONSULTANDO OBJETO POR FORNECEDOR
            System.out.println("\n Todos os objetos de Fornecedor de código 2");
            listaComp = cControle.consultarCompraPorFornecedor(2);
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println(listaComp.get(i).getData() + " de fornecedor " + listaComp.get(i).getCodFornecedor());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            cControle.excluirCompra(1);
            listaComp = cControle.consultarCompras();
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println(listaComp.get(i).getData());
            }
        } catch(DaoException e){
            throw new DaoException("Erro no método testesCompra");
        } catch(Exception e){
            throw new Exception("Erro no método testesCompra");
        }
    }
}
