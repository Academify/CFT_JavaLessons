
package br.cefet.renatathiago.trabalhoBim2.Ui;

import br.cefet.renatathiago.trabalhoBim2.Dao.ClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class ClienteUi {
    public static void testesCliente() throws DaoException, Exception{
        
        ClienteDao clDao = new ClienteDao();
        Cliente cTeste = new Cliente();
        List <Cliente> ListaCli = new ArrayList();
        
        //CRIAR OBJETOS - CLIENTE
        
        Cliente cl = new Cliente();
        cl.setEndereco("Rua 5, nº 12, Bairro da Luz, Cidade da Luz");
        cl.setNome("Jair");
        cl.setTelefone("031988557622");
        cl.setDocumento("02186783630");
        cl.setTipoCliente("F");
        
        Cliente cl2 = new Cliente();
        cl2.setNome("Luiz Inácio");
        cl2.setTelefone("985376046");
        cl.setEndereco("Rua 6, nº 12, Bairro das Trevas, Cidade das Trevas");
        cl2.setTipoCliente("F");
        cl2.setDocumento("12331026645");
        
        try{
            //INSERINDO OBJETOS
            clDao.inserir(cl);
            clDao.inserir(cl);
            clDao.inserir(cl2);
            clDao.inserir(cl2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaCli = clDao.consultarTodos();
            for(int i=0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            clDao.alterar(2, cl2);
            ListaCli = clDao.consultarTodos();
            for(int i=0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
            
            //CONSULTANDO POR CÓDIGO
            System.out.println("\nTodos os objetos de código 1\n");
            cTeste = clDao.consultarPorCod(1);
            System.out.println(cTeste.getNome());
            
            //CONSULTANDO OBJETO POR NOME
            System.out.println("\n Todos os objetos de nome Kréber");
            ListaCli = clDao.consultarPorNome("Kréber");
            for(int i = 0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            clDao.excluir(1);
            ListaCli = clDao.consultarTodos();
            for(int i = 0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
        } catch(DaoException e){
            throw new DaoException("Erro no método testesClientes");
        }catch (Exception e){
            throw new Exception("Erro no método testesClientes");
        }
    }
}
