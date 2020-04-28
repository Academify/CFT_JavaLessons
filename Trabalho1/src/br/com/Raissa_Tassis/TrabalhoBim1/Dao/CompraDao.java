package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Compra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompraDao extends Dao{
    
    private static CompraDao instance;
    private CompraHqDao chqDao;
    private UsuarioDao usuDao;
    
    public static CompraDao getInstance(){
        if(instance == null){
            instance = new CompraDao();
        }
        return instance;
    }
    
    //Date dtCompra, double valorCompra
     private final String INSERT_SQL = " insert into TBCOMPRA (DTCOMPRA, VALORCOMPRA, CDVENDEDOR, CDCOMPRADOR)"
                                     + " values (?, ?, ?, ?) ";
    
     
     private final String DELETE_SQL = " delete from TBCOMPRA "
                                     + " where CDCOMPRA = ?";
     
     private final String DELETEPORUSUARIO_SQL = " delete from TBCOMPRA "
                                     + " where CDCOMPRADOR = ?";
     
    private final String ALTERACOMPRADOR_SQL = " update TBCOMPRA "
                                     + "set CDCOMPRADOR = 1"
                                     + " where (CDCOMPRADOR = ?)";
     
    private final String ALTERAVENDEDOR_SQL = " update TBCOMPRA "
                                     + "set CDVENDEDOR = 1"
                                     + " where (CDVENDEDOR = ?)";
      
     private final String CONSULTARTUDO_SQL = " select CDCOMPRA, DTCOMPRA, VALORCOMPRA, CDVENDEDOR, CDCOMPRADOR from "
                                            + "TBCOMPRA";
     
      private final String CONSULTARPORID_SQL = " select CDCOMPRA, DTCOMPRA, VALORCOMPRA, CDVENDEDOR, CDCOMPRADOR from "
                                              + " TBCOMPRA"
                                              + " where CDCOMPRA = ?";
     
     private final String CONSULTARCOMPRAUSUARIO_SQL = " select CDCOMPRA, DTCOMPRA, VALORCOMPRA, CDVENDEDOR, CDCOMPRADOR from "
                                                     + "TBCOMPRA "
                                                     + "where CDCOMPRADOR = ?";
     
      private final String CONSULTARVENDAUSUARIO_SQL = " select CDCOMPRA, DTCOMPRA, VALORCOMPRA, CDVENDEDOR, CDCOMPRADOR from "
                                                     + "TBCOMPRA"
                                                     + "where CDVENDEDOR = ?";
      
      
    public int inserir(Compra c) throws DaoException {    
        int ret = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        
            ps.setTimestamp(1, new java.sql.Timestamp(c.getDtCompra().getTime()));
            ps.setDouble(2, c.getValorCompra());
            ps.setInt(3, c.getVendedor().getCdUsuario());
            ps.setInt(4, c.getComprador().getCdUsuario());
     
            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CompraDao.inserir()-: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);            
        }
        return ret;
    }
    
    public int alteraComprador(int cd) throws DaoException{
        Connection conn = null;
        PreparedStatement ps = null;
        int ret = 0;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(ALTERACOMPRADOR_SQL);
            
            ps.setInt(1, cd);
            
            ret = ps.executeUpdate(); 
            
        } catch(SQLException e){
            throw new DaoException("Erro no método CompraDao.alteraComprador() -: " + e.getClass(), e);
        } finally{
            close(conn, ps);
        }
         return ret; 
    }
    
    public int alteraVendedor(int cd) throws DaoException{
        Connection conn = null;
        PreparedStatement ps = null;
        int ret = 0;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(ALTERAVENDEDOR_SQL);
            ps.setInt(1, cd);

            ret = ps.executeUpdate(); 
            
        } catch(SQLException e){
            throw new DaoException("Erro no método CompraDao.alteraVendedor() -: " + e.getClass(), e);
        } finally{
            close(conn, ps);
        }
         return ret; 
    }
       
    public int excluir(int id) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, id);

            ret = ps.executeUpdate(); 
          
            
        } catch (SQLException e) {
            throw new DaoException("Erro no método CompraDao.excluir() -: " + e.getClass(), e);
        } finally{
            close(conn, ps);
        }
        return ret;
    }
    
    public int excluirPorComprador(int id) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETEPORUSUARIO_SQL);
            ps.setInt(1, id);

            ret = ps.executeUpdate(); 
          
            
        } catch (SQLException e) {
            throw new DaoException("Erro no método CompraDao.excluir() -: " + e.getClass(), e);
        } finally{
            close(conn, ps);            
        }
        return ret;
    }
    
    public Compra consultarPorCd(int cd) throws DaoException {
        usuDao = UsuarioDao.getInstance();
        Compra ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cdComprador;
        int cdVendedor;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORID_SQL);
            ps.setInt(1, cd);
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getCompraFromRs(rs);
                cdComprador = getCdCompradorFromRs(rs);
                cdVendedor = getCdVendedorFromRs(rs);
                ret.setComprador(usuDao.consultarPorCd(cdComprador));
                ret.setVendedor(usuDao.consultarPorCd(cdVendedor));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CompraDao.consultarPorCd() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);            
        }
        return ret;
    }
    
    public List<Compra> consultarTudo() throws DaoException {
        usuDao = UsuarioDao.getInstance();
        chqDao = CompraHqDao.getInstance();
        List<Compra> ret = new ArrayList<Compra>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cdComprador;
        int cdVendedor;
        
        int cont =0;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARTUDO_SQL);
            
            ps.execute();

            rs = ps.executeQuery();
          
            while (rs.next()) {
                ret.add(getCompraFromRs(rs));
                cdComprador = getCdCompradorFromRs(rs);
                cdVendedor = getCdVendedorFromRs(rs);
                ret.get(cont).setComprador(usuDao.consultarPorCd(cdComprador));
                ret.get(cont).setVendedor(usuDao.consultarPorCd(cdVendedor));
                ret.get(cont).setHqsCompra(chqDao.consultaPorCd(ret.get(cont).getCdCompra()));
                cont++;
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CompraDao.consultarPorCd() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);            
        }
        return ret;
    }
    
    public List<Compra> consultarTudoUsuario(int id) throws DaoException {
        usuDao = UsuarioDao.getInstance();
        List<Compra> ret = new ArrayList<Compra>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cdComprador;
        int cdVendedor;
        
        int cont =0;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARCOMPRAUSUARIO_SQL);
            ps.setInt(1, id);
            
            ps.execute();

            rs = ps.executeQuery();
          
            while (rs.next()) {
                ret.add(getCompraFromRs(rs));
                cdComprador = getCdCompradorFromRs(rs);
                cdVendedor = getCdVendedorFromRs(rs);
                ret.get(cont).setComprador(usuDao.consultarPorCd(cdComprador));
                ret.get(cont).setVendedor(usuDao.consultarPorCd(cdVendedor));
                
                cont++;
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CompraDao.consultarPorCd() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);
        }
        return ret;
    }
    
    private int getCdCompradorFromRs(ResultSet rs) throws DaoException {
        int cd;
        try{
            cd = rs.getInt("CDCOMPRADOR");
        } catch(SQLException e){
            throw new DaoException("Erro no método getCompraFromRs()-: " + e.getClass(), e);
        }
        return cd;
    }
    
    private int getCdVendedorFromRs(ResultSet rs) throws DaoException {
        int cd;
        try{
            cd = rs.getInt("CDVENDEDOR");
        } catch(SQLException e){
            throw new DaoException("Erro no método getCompraFromRs()-: " + e.getClass(), e);
        }
        return cd;
    }


    private Compra getCompraFromRs(ResultSet rs) throws DaoException {
        Compra c = new Compra();
        
         try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            c.setCdCompra(rs.getInt("CDCOMPRA"));
            c.setValorCompra(rs.getDouble("VALORCOMPRA"));
            c.setDtCompra(rs.getTimestamp("DTCOMPRA"));
                    
        } catch (SQLException e) {
            throw new DaoException("Erro no método getCompraFromRs()-: " + e.getClass(), e);

        }         
        return c;
    }
    
    
    
    
      
      
    
    
    
}
