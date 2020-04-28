package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Categoria;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Editora;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Obra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ObraDao extends Dao {

    private static ObraDao instance;

    public static ObraDao getInstance() {
        if (instance == null) {
            instance = new ObraDao();
        }
        return instance;
    }

    private final String INSERT_SQL = " insert into TBOBRA (DTLANCAMENTO, NMOBRA, CDEDITORA, CDCATEGORIA)"
            + " values (?, ?, ?, ?) ";

    private final String UPDATE_SQL = " update TBOBRA set"
            + " DTLANCAMENTO=?,"
            + " NMOBRA=?"
            + " where (CDOBRA = ?) ";

    private final String DELETE_SQL = " delete from TBOBRA "
            + "where CDOBRA = ? ";

    private final String DELETEPORCATEGORIA_SQL = "update TBOBRA "
            + "set CDCATEGORIA = 1 "
            + "where CDCATEGORIA = ? ";

    private final String DELETEPOREDITORA_SQL = "update TBOBRA "
            + "set CDEDITORA = 1 "
            + "where CDEDITORA = ? ";

    private final String CONSULTARPORID_SQL = " select * from TBOBRA"
            + " where CDOBRA = ?";

    private final String CONSULTARCATPORID_SQL = " select CDCATEGORIA from TBOBRA"
            + " where CDOBRA = ?";

    private final String CONSULTAREDITORAPORID_SQL = " select CDEDITORA from TBOBRA"
            + " where CDOBRA = ?";

    private final String CONSULTARTUDOPORCATEGORIA_SQL = " select * from TBOBRA"
            + " where CDCATEGORIA = ?"
            + " and CDOBRA != 1";

    private final String CONSULTARTUDOPOREDITORA_SQL = " select * from TBOBRA"
            + " where CDEDITORA = ?"
            + " and CDOBRA != 1";

    private final String CONSULTARTUDO_SQL = " select * from TBOBRA"
            + " where CDOBRA != 1";

    private final String CONSULTARPORNOME_SQL = " select * from TBOBRA"
            + " where NMOBRA like ? "
            + " and CDOBRA != 1";
    
    private final String CONSULTARRELATORIO_SQL = " select * from "
            + "TBOBRA"
            + " where NMOBRA like ?"
            + " and (DTLANCAMENTO >= ? and DTLANCAMENTO <= ?)"
            + " and CDOBRA != 1";

    //passar editora como parametro
    public int inserir(Obra o, Categoria c, Editora e) throws DaoException {
        int ret = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, o.getDtLancamento());
            ps.setString(2, o.getNmObra());
            ps.setInt(3, e.getCdEditora());
            ps.setInt(4, c.getCdCategoria());

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException ex) {
            throw new DaoException("Erro no métoddo ObraDao.inserir(" + o.getNmObra() + ")-: " + ex.getClass(), ex);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    //passar editora como parametro
    public int alterar(Obra o) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);

            ps.setInt(1, o.getDtLancamento());
            ps.setString(2, o.getNmObra());
            ps.setInt(3, o.getCdObra());

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.alterar(" + o.getNmObra() + ")-: " + e.getClass(), e);
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
            throw new DaoException("Erro no métoddo ObraDao.excluir() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public int excluirPorCategoria(int id) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETEPORCATEGORIA_SQL);
            ps.setInt(1, id);

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.excluirPorCategoria() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public int excluirPorEditora(int id) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETEPOREDITORA_SQL);
            ps.setInt(1, id);

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.excluirPorCategoria() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public Obra consultarPorCd(int cd) throws DaoException {
        Obra ret = null;
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
                ret = getObraFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public Editora consultarEditoraPorCd(int cd) throws DaoException {
        Editora ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTAREDITORAPORID_SQL);
            ps.setInt(1, cd);
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getEditoraFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public Categoria consultarCatPorCd(int cd) throws DaoException {
        Categoria ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARCATPORID_SQL);
            ps.setInt(1, cd);
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getCatFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Obra> consultarPorNome(String nome) throws DaoException {
        List<Obra> ret = new ArrayList<Obra>();
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
                ret.add(getObraFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultarPorNome() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Obra> consultaTudo() throws DaoException {
        List<Obra> ret = new ArrayList<Obra>();
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
                ret.add(getObraFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultarTudo() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Obra> consultaRelatorio(String nome, int ano1, int ano2) throws DaoException {
        List<Obra> ret = new ArrayList<Obra>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARRELATORIO_SQL);
            ps.setString(1, nome + "%");
            ps.setInt(2, ano1);
            ps.setInt(3, ano2);
            ps.execute();

            //Retorna o conjunto de dados do ps
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getObraFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultaRelatorio() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Obra> consultaTudoPorCategoria(int id) throws DaoException {
        List<Obra> ret = new ArrayList<Obra>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARTUDOPORCATEGORIA_SQL);
            ps.setInt(1, id);
            ps.execute();

            //Retorna o conjunto de dados do ps
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getObraFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultarTudo() -: " + e.getClass(), e);
        } finally {

        }
        return ret;
    }

    public List<Obra> consultaTudoPorEditora(int id) throws DaoException {
        List<Obra> ret = new ArrayList<Obra>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARTUDOPOREDITORA_SQL);
            ps.setInt(1, id);
            ps.execute();

            //Retorna o conjunto de dados do ps
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getObraFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ObraDao.consultarTudo() -: " + e.getClass(), e);
        } finally {

        }
        return ret;
    }

    private Obra getObraFromRs(ResultSet rs) throws DaoException {
        Obra o = new Obra();
        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            o.setCdObra(rs.getInt("CDOBRA"));
            o.setDtLancamento(rs.getInt("DTLANCAMENTO"));
            o.setNmObra(rs.getString("NMOBRA"));

        } catch (SQLException e) {
            throw new DaoException("Erro no método getObraFromRs(" + o.getNmObra() + ")-: " + e.getClass(), e);

        }
        return o;
    }

    private Categoria getCatFromRs(ResultSet rs) throws DaoException {
        Categoria c = new Categoria();
        CategoriaDao cDao = CategoriaDao.getInstance();

        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada

            c = cDao.consultarPorCd(rs.getInt("CDCATEGORIA"));

        } catch (SQLException e) {
            throw new DaoException("Erro no método getObraFromRs(" + c.getNmCategoria() + ")-: " + e.getClass(), e);

        }
        return c;
    }

    private Editora getEditoraFromRs(ResultSet rs) throws DaoException {
        Editora e = new Editora();
        EditoraDao eDao = EditoraDao.getInstance();

        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada

            e = eDao.consultarPorCd(rs.getInt("CDEDITORA"));

        } catch (SQLException ex) {
            throw new DaoException("Erro no método getObraFromRs(" + e.getNmEditora() + ")-: " + ex.getClass(), ex);

        }
        return e;
    }
}
