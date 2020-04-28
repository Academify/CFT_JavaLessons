
package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDao extends Dao {
    
    private final String SQL_INSERIR = "insert into tbcliente(nmcliente, foneCliente, endCliente, tipoCliente, docCliente) values (?, ?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "select * from tbcliente where cdcliente = ?";
    private final String SQL_CONSULTAR_TODOS = "select * from tbcliente ";
    private final String SQL_CONSULTAR_POR_NOME = "select * from tbcliente where nmcliente like ?";
    private final String SQL_ALTERAR = "update tbcliente set Nmcliente = ?, Fonecliente = ?, EndCliente = ?, Tipocliente = ?, docCliente = ? where cdcliente = ? ";
    private final String SQL_EXCLUIR = "delete from tbcliente where cdCliente = ?";
    private final String SQL_PROX_COD = "SHOW TABLE STATUS LIKE 'tbcliente'";

    private Cliente getClienteFromRs(ResultSet rs) throws DaoException {

        Cliente cli = new Cliente();

        try {

            cli.setCod(rs.getInt("CdCliente"));
            cli.setNome(rs.getString("NmCliente"));
            cli.setTelefone(rs.getString("foneCliente"));
            cli.setEndereco(rs.getString("endcliente"));
            cli.setTipoCliente(rs.getString("tipoCliente"));
            cli.setDocumento(rs.getString("doccliente"));

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo ClienteDao.getClienteFromRs", e);
        }

        return cli;
    } // FUNCIONANDO
    
    public void inserir(Cliente cli) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getTelefone());
            ps.setString(3, cli.getEndereco());
            ps.setString(4, cli.getTipoCliente());
            ps.setString(5, cli.getDocumento());
            ps.execute();
            rs = ps.getGeneratedKeys();
            
        } catch (SQLException e){
            throw new DaoException("Erro no metodo ClienteDao.Inserir( " + cli.getNome() + ")-:" + cli.getClass(), e);
        } 
    } // FUNCIONANDO
   
    public Cliente consultarPorCod(int cod) throws DaoException{
        Cliente ret = null;
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getClienteFromRs(rs);
            }
        }catch (SQLException e){
            throw new DaoException("Erro no método consultar cliente por codigo");
        }
        return ret;
    } // FUNCIONANDO
    
    public List<Cliente> consultarTodos() throws DaoException{
       List<Cliente> cliList = new ArrayList(); 
      
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       
       try{
           conn = getConnection();
           ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
           rs = ps.executeQuery();
           while (rs.next()) {
                Cliente c = getClienteFromRs(rs);
                cliList.add(c);
            }
       }catch (SQLException e) {
            throw new DaoException("Erro no método Consultar Todos os Clientes");
       }
       return cliList;
    } // FUNCIONANDO
    
    public List<Cliente> consultarPorNome(String nome) throws DaoException {
        
        List<Cliente> cliList = new ArrayList();
        
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = getClienteFromRs(rs);
                cliList.add(c);
            }
        }catch (SQLException e){
            throw new DaoException("Erro no método consultar Cliente por nome");
        }
        return cliList;
    }
    
    public void alterar(int cod, Cliente cli) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getTelefone());
            ps.setString(3, cli.getEndereco());
            ps.setString(4, cli.getTipoCliente());
            ps.setString(5, cli.getDocumento());
            ps.setInt(6, cod);
            ps.execute();
            
        }catch (SQLException e) {
            throw new DaoException("Erro no método alterar Cliente");
        } 
    } // FUNCIONANDO
    
    public void excluir(int cod) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR);
            
            ps.setInt(1, cod);
            ps.execute();
        }catch(SQLException e){
            throw new DaoException("Erro no método excluir Cliente");
        }
    }
    
    public int proximoCod() throws DaoException {
        int ret=0;
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_PROX_COD);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = rs.getInt("Auto_increment");
            }
        }catch (DaoException e) {
            throw new DaoException("Erro no metodo ClienteDao.proximoCod", e);
        }catch (SQLException ex) {
            Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return ret;
    }
}
