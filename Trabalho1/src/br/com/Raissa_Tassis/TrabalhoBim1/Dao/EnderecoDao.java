package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Endereco;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.list;
import java.util.Scanner;

public class EnderecoDao extends Dao {

    private static EnderecoDao instance;

    public static EnderecoDao getInstance() {
        if (instance == null) {
            instance = new EnderecoDao();
        }
        return instance;
    }

    private final String INSERT_SQL = " insert into TBENDERECO (LOGRADOURO, NUMERO, COMPLEMENTO, ESTADO, CIDADE, BAIRRO, CEP, CDUSUARIO)"
            + " values (?, ?, ?, ?, ?, ?, ?, ?) ";

    private final String UPDATE_SQL = " update TBENDERECO set"
            + " LOGRADOURO = ?,"
            + " NUMERO = ?,"
            + " COMPLEMENTO = ?,"
            + " ESTADO = ?,"
            + " CIDADE = ?,"
            + " BAIRRO = ?,"
            + " CEP = ?"
            + " where (CDENDERECO = ?) ";

    private final String DELETE_SQL = " delete from TBENDERECO "
            + "where CDENDERECO = ? ";

    private final String DELETEPORUSUARIO_SQL = " delete from TBENDERECO "
            + "where CDUSUARIO = ? ";

    private final String CONSULTARPORID_SQL = " select * from TBENDERECO"
            + " where CDUSUARIO = ?";

    private final String CONSULTARPORIDENDERECO_SQL = " select * from TBENDERECO"
            + " where CDENDERECO = ?";

    private final String CONSULTARPORLOGRADOURO_SQL = " select * from TBENDERECO"
            + " where LOGRADOURO like ?"
            + " and CDUSUARIO = ?";

    private final String CONSULTARTUDO_SQL = " select * from "
            + "TBENDERECO";

    private final String CONSULTARPORCIDADE_SQL = " select * from TBENDERECO"
            + " where CIDADE like ?";

    public int inserir(Endereco e, Usuario u) throws DaoException {

        int ret = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, e.getLogradouro());
            ps.setInt(2, e.getNumero());
            ps.setString(3, e.getComplemento());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getCidade());
            ps.setString(6, e.getBairro());
            ps.setString(7, e.getCep());
            ps.setInt(8, u.getCdUsuario());

            ps.execute();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException ex) {
            throw new DaoException("Erro no método EnderecoDao.inserir(" + e.getLogradouro() + ")-: " + ex.getClass(), ex);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public int alterar(Endereco e) throws DaoException {
        int ret = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);

            ps.setString(1, e.getLogradouro());
            ps.setInt(2, e.getNumero());
            ps.setString(3, e.getComplemento());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getCidade());
            ps.setString(6, e.getBairro());
            ps.setString(7, e.getCep());
            ps.setInt(8, e.getCdEndereco());

            ret = ps.executeUpdate();

        } catch (SQLException ex) {
            throw new DaoException("Erro no método EnderecoDao.alterar(" + e.getLogradouro() + ")-: " + ex.getClass(), ex);
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
            throw new DaoException("Erro no método EnderecoODao.excluir() -: " + e.getClass(), e);
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
            throw new DaoException("Erro no método EnderecoODao.excluir() -: " + e.getClass(), e);
        } finally {
            close(conn, ps);
        }
        return ret;
    }

    public List<Endereco> consultarPorCd(int cd) throws DaoException {
        List<Endereco> ret = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORID_SQL);
            ps.setInt(1, cd);

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getEnderecoFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método EnderecoDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public Endereco consultarPorCdEndereco(int cd) throws DaoException {
        Endereco ret = new Endereco();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORIDENDERECO_SQL);
            ps.setInt(1, cd);

            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getEnderecoFromRs(rs);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método EnderecoDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Endereco> consultarPorLogradouro(int cd, String logradouro) throws DaoException {
        List<Endereco> ret = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORLOGRADOURO_SQL);
            ps.setInt(2, cd);
            ps.setString(1, logradouro+"%");

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getEnderecoFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método EnderecoDao.consultarPorCd() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    public List<Endereco> consultarPorCidade(String nome) throws DaoException {
        List<Endereco> ret = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(CONSULTARPORCIDADE_SQL);
            ps.setString(1, nome + "%");
            ps.execute();

            rs = ps.executeQuery();
            while (rs.next()) {
                ret.add(getEnderecoFromRs(rs));
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no método EnderecoDao.consultarPorNome() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    //Método que retorna um list com todos os ENDERECOs do BD
    public List<Endereco> consultaTudo() throws DaoException {
        List<Endereco> ret = new ArrayList<Endereco>();
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
                ret.add(getEnderecoFromRs(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no métoddo ENDERECODao.consultarTudo() -: " + e.getClass(), e);
        } finally {
            close(conn, ps, rs);
        }
        return ret;
    }

    //Metodo que cria objetos ENDERECO
    private Endereco getEnderecoFromRs(ResultSet rs) throws DaoException {
        Endereco e = new Endereco();
        Usuario u = new Usuario();
        try {
            //rs.getQualquertipo("nomeColuna") retorna o dado armazenado no Rs da coluna especificada
            e.setCdEndereco(rs.getInt("CDENDERECO"));
            e.setLogradouro(rs.getString("LOGRADOURO"));
            e.setNumero(rs.getInt("NUMERO"));
            e.setComplemento(rs.getString("COMPLEMENTO"));
            e.setEstado(rs.getString("ESTADO"));
            e.setCidade(rs.getString("CIDADE"));
            e.setBairro(rs.getString("BAIRRO"));
            e.setCep(rs.getString("CEP"));

        } catch (SQLException ex) {
            throw new DaoException("Erro no método getENDERECOFromRs(" + e.getLogradouro() + ")-: " + ex.getClass(), ex);
        }
        return e;
    }  
}
