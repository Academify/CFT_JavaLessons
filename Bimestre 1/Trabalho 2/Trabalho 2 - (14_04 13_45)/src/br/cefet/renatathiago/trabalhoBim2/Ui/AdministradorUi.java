package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Dao.AdministradorDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorUi {
    
    public static void testesAdministrador() throws DaoException, Exception{
            
        AdministradorDao admDao = new AdministradorDao(); 
        Administrador aTeste = new Administrador();
        List<Administrador> listaAdm = new ArrayList();
            
        //CRIAR OBJETOS - ADM
        Administrador a = new Administrador();
        a.setNome("Thiago");
        a.setCpf("123");
        a.setEndereco("Rua pedronildo");
        a.setLogin("fon");
        a.setTelefone("12345678");
        a.setSenha("123");
        
        Administrador a2 = new Administrador();
        a2.setNome("Renata");
        a2.setCpf("123");
        a2.setEndereco("Rua");
        a2.setLogin("fon");
        a2.setTelefone("12345678");
        a2.setSenha("123");
        
        try{
            //INSERINDO OBJETOS
            admDao.inserir(a);
            admDao.inserir(a);
            admDao.inserir(a2);
            admDao.inserir(a2);
            
            
           // LISTANDO OBJETOS
            System.out.println("\nTodos os objetos\n");;
            listaAdm = admDao.consultarTodos();           
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            admDao.alterar(3, a);
            listaAdm = admDao.consultarTodos(); 
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //CONSULTANDO POR CÓDIGO
            System.out.println("\nTodos os objetos de código 2\n");
            aTeste = admDao.consultarPorCod(2);
            System.out.println(aTeste.getNome());
            
            //CONSULTANDO POR NOME
            System.out.println("\nTodos os objetos de nome Thiago\n");
            listaAdm = admDao.consultarPorNome("Thiago"); 
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //EXCLUINDO UM OBJETO
            System.out.println("\nTodos os objetos depois de excluir o de código 1\n");
            admDao.excluir(1);
            listaAdm = admDao.consultarTodos();
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
        } catch(DaoException e){
            throw new DaoException("Erro no método testarAdministrador");
        }catch(Exception e){
            throw new Exception("Erro no método testarAdministrador");
        }   
    }
}
