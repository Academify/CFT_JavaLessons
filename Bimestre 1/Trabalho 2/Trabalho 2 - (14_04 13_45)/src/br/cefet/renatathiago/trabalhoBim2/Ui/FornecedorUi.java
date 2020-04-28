
package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Dao.FornecedorDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Fornecedor;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorUi {
    public static void testesFornecedor() throws DaoException, Exception{
        FornecedorDao fDao = new FornecedorDao();
        Fornecedor fTeste = new Fornecedor();
        List <Fornecedor> ListaForn = new ArrayList();
        
        //CRIAR OBJETOS - FORNECEDOR
        
        Fornecedor f = new Fornecedor();
        f.setCnpj("123");
        f.setNome("Batatas");
        f.setTelefone("9898");
        
        Fornecedor f2 = new Fornecedor();
        f2.setNome("Tomates");
        f2.setCnpj("456");
        f2.setTelefone("7845");
        
        try{
            //INSERINDO OBJETOS
            fDao.inserir(f);
            fDao.inserir(f);
            fDao.inserir(f2);
            fDao.inserir(f2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaForn = fDao.consultarTodos();
            for(int i = 0; i< ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS 
            System.out.println("\nTodos os objetos depois de alterar\n");
            fDao.alterar(3, f);
            ListaForn = fDao.consultarTodos();
            for(int i = 0; i<ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
            
            //CONSULTANDO POR CÓDIGO
            System.out.println("\nTodos os objetos de código 4\n");
            fTeste = fDao.consultarPorCod(4);
            System.out.println(fTeste.getNome());
            
            //CONSULTANDO POR NOME
            System.out.println("\n Todos os objetos de nome Batatas");
            ListaForn = fDao.consultarPorNome("Batatas");
            for(int i=0; i<ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
            
            //ECLUINDO UM OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            fDao.excluir(1);
            ListaForn = fDao.consultarTodos();
            for(int i =0; i<ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
        } catch(DaoException e){
            throw new DaoException("Erro no método testesFornecedor");
        } catch(Exception e){
            throw new Exception("Erro no método testesFornecedor");
        }
    }
}
