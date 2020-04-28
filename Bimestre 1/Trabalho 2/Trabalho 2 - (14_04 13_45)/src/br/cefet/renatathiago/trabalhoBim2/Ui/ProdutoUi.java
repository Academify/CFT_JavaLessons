package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoUi {
    public static void testesProduto() throws DaoException, Exception{
        ProdutoDao pDao = new ProdutoDao();
        Produto pTeste = new Produto();
        List <Produto> ListaProd = new ArrayList();
        
        //CRIAR OBJETOS - PRODUTO
        
        Produto p = new Produto();
        p.setNome("Cenoura kg");
        p.setMarca("Cenourinhas");
        p.setPreco(2.90);
        p.setQtdEstoque(70);
        
        Produto p2 = new Produto();
        p2.setNome("Ropolho kg");
        p2.setMarca("Repolhinho");
        p2.setPreco(2.50);
        p2.setQtdEstoque(50);
        
        try{
           //INSERINDO OBJETOS
            pDao.inserir(p);
            pDao.inserir(p);
            pDao.inserir(p2);
            pDao.inserir(p2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaProd = pDao.consultarTodos();
            for(int i= 0 ; i<ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            pDao.alterar(1,p2);
            ListaProd = pDao.consultarTodos();
            for(int i=0; i<ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            pTeste = pDao.consultarPorCod(2);
            System.out.println(pTeste.getNome());
            
            //CONSULTANDO OBJETO POR NOME
            System.out.println("\n Todos os objetos de nome Cenoura");
            ListaProd = pDao.consultarPorNome("Cenoura kg");
            for(int i =0; i<ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            pDao.excluir(1);
            ListaProd = pDao.consultarTodos();
            for(int i =0; i< ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            } 
        } catch (DaoException e){
            throw new DaoException("Erro no método testesProduto");
        }catch (Exception e){
            throw new Exception("Erro no método testesProduto");
        }
    }
}
