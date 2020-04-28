package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Hq;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Obra;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HqDao extends Dao {

    private static HqDao instance;

    public static HqDao getInstance() {
        if (instance == null) {
            instance = new HqDao();
        }
        return instance;
    }
    // vendaApenas, String aluguelApenas, String vendaAluguel

    private final String INSERT_SQL = " insert into TBHQ (PRECO, NMHQ, CONSERVACAO, SINOPSE, CDOBRA, CDUSUARIO)"
            + " values (?, ?, ?, ?, ?, ?) ";

    private final String UPDATE_SQL = " update TBHQ set"
            + " PRECO=?,"
            + " NMHQ=?,"
            + " CONSERVACAO=?,"
            + " SINOPSE=?"
            + " where (CDHQ = ?) ";

    private final String ALTERARDONO_SQL = " update TBHQ set"
            + " CDUSUARIO = ?"
            + " where CDHQ = ?";

    private final String DELETE_SQL = " delete from TBHQ "
            + "where CDHQ = ? ";

    private final String DELETEPOROBRA_SQL = " update TBHQ "
            + "set CDOBRA = 1 "
            + "where CDOBRA = ? ";

    private final String DELETEPORUSUARIO_SQL = " delete from TBHQ "
            + "where CDUSUARIO = ? ";

    private final String CONSULTARPORID_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from TBHQ"
            + " where CDHQ = ?";
    
     private final String CONSULTAROBRAPORID_SQL = " select CDOBRA from TBHQ"
            + " where CDHQ = ?";

    private final String CONSULTARTUDO_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from "
            + "TBHQ"
            + " where CDHQ != 1";
    
    private final String CONSULTARRELATORIO_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from "
            + "TBHQ"
            + " where NMHQ like ?"
            + " and (PRECO > ? and PRECO <= ?)"
            + " and CDHQ != 1";

    private final String CONSULTARPORNOME_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from TBHQ"
            + " where NMHQ like ?"
            + " and CDHQ != 1";
    
    private final String CONSULTARPORNOMEUSUARIO_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from TBHQ"
            + " where NMHQ like ?"
            + " and CDHQ != 1"
            + " and CDUSUARIO = ?";
    
    private final String CONSULTARTUDOUSUARIO_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from TBHQ"
            + " where CDUSUARIO = ?"
            + " and CDHQ != 1";

    private final String CONSULTARTUDOOBRA_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from TBHQ"
            + " where CDOBRA = ?"
            + " and CDHQ != 1";

    private final String CONSULTARVENDAUSUARIO_SQL = " select CDHQ, PRECO, NMHQ, CONSERVACAO, SINOPSE from TBHQ "
            + " where CDUSUARIO=?";

    public int inserir(Hq h, Obra o, Usuario u) throws DaoException {

        int ret = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, h.getPreco());
            ps.setString(2, h.getNmHq());
            ps.setString(3, h.getConservacao());
            ps.setString(4, h.getSinopse());
            ps.setInt(5, o.getCdObra());
            ps.setInt(6, u.getCdUsuario());

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.inserir(" + h.getNmHq() + ")-: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public int alterar(Hq h) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);

            ps.setDouble(1, h.getPreco());
            ps.setString(2, h.getNmHq());
            ps.setString(3, h.getConservacao());
            ps.setString(4, h.getSinopse());
            ps.setInt(5, h.getCdHq());

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.alterar(" + h.getNmHq() + ")-: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public int alterarDono(Hq h, Usuario u) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(ALTERARDONO_SQL);

            ps.setInt(1, u.getCdUsuario());
            ps.setInt(2, h.getCdHq());

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.alterarDono(" + h.getNmHq() + ")-: " + e.getClass(), e);
        } finally {
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
            throw new DaoException("Erro no métoddo HqDao.excluir() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public int excluirPorObra(int id) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETEPOROBRA_SQL);
            ps.setInt(1, id);

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.excluirPorObra() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public int excluirPorUsuario(int id) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETEPORUSUARIO_SQL);
            ps.setInt(1, id);

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.excluirPorUsuario() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public Hq consultarPorCd(int cd) throws DaoException {
        Hq ret = null;
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
                ret = getHqFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }
    
     public Obra consultarObraPorCd(int cd) throws DaoException {
        Obra ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTAROBRAPORID_SQL);
            ps.setInt(1, cd);
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getObraFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Hq> consultarPorNome(String nome) throws DaoException {
        List<Hq> ret = new ArrayList<Hq>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORNOME_SQL);
            ps.setString(1, nome + "%");
            ps.execute();

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getHqFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarPorNome() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }
    
    public List<Hq> consultaRelatorio(String nome, Double preco1, Double preco2) throws DaoException {
        List<Hq> ret = new ArrayList<Hq>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARRELATORIO_SQL);
            ps.setString(1, nome + "%");
            ps.setDouble(2, preco1);
            ps.setDouble(3, preco2);
            ps.execute();

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getHqFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultaRelatorio() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }
    
     public List<Hq> consultarPorNomeUsuario(String nome, Usuario uLogado) throws DaoException {
        List<Hq> ret = new ArrayList<Hq>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORNOMEUSUARIO_SQL);
            ps.setString(1, nome + "%");
            ps.setInt(2, uLogado.getCdUsuario());
            ps.execute();

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getHqFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarPorNome() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

//    public List<Hq> consultarAluguel() throws DaoException {
//        List<Hq> ret = new ArrayList<Hq>();
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            ps = conn.prepareStatement(CONSULTARALUGUEL_SQL);
//            ps.execute();
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                ret.add(getHqFromRs(rs));
//            }
//
//        } catch (SQLException e) {
//            throw new DaoException("Erro no métoddo HqDao.consultarAluguel() -: " + e.getClass(), e);
//        } finally {
//            close(conn, ps, rs);
//        }
//        return ret;
//    }

//    public List<Hq> consultarVenda() throws DaoException {
//        List<Hq> ret = new ArrayList<Hq>();
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            ps = conn.prepareStatement(CONSULTARVENDA_SQL);
//            ps.execute();
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                ret.add(getHqFromRs(rs));
//            }
//
//        } catch (SQLException e) {
//            throw new DaoException("Erro no métoddo HqDao.consultarVenda() -: " + e.getClass(), e);
//        } finally {
//            close(conn, ps, rs);
//        }
//        return ret;
//    }

    public List<Hq> consultaTudo() throws DaoException {
        List<Hq> ret = new ArrayList<Hq>();
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
                ret.add(getHqFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarTudo() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Hq> consultaTudoUsuario(Usuario u) throws DaoException {
        List<Hq> ret = new ArrayList<Hq>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARTUDOUSUARIO_SQL);
            ps.setInt(1, u.getCdUsuario());
            ps.execute();

            //Retorna o conjunto de dados do ps
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getHqFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarTudoUsuario() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Hq> consultaTudoObra(Obra o) throws DaoException {
        List<Hq> ret = new ArrayList<Hq>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARTUDOOBRA_SQL);
            ps.setInt(1, o.getCdObra());
            ps.execute();

            //Retorna o conjunto de dados do ps
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getHqFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarTudoUsuario() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Hq> consultaVendaUsuario(Usuario u) throws DaoException {
        List<Hq> ret = new ArrayList<Hq>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARVENDAUSUARIO_SQL);
            ps.setInt(1, u.getCdUsuario());
            ps.execute();

            //Retorna o conjunto de dados do ps
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getHqFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo HqDao.consultarTudoUsuario() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

//    public List<Hq> consultaAluguelUsuario(Usuario u) throws DaoException {
//        List<Hq> ret = new ArrayList<Hq>();
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            ps = conn.prepareStatement(CONSULTARALUGUELUSUARIO_SQL);
//            ps.setInt(1, u.getCdUsuario());
//            ps.execute();
//
//            //Retorna o conjunto de dados do ps
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                ret.add(getHqFromRs(rs));
//            }
//        } catch (SQLException e) {
//            throw new DaoException("Erro no método HqDao.consultarTudoUsuario() -: " + e.getClass(), e);
//        } finally {
//            close(conn, ps, rs);
//        }
//        return ret;
//    }

    private Hq getHqFromRs(ResultSet rs) throws DaoException {
        Hq h = new Hq();
        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            h.setCdHq(rs.getInt("CDHQ"));
            h.setPreco(rs.getDouble("PRECO"));
            h.setNmHq(rs.getString("NMHQ"));
            h.setConservacao(rs.getString("CONSERVACAO"));
            h.setSinopse(rs.getString("SINOPSE"));

        } catch (SQLException e) {
            throw new DaoException("Erro no método getHqFromRs(" + h.getNmHq() + ")-: " + e.getClass(), e);

        }
        return h;
    }
    
     private Obra getObraFromRs(ResultSet rs) throws DaoException{
        Obra o = new Obra();
        ObraDao oDao = ObraDao.getInstance();
        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            o = oDao.consultarPorCd(rs.getInt("CDOBRA"));
        } catch (SQLException e) {
            throw new DaoException("Erro no método getHqFromRs(" + o.getNmObra()+ ")-: " + e.getClass(), e);
        }
        return o;
    }
}
