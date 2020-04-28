package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.CompraDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.CompraHqDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Compra;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Hq;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import java.util.List;

public class CompraControle {
    
    private CompraDao comDao;
    private CompraHqDao comHqDao;
    private HqControle hqControle;
    private static CompraControle instance;
    
    public static CompraControle getInstance(){
        if(instance == null){
            instance = new CompraControle();
        }
        return instance;
    }
    
    public CompraControle(){
        this.comDao = CompraDao.getInstance();
        this.comHqDao = CompraHqDao.getInstance();
    }
    
    public int alteraComprador(int cd) throws DaoException{
        return comDao.alteraComprador(cd);
    }
    
    public int alteraVendedor(int cd) throws DaoException{
        return comDao.alteraVendedor(cd);
    }
    
    public void alteraHq(int cd) throws DaoException{
        comHqDao.alteraHq(cd);
    }
     
    public int inserir(Compra c) throws DaoException{
        int ret = 0;    
        boolean status = false;
        hqControle = HqControle.getInstance();
        ret = comDao.inserir(c);
        c.setCdCompra(ret);
        
        List<Hq> hqs = c.getHqsCompra();
        for(int i=0; i<hqs.size(); i++){
            status = comHqDao.inserir(c, hqs.get(i));
            hqControle.alterarDono(hqs.get(i), c.getComprador());
        }
        return ret;
    }
    
    public List<Compra> consultaTudo() throws DaoException{
        List<Compra> cs = null;
        cs = comDao.consultarTudo();
        
        return cs;
    }
    
    public Compra consultaPorCd(int cd) throws DaoException{
        Compra c = comDao.consultarPorCd(cd);
        if(c != null)
            c.setHqsCompra(comHqDao.consultaPorCd(cd));
        
        return c;
    }    

    public List<Compra> consultaPorComprador(int cdUsuario) throws DaoException {
        List<Compra> cs = comDao.consultarTudoUsuario(cdUsuario);
        return cs;
    }
}
