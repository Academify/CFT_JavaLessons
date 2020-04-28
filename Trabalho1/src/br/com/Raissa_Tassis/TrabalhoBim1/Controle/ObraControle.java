package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.ObraDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Categoria;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Editora;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Obra;
import java.util.List;

public class ObraControle {

    private ObraDao oDao;
    private HqControle hqControle;
    private static ObraControle instance;
    
    public static ObraControle getInstance(){
        if(instance == null){
            instance = new ObraControle();
        }
        return instance;
    }
    
    public ObraControle(ObraDao oDao, HqControle hqControle) {
        this.oDao = oDao;
        this.hqControle = hqControle;
    }

    public ObraControle() {
        this.oDao = ObraDao.getInstance();
    }

    

    public String validaDados(Obra o) {
        //valida todos os dados
        if (o.getNmObra() != null && o.getNmObra() instanceof String) {
        } else {
            return "Erro de tipo do nome da categoria";
        }   
        return "ok";
    }
    
    public int excluirPorCategoria(int id) throws DaoException{
        return oDao.excluirPorCategoria(id);
    }

    public boolean excluir(int id) throws DaoException {
        hqControle = HqControle.getInstance();
        int ret = hqControle.excluirPorObra(id);
        int ret2 = oDao.excluir(id);
        
         if (ret2 != 0) {
             return true;
         } else {
             return false;
         }
    }

    public int alterar(Obra o) throws DaoException, ControleException {
        int ret = 0;
        String valida = validaDados(o);

        if (valida.equalsIgnoreCase("ok")) {
            ret = oDao.alterar(o);
        } else {
            throw new ControleException("Erro ao alterar usuário:" + valida);
        }

        return ret;
    }

    public int inserir(Obra o, Categoria c, Editora e) throws DaoException, ControleException {
        String valida = validaDados(o);
        int ret;
        if (valida.equalsIgnoreCase("ok")) {
            ret = oDao.inserir(o, c, e);
        } else {
            throw new ControleException("Erro ao inserir categoria:" + valida);
        }

        return ret;
    }

    public List<Obra> consultaTudo() throws DaoException {
//        hqControle = HqControle.getInstance();
        List<Obra> os = oDao.consultaTudo();
        
//        for(int i=0; i<os.size(); i++){
//            os.get(i).setHqs(hqControle.consultaTudoObra(os.get(i)));
//        }
        
        return os;
    }

    public List<Obra> consultaPorNome(String nome) throws DaoException {
        hqControle = HqControle.getInstance();
        List<Obra> os = oDao.consultarPorNome(nome);
        
        for(int i=0; i<os.size(); i++){
            os.get(i).setHqs(hqControle.consultaTudoObra(os.get(i)));
        }
        
        return os;
    }

    public Obra consultaPorCd(int id) throws DaoException {
        Obra o = oDao.consultarPorCd(id);
        hqControle = HqControle.getInstance();
        if(o != null)
            o.setHqs(hqControle.consultaTudoObra(o));
        
        return o;
    }
    
     public Categoria consultaCatPorCd(int id) throws DaoException {
        Categoria c = oDao.consultarCatPorCd(id);
        
        return c;
    }
    
      public Editora consultaEditoraPorCd(int id) throws DaoException {
        Editora e = oDao.consultarEditoraPorCd(id); 
        
        return e;
    }

    public List<Obra> consultaPorCategoria(int id) throws DaoException {
        hqControle = HqControle.getInstance();
        List<Obra> os = oDao.consultaTudoPorCategoria(id);
        
        for(int i=0; i<os.size(); i++){
            os.get(i).setHqs(hqControle.consultaTudoObra(os.get(i)));
        }
        
        return os;
    }
    
     public List<Obra> consultaPorEditora(int id) throws DaoException {
        hqControle = HqControle.getInstance();
        List<Obra> os = oDao.consultaTudoPorEditora(id);
        
        for(int i=0; i<os.size(); i++){
            os.get(i).setHqs(hqControle.consultaTudoObra(os.get(i)));
        }
        
        return os;
    }

    public int excluirPorEditora(int id) throws DaoException {
         return oDao.excluirPorEditora(id);
    }

    public List<Obra> consultaRelatorio(String nome, int ano1, int ano2) throws DaoException {
        return oDao.consultaRelatorio(nome, ano1, ano2);
    }

}
