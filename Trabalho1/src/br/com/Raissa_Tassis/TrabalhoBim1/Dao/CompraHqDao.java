package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Compra;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Hq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompraHqDao extends Dao{
    
    private static CompraHqDao instance;
    private CompraDao coDao;
    private HqDao hqDao;
    
    public static CompraHqDao getInstance(){
        if(instance == null){
            instance = new CompraHqDao();
        }
        return instance;
    }
    
    private final String INSERT_SQL = " insert into TBCOMPRAHQ (CDCOMPRA, CDHQ, VLUNITARIO)"
                                    + " values (?, ?, ?) ";
    
    private final String ALTERAHQ_SQL =  "update TBCOMPRAHQ set "
                                     + "CDHQ = 1,"
                                     + "VLUNITARIO = 1.1"
                                     + "where (CDHQ = ?)";
    
    private final String DELETEPORCOMPRA_SQL = " delete from TBCOMPRAHQ"
                                             + " where CDCOMPRA = ?";
    
    private final String DELETEPORHQ_SQL = " delete from TBCOMPRAHQ"
                                             + " where CDHQ = ?";
    
    private final String CONSULTATUDOCOMPRADOR_SQL = " select * from TBCOMPRAHQ "
                                                   + " where CDCOMPRADOR = ?";
    
    private final String CONSULTATUDOVENDEDOR_SQL = " select * from TBCOMPRAHQ "
                                                  + " where CDVENDEDOR = ?";
    
    private final String CONSULTAPORCD_SQL = " select * from TBCOMPRAHQ "
                                           + " where CDCOMPRA = ?";
    
     private final String CONSULTATUDO_SQL = " select * from TBCOMPRAHQ";
                                              
    
    public boolean inserir(Compra c, Hq hq) throws DaoException {
        boolean ret = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL);
        
            ps.setInt(1, c.getCdCompra());
            ps.setInt(2, hq.getCdHq());
            ps.setDouble(3, hq.getPreco());
            
      
            ret = ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CompraHqDao.inserir()-: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);            
        }
        return ret;
    }
    
     public void alteraHq(int cd) throws DaoException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(ALTERAHQ_SQL);
            ps.setInt(1, cd);
            

            ps.execute(); 
            
        } catch(SQLException e){
            throw new DaoException("Erro no métoddo CompraHqDao.alteraHq() -: " + e.getClass(), e);
        } finally{
            close(conn, ps);
        }   
    }
    
    public List<Hq> consultaPorCd(int cd) throws DaoException{
        List<Hq> ret = new ArrayList<Hq>();
        hqDao = HqDao.getInstance();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cdHq = 0;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTAPORCD_SQL);   
            ps.setInt(1, cd);
            ps.execute();
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cdHq = getCdHqFromRs(rs);
                ret.add(hqDao.consultarPorCd(cdHq));              
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CompraHqDao.consultarPorCd() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);   
        }    
        return ret;
    }
    
    private int getCdHqFromRs(ResultSet rs) throws DaoException {
        int cdHq;
        
         try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            cdHq = (rs.getInt("CDHQ"));                   
        } catch (SQLException e) {
            throw new DaoException("Erro no método getCompraFromRs()-: " + e.getClass(), e);

        }         
        return cdHq;
    }
    
    private int getCdCompraFromRs(ResultSet rs) throws DaoException {
        int cdCompra;
        
         try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            cdCompra = (rs.getInt("CDCOMPRA"));                   
        } catch (SQLException e) {
            throw new DaoException("Erro no método getCompraFromRs()-: " + e.getClass(), e);

        }         
        return cdCompra;
    }
    
    
    
    
    
    
    
    
}
