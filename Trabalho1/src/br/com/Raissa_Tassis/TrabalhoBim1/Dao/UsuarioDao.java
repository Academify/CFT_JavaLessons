package br.com.Raissa_Tassis.TrabalhoBim1.Dao;


import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioDao extends Dao {
    
    private static UsuarioDao instance;
    
    public static UsuarioDao getInstance(){
        if(instance == null){
            instance = new UsuarioDao();
        }
        return instance;
    }

    private final String INSERT_SQL = " insert into TBUSUARIO (NMUSUARIO, CPF, RG, TELEFONE, EMAIL, SENHA)"
                                    + " values (?, ?, ?, ?, ?, ?) ";
    
    private final String UPDATE_SQL = " update TBUSUARIO set"
                                    + " NMUSUARIO=?,"
                                    + " CPF=?,"
                                    + " RG=?,"
                                    + " TELEFONE=?,"
                                    + " EMAIL=?,"
                                    + " SENHA=?"
                                    + " where (CDUSUARIO = ?) ";
    
    private final String DELETE_SQL = " delete from TBUSUARIO "
                                    + "where CDUSUARIO = ? ";
    
    private final String CONSULTARPORID_SQL = " select * from TBUSUARIO"
                                            + " where CDUSUARIO = ?";
    
     private final String LOGIN_SQL = " select * from TBUSUARIO"
                                            + " where EMAIL = ? and"
                                            + " SENHA = ?";
    
    private final String CONSULTARPOREMAIL_SQL = " select * from TBUSUARIO"
                                            + " where EMAIL = ?";
    
     private final String CONSULTARPORSENHA_SQL = " select * from TBUSUARIO"
                                            + " where SENHA = ?";

    private final String CONSULTARTUDO_SQL = " select * from "
                                           + "TBUSUARIO "
                                           + "where CDUSUARIO != 1";
    
    private final String CONSULTARTUDOEXCETO_SQL = " select * from "
                                           + "TBUSUARIO "
                                           + "where CDUSUARIO != ? "
                                           + "and CDUSUARIO != 1";
    
    private final String CONSULTARPORNOME_SQL = " select * from TBUSUARIO"
                                              + " where NMUSUARIO like ?"
                                              + " and CDUSUARIO != 1";

    public int inserir(Usuario u) throws DaoException {

        int ret = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, u.getNmUsuario());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getRg());
            ps.setString(4, u.getTelefone());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getSenha());
            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.inserir(" + u.getNmUsuario() + ")-: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);   
        }
        return ret;
    }

    public int alterar(Usuario a) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
                  //NMUSUARIO, CPF, RG, TELEFONE, EMAIL, SENHA
                  
            ps.setString(1, a.getNmUsuario());
            ps.setString(2, a.getCpf());
            ps.setString(3, a.getRg());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getSenha());
            ps.setInt(7, a.getCdUsuario());

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.alterar(" + a.getNmUsuario()+ ")-: " + e.getClass(), e);
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
            throw new DaoException("Erro no método UsuarioDao.excluir() -: " + e.getClass(), e);
        } finally{
            close(conn, ps);   
        }
        return ret;
    }
    
     public Usuario consultarPorCd(int cd) throws DaoException {
        Usuario ret = null;
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
                ret = getUsuarioFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.consultarPorCd() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);  
        }
        return ret;
    }
    
      public Usuario login(String email, String senha) throws DaoException {
        Usuario ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(LOGIN_SQL);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getUsuarioFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.login() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);  
        }
        return ret;
    }

    public Usuario consultarPorEmail(String email) throws DaoException {
        Usuario ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPOREMAIL_SQL);
            ps.setString(1, email);
            
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getUsuarioFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.consultarPorEmail() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);  
        }
        return ret;
    }
    
    public Usuario consultarPorSenha(String senha) throws DaoException {
        Usuario ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORSENHA_SQL);
            ps.setString(1, senha);
            
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getUsuarioFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.consultarPorSenha() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);  
        }
        return ret;
    }
    
    
    
    public List<Usuario> consultarTudoExceto(int cd) throws DaoException {
        List<Usuario> ret = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARTUDOEXCETO_SQL);
            ps.setInt(1, cd);
            
            ps.execute();

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getUsuarioFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.consultarPorCd() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);   
        }
        return ret;
    }
    
    public List<Usuario> consultarPorNome(String nome) throws DaoException {
        List<Usuario> ret = new ArrayList<Usuario>();
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
                ret.add(getUsuarioFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.consultarPorNome() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);   
        }
        return ret;
    }

    //Método que retorna um list com todos os Usuarios do BD
    public List<Usuario> consultaTudo() throws DaoException {
        List<Usuario> ret = new ArrayList<Usuario>();
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
                ret.add(getUsuarioFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no método UsuarioDao.consultarTudo() -: " + e.getClass(), e);
        } finally{
            close(conn, ps, rs);   
        }
        return ret;
    }

    //Metodo que cria objetos Usuario
    private Usuario getUsuarioFromRs(ResultSet rs) throws DaoException {
        Usuario u = new Usuario();
        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            u.setCdUsuario(rs.getInt("CDUSUARIO"));
            u.setNmUsuario(rs.getString("NMUSUARIO"));
            u.setCpf(rs.getString("CPF"));
            u.setRg(rs.getString("RG"));
            u.setTelefone(rs.getString("TELEFONE"));
            u.setEmail(rs.getString("EMAIL"));
            u.setSenha(rs.getString("SENHA"));
            
        } catch (SQLException e) {
            throw new DaoException("Erro no método getUsuarioFromRs(" + u.getNmUsuario() + ")-: " + e.getClass(), e);

        } 
        return u;
    }
}
