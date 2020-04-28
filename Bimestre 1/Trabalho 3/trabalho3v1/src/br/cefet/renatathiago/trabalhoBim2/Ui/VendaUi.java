package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Controle.VendaControle;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class VendaUi {
    
    public static void testesVenda() throws DaoException, Exception{
        
        VendaControle vControle = new VendaControle();
        Venda vTeste = new Venda();
        List<Venda> listaComp = new ArrayList();
        List<ProdutoCV> listaProd = new ArrayList();
        List<ProdutoCV> listaProd2 = new ArrayList();
        ProdutoDao pDao = new ProdutoDao();
        ProdutoCV p = new ProdutoCV();
        List<ProdutoCV> listaProdutos = new ArrayList();
        
        Venda v = new Venda();
        v.setData("01/01/2001");
        v.setFormaPg("D");
        v.setCodCliente(2);
        p = pDao.deProdutoParaProdutoCVVenda( pDao.consultarPorCod(2), 50);
        listaProd.add(p);
        p = pDao.deProdutoParaProdutoCVVenda( pDao.consultarPorCod(3), 100);
        listaProd.add(p);
                
        Venda v2 = new Venda();
        v2.setData("02/02/2002");
        v2.setFormaPg("D");
        v2.setCodCliente(3);
        p = pDao.deProdutoParaProdutoCVVenda( pDao.consultarPorCod(3), 150);
        listaProd2.add(p);
        p = pDao.deProdutoParaProdutoCVVenda( pDao.consultarPorCod(2), 100);
        listaProd2.add(p);
        
        try{
            //INSERINDO OBJETOS
            vControle.inserirVenda(v, listaProd );
            vControle.inserirVenda(v2, listaProd2);
            vControle.inserirVenda(v, listaProd);
            vControle.inserirVenda(v2, listaProd2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            listaComp = vControle.consultarVendas();
            
            
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println("Data da Venda: " + listaComp.get(i).getData());
                System.out.println("Valor: " + listaComp.get(i).getValorTotal());
                System.out.println("Lista de Produtos: ");
                listaProdutos = vControle.consultarProdutos(listaComp.get(i).getCod());
                for (int j = 0; j<listaProdutos.size(); j++){
                    System.out.println("Produto: " + listaProdutos.get(j).getNome());
                    System.out.println("Quantidade " + listaProdutos.get(j).getQtd());
                }
                System.out.println("\n");
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            vControle.alterarVenda(1, v2);
            listaComp = vControle.consultarVendas();
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println(listaComp.get(i).getData());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            vTeste = vControle.consultarPorCod(2);
            System.out.println(vTeste.getData());
            
            //CONSULTANDO OBJETO POR Cliente
            System.out.println("\n Todos os objetos de Cliente de código 2");
            listaComp = vControle.consultarVendaPorCliente(2);
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println(listaComp.get(i).getData() + " de Cliente " + listaComp.get(i).getCodCliente());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            vControle.excluirVenda(1);
            listaComp = vControle.consultarVendas();
            for(int i= 0 ; i<listaComp.size(); i++){
                System.out.println(listaComp.get(i).getData());
            }
        } catch(DaoException e){
            throw new DaoException("Erro no método testesVenda");
        } catch(Exception e){
            throw new Exception("Erro no método testesVenda");
        }
    }
}
