package br.cefet.renata.trabalhoBim1.dao;

import br.cefet.renata.trabalhoBim1.entidade.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao extends Dao {

    private final String SQL_INSERIR_ALUNO = "INSERT INTO TbAluno (NmAluno, CpfAluno, RgAluno, FoneAluno)" 
                                            + " VALUES (?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_CD = "SELECT * FROM TbAluno WHERE CdAluno = ?";
    private final String SQL_CONSULTAR_POR_NOME = "SELECT * FROM TbAluno WHERE NmAluno LIKE ?";
    private final String SQL_LISTAR_ALUNOS = "SELECT * FROM TbAluno ";
    private final String SQL_ALTERAR_ALUNO = "UPDATE TbAluno "
                                              + "SET NmAluno = ?, CpfAluno = ?, "
                                              + "RgAluno = ?, FoneAluno = ? "
                                              + "WHERE CdAluno = ?";
    private final String SQL_EXCLUIR_ALUNO = " DELETE FROM TbAluno WHERE CdAluno = ?";


    public void inserir(Aluno a) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_ALUNO, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getNmAluno());
            ps.setString(2, a.getCpfAluno());
            ps.setString(3, a.getRgAluno());
            ps.setString(4, a.getFoneAluno());
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo AlunoDao.Inserir( " + a.getNmAluno() + ")-:" + a.getClass(), e);
        }
    } // funcionando

    public Aluno consultarPorCdAluno (int CdAluno) throws DaoException {
        Aluno a = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_CD);
            ps.setInt(1,CdAluno);
            rs = ps.executeQuery();

            if (rs.next()){
                a = getAlunoFromRs(rs);
            }
        } catch (SQLException e){
             throw new DaoException("Erro no metodo AlunoDao.consultarPorCdAluno", e);
        }
        return a;
    } // funcionando

    public List<Aluno> consultarPorNmAluno (String NmAluno) throws DaoException {
        
        List<Aluno> listaAlunos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, NmAluno);
            rs = ps.executeQuery();

            while(rs.next()){
                Aluno a = getAlunoFromRs(rs);
                listaAlunos.add(a);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo Aluno.Dao.consultarPorNmAluno", e);
        }
        return listaAlunos;
    } //funcionando

    public List<Aluno> listarAlunos () throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Aluno> listaAlunos = new ArrayList<>(); 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LISTAR_ALUNOS);
            rs = ps.executeQuery();

           while (rs.next()){
               Aluno a = getAlunoFromRs(rs);
               listaAlunos.add(a); 
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo Aluno.Dao.listarAlunos", e);
        }
        return listaAlunos;
    } //funcionando

    public void excluirAluno (int CdAluno) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR_ALUNO);
            ps.setInt(1,CdAluno);
            ps.execute();

        } catch (SQLException e){
             throw new DaoException("Erro no metodo AlunoDao.excluirAluno", e);
        }
    } // funcionando

    public void alterarAluno(int CdAluno, Aluno a) throws DaoException {;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_ALUNO);
            ps.setString(1, a.getNmAluno());
            ps.setString(2, a.getCpfAluno());
            ps.setString(3, a.getRgAluno());
            ps.setString(4, a.getFoneAluno());
            ps.setInt(5, CdAluno);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.Inserir( " + a.getNmAluno() + ")-:" + a.getClass(), e);
        }
    } // funcionando

    private Aluno getAlunoFromRs(ResultSet rs) throws DaoException {

        Aluno a = new Aluno ();

        try {

            a.setCdAluno(rs.getInt("CdAluno"));
            a.setNmAluno(rs.getString("NmAluno"));
            a.setCpfAluno(rs.getString("CpfAluno"));
            a.setRgAluno(rs.getString("RgAluno"));
            a.setFoneAluno(rs.getString("FoneAluno"));

        } catch (SQLException e){
            throw new DaoException("Erro no metodo AlunoDao.getAlunoFromRs (" + a.getNmAluno() + ")-:" + a.getClass(), e);
        }

        return a;
    }

}