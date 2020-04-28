package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.CategoriaDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Categoria;
import java.util.List;

public class CategoriaControle {

    CategoriaDao cDao;
    ObraControle oControle;
    private static CategoriaControle instance;

    public CategoriaControle(CategoriaDao cDao, ObraControle oControle) {
        this.cDao = cDao;
        this.oControle = oControle;
    }
    
    public static CategoriaControle getInstance(){
        if(instance == null){
            instance = new CategoriaControle();
        }
        return instance;
    }

    public CategoriaControle() {
        cDao = CategoriaDao.getInstance();
    }

    public String validaDados(Categoria c) {
        //valida todos os dados
        if (c.getNmCategoria() != null && c.getNmCategoria() instanceof String && !c.getNmCategoria().equals("")) {
            return "ok";
        } else {
            return "Erro de tipo do nome da categoria";
        }
    }

    public int inserir(Categoria c) throws DaoException, ControleException {
        
        int ret = -1;
        String valida = validaDados(c);

        if (valida.equalsIgnoreCase("ok")) {
            ret = cDao.inserir(c);
        } else {
            throw new ControleException("Erro ao inserir categoria:" + valida);
        }
        return ret;
    }

    public int alterar(Categoria c) throws DaoException, ControleException {
        
        int ret = 0;
        String valida = validaDados(c);

        if (valida.equalsIgnoreCase("ok")) {
            ret = cDao.alterar(c);
        } else {
            throw new ControleException("Erro ao inserir categoria:" + valida);
        }

        return ret;
    }

    public boolean excluir(int id) throws DaoException {
        oControle = new ObraControle();
        int ret = oControle.excluirPorCategoria(id);
        int ret2 = cDao.excluir(id);

        if (ret2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Categoria> consultaTudo() throws DaoException {
        List<Categoria> ret = cDao.consultaTudo();
        
//        for(int i=0; i<ret.size(); i++){
//            ret.get(i).setObras(oControle.consultaPorCategoria(ret.get(i).getCdCategoria()));
//        }
        return ret;
    }

    public List<Categoria> consultaPorNome(String nome) throws DaoException {
        oControle = ObraControle.getInstance();
        List<Categoria> ret = cDao.consultarPorNome(nome);
        
//        for(int i=0; i<ret.size(); i++){
//            ret.get(i).setObras(oControle.consultaPorCategoria(ret.get(i).getCdCategoria()));
//        }
        return ret;
    }

    public Categoria consultaPorCd(int cd) throws DaoException {
        Categoria ret = cDao.consultarPorCd(cd);
        oControle = ObraControle.getInstance();
//        if(ret != null)
//            ret.setObras(oControle.consultaPorCategoria(ret.getCdCategoria()));  
        
        return ret;
    }

}
