
package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDao extends Dao{
    
    private static CategoriaDao instance;
    
    public static CategoriaDao getInstance(){
        if(instance == null){
            instance = new CategoriaDao();
        }
        return instance;
    }
    
    private final String INSERT_SQL = " insert into TBCATEGORIA (NMCATEGORIA)"
                                    + " values (?) ";
    
    private final String UPDATE_SQL = " update TBCATEGORIA set"
                                    + " NMCATEGORIA=?"
                                    + " where (CDCATEGORIA = ?) ";
    
    private final String DELETE_SQL = " delete from TBCATEGORIA "
                                    + "where CDCATEGORIA = ? ";
    
    private final String CONSULTARPORID_SQL = " select * from TBCATEGORIA"
                                            + " where CDCATEGORIA = ?";

    private final String CONSULTARTUDO_SQL = " select * from "
                                           + "TBCATEGORIA "
                                           + "where CDCATEGORIA != 1";
    
    private final String CONSULTARPORNOME_SQL = " select * from TBCATEGORIA"
                                              + " where NMCATEGORIA like ? "
                                              + "and CDCATEGORIA != 1";
    
    public int inserir(Categoria c) throws DaoException {

        int ret = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, c.getNmCategoria());
      
            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método CategoriaDao.inserir(" + c.getNmCategoria()+ ")-: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);
        }
        return ret;
    }
        
    public int alterar(Categoria c) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
                  
            ps.setString(1, c.getNmCategoria());
            ps.setInt(2, c.getCdCategoria());

            ret = ps.executeUpdate(); //ta dando false
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CategoriaDao.alterar(" + c.getNmCategoria()+ ")-: " + e.getClass(), e);
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
            throw new DaoException("Erro no método CategoriaDao.excluir() -: " + e.getClass(), e);
        } finally{
            close(conn, ps);            
        }
        return ret;
    }
    
    public Categoria consultarPorCd(int cd) throws DaoException {
        Categoria ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORID_SQL);
            ps.setInt(1, cd);
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getCategoriaFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CategoriaDao.consultarPorCd() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);
        }
        return ret;
    }
     
    public List<Categoria> consultarPorNome(String nome) throws DaoException {
        List<Categoria> ret = new ArrayList<Categoria>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORNOME_SQL);
            ps.setString(1, nome+"%" );
            ps.execute();

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getCategoriaFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CategoriaDao.consultarPorNome() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);            
        }
        return ret;
    }
    
    public List<Categoria> consultaTudo() throws DaoException {
        List<Categoria> ret = new ArrayList<Categoria>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARTUDO_SQL);
            ps.execute();

            //Retorna o conjunto de dados do ps
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getCategoriaFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo CategoriaDao.consultarTudo() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);            
        }
        return ret;
    }

    private Categoria getCategoriaFromRs(ResultSet rs) throws DaoException {
        Categoria c = new Categoria();
        
         try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            c.setCdCategoria(rs.getInt("CDCATEGORIA"));
            c.setNmCategoria(rs.getString("NMCATEGORIA"));
                       
        } catch (SQLException e) {
            throw new DaoException("Erro no método getCategoriaFromRs(" + c.getNmCategoria()+ ")-: " + e.getClass(), e);

        } 
         
        return c;
    }
}
