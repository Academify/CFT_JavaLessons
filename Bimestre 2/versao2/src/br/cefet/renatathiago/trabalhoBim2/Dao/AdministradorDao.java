    
package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AdministradorDao extends Dao{
    
    private final String SQL_INSERIR = "Insert into TbAdministrador (NmAdministrador, foneadministrador, endadministrador, cpfadministrador, login, senha) values (?, ?, ?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "Select * from TbAdministrador where cdAdministrador = ?";
    private final String SQL_CONSULTAR_TODOS = "Select * from TbAdministrador";
    private final String SQL_CONSULTAR_POR_NOME = "Select * from tbAdministrador where nmAdministrador like ?";
    private final String SQL_ALTERAR = "update tbAdministrador set nmAdministrador = ?, foneadministrador = ?, endadministrador = ?, cpfadministrador = ?, login = ?, senha = ?  where cdadministrador = ? ";
    private final String SQL_EXCLUIR = "delete from tbAdministrador where cdAdministrador = ?";
    
    private Administrador getAdministradorFromRs(ResultSet rs) throws DaoException {

        Administrador adm = new Administrador();

        try {

            adm.setCod(rs.getInt("CdAdministrador"));
            adm.setNome(rs.getString("NmAdministrador"));
            adm.setTelefone(rs.getString("FoneAdministrador"));
            adm.setEndereco(rs.getString("EndAdministrador"));
            adm.setCpf(rs.getString("CpfAdministrador"));
            adm.setEmail(rs.getString("login"));
            adm.setSenha(rs.getString("senha"));
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.getAdministradorFromRs", e);
        }

        return adm;
    } //FUNCIONANDO
    
    public void inserir (Administrador adm) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();                    
            ps = conn.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, adm.getNome());
            ps.setString(2, adm.getTelefone());
            ps.setString(3, adm.getEndereco());
            ps.setString(4, adm.getCpf());
            ps.setString(5, adm.getEmail());
            ps.setString(6, adm.getSenha());
            ps.execute();
            rs = ps.getGeneratedKeys();
            
        } catch (SQLException e){
            throw new DaoException("Erro no metodo AdministradorDao.Inserir( " + adm.getNome() + ")-:" + adm.getClass(), e);
        }
    } //FUNCIONANDO
    
    public Administrador consultarPorCod(int cod) throws DaoException{
        Administrador ret = null;
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getAdministradorFromRs(rs);
            }
        }catch (SQLException e) {
            throw new DaoException("Erro no metodo Adminisrador.Dao.consultarPorCod", e);
        }
        
        return ret;
    } // FUNCIONANDO
    
    public List<Administrador> consultarTodos() throws DaoException{
       List<Administrador> admList = new ArrayList(); 
      
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       
       try{
           conn = getConnection();
           ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
           rs = ps.executeQuery();
           while (rs.next()) {
                Administrador a = getAdministradorFromRs(rs);
                admList.add(a);
            }
       }catch (SQLException e) {
            throw new DaoException("Erro no método Consultar Todos os Administradores");
       }
       return admList;
    }
    
    public List<Administrador> consultarPorNome(String nome) throws DaoException{
        List<Administrador> admList = new ArrayList();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Administrador adm = getAdministradorFromRs(rs);
                admList.add(adm);
            }
        }catch(SQLException e){
            throw new DaoException("Erro no método consultar administrador por nome");
        }
        return admList;
    }
    
    public void alterar(int cod, Administrador adm) throws DaoException{
       
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            
            ps.setString(1, adm.getNome());
            ps.setString(2, adm.getTelefone());
            ps.setString(3, adm.getEndereco());
            ps.setString(4, adm.getCpf());
            ps.setString(5, adm.getEmail());
            ps.setString(6, adm.getSenha());
            ps.setInt(7, cod);
            ps.execute();
            
        } catch (SQLException e) {
            throw new DaoException("Erro no método alterar Administrador");
        }
    } // FUNCIONANDO
    
    public void excluir (int cod) throws DaoException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cod);
            ps.execute();
        } catch (SQLException e){
            throw new DaoException("Erro no método excluir Administrador");
        }
    } // FUNCIONANDO
}
