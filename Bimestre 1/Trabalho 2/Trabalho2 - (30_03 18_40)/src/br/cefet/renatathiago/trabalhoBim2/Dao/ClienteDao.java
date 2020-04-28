
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

public class ClienteDao extends Dao {
    
    private final String SQL_INSERIR = "insert into tbcliente(nmcliente, foneCliente, endCliente, tipoCliente, docCliente) values (?, ?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "select * from tbcliente where cdcliente = ?";
    private final String SQL_CONSULTAR_TODOS = " select * from tbcliente ";
    private final String SQL_CONSULTAR_POR_NOME = " select * from tbcliente where nmcliente like = ?";
    
    
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
    }
    
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
    }
   
    public Cliente consultarPorCod(int cod) throws DaoException{
        Cliente ret = null;
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = getClienteFromRs(rs);
            }
        }catch (SQLException e){
            throw new DaoException("Erro no método consultar cliente por codigo");
        }
        return ret;
    }
    
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
    }
    
    public List<Cliente> consultarPorNome(String nome) throws DaoException {
        
        List<Cliente> cliList = new ArrayList();
        
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
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
}
