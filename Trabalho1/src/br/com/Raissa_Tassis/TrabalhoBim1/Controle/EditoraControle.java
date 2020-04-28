package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.EditoraDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Editora;
import java.util.List;

public class EditoraControle {

    EditoraDao cDao;
    ObraControle oControle;
    private static EditoraControle instance;

    public EditoraControle(EditoraDao cDao, ObraControle oControle) {
        this.cDao = cDao;
        this.oControle = oControle;
    }
    
    public static EditoraControle getInstance(){
        if(instance == null){
            instance = new EditoraControle();
        }
        return instance;
    }

    public EditoraControle() {
        cDao = EditoraDao.getInstance();
    }

    public String validaDados(Editora c) {
        //valida todos os dados
        if (c.getNmEditora() != null && c.getNmEditora() instanceof String && !c.getNmEditora().equals("")) {
            return "ok";
        } else {
            return "Erro de tipo do nome da Editora";
        }
    }

    public int inserir(Editora c) throws DaoException, ControleException {
        
        int ret = -1;
        String valida = validaDados(c);

        if (valida.equalsIgnoreCase("ok")) {
            ret = cDao.inserir(c);
        } else {
            throw new ControleException("Erro ao inserir Editora:" + valida);
        }
        return ret;
    }

    public int alterar(Editora c) throws DaoException, ControleException {
        
        int ret = 0;
        String valida = validaDados(c);

        if (valida.equalsIgnoreCase("ok")) {
            ret = cDao.alterar(c);
        } else {
            throw new ControleException("Erro ao inserir Editora:" + valida);
        }

        return ret;
    }

    public boolean excluir(int id) throws DaoException {
        oControle = new ObraControle();
        int ret = oControle.excluirPorEditora(id);
        int ret2 = cDao.excluir(id);

        if (ret2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Editora> consultaTudo() throws DaoException {
        List<Editora> ret = cDao.consultaTudo();
        
//        for(int i=0; i<ret.size(); i++){
//            ret.get(i).setObras(oControle.consultaPorEditora(ret.get(i).getCdEditora()));
//        }
        return ret;
    }

    public List<Editora> consultaPorNome(String nome) throws DaoException {
        oControle = ObraControle.getInstance();
        List<Editora> ret = cDao.consultarPorNome(nome);
        
//        for(int i=0; i<ret.size(); i++){
//            ret.get(i).setObras(oControle.consultaPorEditora(ret.get(i).getCdEditora()));
//        }
        return ret;
    }

    public Editora consultaPorCd(int cd) throws DaoException {
        Editora ret = cDao.consultarPorCd(cd);
        oControle = ObraControle.getInstance();
//        if(ret != null)
//            ret.setObras(oControle.consultaPorEditora(ret.getCdEditora()));  
        
        return ret;
    }

}
