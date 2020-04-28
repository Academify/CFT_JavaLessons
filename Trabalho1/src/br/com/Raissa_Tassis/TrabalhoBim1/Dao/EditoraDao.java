package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Editora;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EditoraDao extends Dao {

    private static EditoraDao instance;

    public static EditoraDao getInstance() {
        if (instance == null) {
            instance = new EditoraDao();
        }
        return instance;
    }

    private final String INSERT_SQL = " insert into TBEDITORA (NMEDITORA)"
            + " values (?) ";

    private final String UPDATE_SQL = " update TBEDITORA set"
            + " NMEDITORA=?"
            + " where (CDEDITORA = ?) ";

    private final String DELETE_SQL = " delete from TBEDITORA "
            + "where CDEDITORA = ? ";

    private final String CONSULTARPORID_SQL = " select * from TBEDITORA"
            + " where CDEDITORA = ?";

    private final String CONSULTARTUDO_SQL = " select * from "
            + "TBEDITORA "
            + "where CDEDITORA != 1";

    private final String CONSULTARPORNOME_SQL = " select * from TBEDITORA"
            + " where NMEDITORA like ? "
            + "and CDEDITORA != 1";

    public int inserir(Editora c) throws DaoException {

        int ret = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, c.getNmEditora());

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo EditoraDao.inserir(" + c.getNmEditora() + ")-: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public int alterar(Editora c) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);

            ps.setString(1, c.getNmEditora());
            ps.setInt(2, c.getCdEditora());

            ret = ps.executeUpdate(); //ta dando false
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo EditoraDao.alterar(" + c.getNmEditora() + ")-: " + e.getClass(), e);
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
            throw new DaoException("Erro no métoddo EditoraDao.excluir() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public Editora consultarPorCd(int cd) throws DaoException {
        Editora ret = null;
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
                ret = getEditoraFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo EditoraDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Editora> consultarPorNome(String nome) throws DaoException {
        List<Editora> ret = new ArrayList<Editora>();
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
                ret.add(getEditoraFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo EditoraDao.consultarPorNome() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Editora> consultaTudo() throws DaoException {
        List<Editora> ret = new ArrayList<Editora>();
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
                ret.add(getEditoraFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo EditoraDao.consultarTudo() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    private Editora getEditoraFromRs(ResultSet rs) throws DaoException {
        Editora c = new Editora();

        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            c.setCdEditora(rs.getInt("CDEDITORA"));
            c.setNmEditora(rs.getString("NMEDITORA"));

        } catch (SQLException e) {
            throw new DaoException("Erro no método getEditoraFromRs(" + c.getNmEditora() + ")-: " + e.getClass(), e);

        }

        return c;
    }
}
