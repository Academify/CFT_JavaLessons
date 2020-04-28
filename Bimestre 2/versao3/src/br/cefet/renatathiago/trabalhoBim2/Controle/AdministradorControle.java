package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.AdministradorDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.ControleException;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorControle {

    AdministradorDao aDao = new AdministradorDao();

    public void inserirAdministrador(Administrador adm) throws ControleException, DaoException {
        List<Administrador> listaAdm = new ArrayList();
        listaAdm = aDao.consultarTodos();
        boolean situacao = true;

        for (int i = 0; i < listaAdm.size(); i++) {
            if (adm.getEmail().equals(listaAdm.get(i).getEmail())) {
                situacao = false;
                break;
            }
            if (situacao == true) {
                aDao.inserir(adm);
            }
        }
    }

    public void alterarAdministrador(int cod, Administrador adm) throws DaoException {
        if (validarCodAdm(cod)) {
            try {
                aDao.alterar(cod, adm);
            } catch (DaoException e) {
                throw new DaoException("Erro no método alterar administrador", e);
            }
        }
    }
    
    public void excluirAdministrador(int cod) throws DaoException{
        
        if(validarCodAdm(cod)){
            try{
                aDao.excluir(cod);
            }catch(DaoException e){
                throw new DaoException("Erro no método excluir administrador");
            }
        }
    }
    public List<Administrador> consultarTodos() throws DaoException{
        List <Administrador> listaAdm = new ArrayList();
        listaAdm = aDao.consultarTodos();
        return listaAdm;
    }
    
    public List<Administrador> consultarPorNome(String nome) throws DaoException{
        List<Administrador> listaAdm = new ArrayList();
        listaAdm = aDao.consultarPorNome(nome);
        return listaAdm;
    }
    
    public Administrador consultarPorCod(int cod) throws DaoException{
        Administrador adm = new Administrador();
        
        if(validarCodAdm(cod)){
            adm = aDao.consultarPorCod(cod);
        }
        return adm;
    }

    private boolean validarCodAdm(int cod) throws DaoException {

        List<Administrador> listaAdm = new ArrayList();
        boolean resposta = false;
        listaAdm = aDao.consultarTodos();
        for (int i = 0; i < listaAdm.size(); i++) {
            if (cod == listaAdm.get(i).getCod()) {
                resposta = true;
                break;
            }
        }
        return resposta;
    }

    public int proximoCod() throws DaoException {
        try {
            return aDao.proximoCod();
        } catch (DaoException ex) {
            Logger.getLogger(AdministradorControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
