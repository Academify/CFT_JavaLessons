
package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Fornecedor;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao extends Dao {
    
    private final String SQL_INSERIR = "insert into TbFornecedor(NmFornecedor, telefone, cnpj)" + " values (?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "Select * from TbFornecedor " + " where cdFornecedor = ?";
    private final String SQL_CONSULTAR_TODOS = "Select * from TbFornecedor";
    
    private Fornecedor getFornecedorFromRs(ResultSet rs) throws DaoException {

        Fornecedor forn = new Fornecedor();

        try {

            forn.setCod(rs.getInt("CdAdministrador"));
            forn.setNome(rs.getString("NmAdministrador"));
            forn.setTelefone(rs.getString("telefone"));
            forn.setCnpj(rs.getString("cnpj"));
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.getFornecedorFromRs", e);
        }

        return forn;
    }
    public void inserir (Fornecedor forn) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, forn.getNome());
            ps.setString(2, forn.getTelefone());
            ps.setString(3, forn.getCnpj());
            ps.execute();
            rs = ps.getGeneratedKeys();
            
        } catch (SQLException e){
            throw new DaoException("Erro no metodo Fornecedor.Dao.Inserir( " + forn.getNome() + ")-:" + forn.getClass(), e);
        }
    }
    public Fornecedor consultarPorCod(int cod) throws DaoException{
        Fornecedor ret = null;
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getFornecedorFromRs(rs);
            }
        }catch (SQLException e) {
            throw new DaoException("Erro no metodo Fornecedor.Dao.consultarPorCod", e);
        }
        
        return ret;
    }
    public List<Fornecedor> consultarTodos() throws DaoException{
       List<Fornecedor> fornList = new ArrayList(); 
      
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       
       try{
           conn = getConnection();
           ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
           rs = ps.executeQuery();
           while (rs.next()) {
                Fornecedor f = getFornecedorFromRs(rs);
                fornList.add(f);
            }
       }catch (SQLException e) {
            throw new DaoException("Erro no método Consultar Todos os Administradores");
       }
       return fornList;
    } //Falta acabar aqui
}