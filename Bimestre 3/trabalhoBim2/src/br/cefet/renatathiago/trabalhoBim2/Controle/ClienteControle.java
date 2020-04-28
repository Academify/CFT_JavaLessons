
package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.ClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteControle {
    ClienteDao clDao = new ClienteDao();
    public void inserirCliente(Cliente cli) throws DaoException{
       
        try{
            clDao.inserir(cli);
        }catch(DaoException e){
            throw new DaoException("Erro no controle de inserir cliente");
        }
        
    }
    
    public void alterarCliente(int cod, Cliente cli) throws DaoException{
        if(validarCodCliente(cod)){
            try{
                clDao.alterar(cod, cli);
            }catch(DaoException e){
                throw new DaoException("Erro no controle de alterar cliente");
            }
        }
    }
    
    public void excluirCliente(int cod) throws DaoException{
        if(validarCodCliente(cod)){
            try{
                clDao.excluir(cod);
            }catch(DaoException e){
                throw new DaoException("Erro no método excluir cliente");
            }
        }
    }
    
    public List<Cliente> consultarTodos() throws DaoException{
        List<Cliente> listaCli = new ArrayList();
        listaCli = clDao.consultarTodos();
        return listaCli;
    }
    
    public List<Cliente> consultarPorNome(String nome) throws DaoException{
        List<Cliente> listaCli = new ArrayList();
        listaCli = clDao.consultarPorNome(nome);
        return listaCli;
    }
    
    public Cliente consultarPorCod(int cod) throws DaoException{
        Cliente cli = new Cliente();
        cli = clDao.consultarPorCod(cod);
        return cli;
    }
    
    private boolean validarCodCliente(int cod) throws DaoException {

        List<Cliente> listaCli = new ArrayList();
        boolean resposta = false;
        listaCli = clDao.consultarTodos();
        for (int i = 0; i < listaCli.size(); i++) {
            if (cod == listaCli.get(i).getCod()) {
                resposta = true;
                break;
            }
        }
        return resposta;
    }
        public int proximoCod() throws DaoException {
            return clDao.proximoCod();
    }
}
