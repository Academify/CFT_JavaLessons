
package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.FornecedorDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Fornecedor;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorControle {
    FornecedorDao fDao = new FornecedorDao();
    
    public void inserirFornecedor(Fornecedor forn) throws DaoException{
        
        try{
            fDao.inserir(forn);
        }catch(DaoException e){
            throw new DaoException("Erro no controle de inserir fornecedor");
        }
    }
    
    public void alterarFornecedor(int cod, Fornecedor forn) throws DaoException{
        if(validarCodFornecedor(cod)){
            try{
                fDao.alterar(cod, forn);
            }catch(DaoException e){
                throw new DaoException("Erro no controle de alterar fornecedor");
            }
        }
    }
    public void excluirFornecedor(int cod) throws DaoException{
        if(validarCodFornecedor(cod)){
            try{
                fDao.excluir(cod);
            }catch(DaoException e){
                throw new DaoException("Erro no método excluir fornecedor");
            }
        }
    }
    
    public List<Fornecedor> consultarTodos() throws DaoException{
        List<Fornecedor> listaForn = new ArrayList();
        listaForn = fDao.consultarTodos();
        return listaForn;
    }
    
    public List<Fornecedor> consultarPorNome(String nome) throws DaoException{
        List<Fornecedor> listaForn = new ArrayList();
        listaForn = fDao.consultarPorNome(nome);
        return listaForn;
    }
    
    public Fornecedor consultarPorCod(int cod) throws DaoException{
        Fornecedor forn = new Fornecedor();
        forn = fDao.consultarPorCod(cod);
        return forn;
    }
    private boolean validarCodFornecedor(int cod) throws DaoException {

        List<Fornecedor> listaForn = new ArrayList();
        boolean resposta = false;
        listaForn = fDao.consultarTodos();
        for (int i = 0; i < listaForn.size(); i++) {
            if (cod == listaForn.get(i).getCod()) {
                resposta = true;
                break;
            }
        }
        return resposta;
    }
}
