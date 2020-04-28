package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Entidade.VendaCliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaClienteDao extends Dao {
    
        private final String SQL_LISTAR_TODOS = "SELECT * FROM TbVenda, TbCliente WHERE TbVenda.CdCliente = TbCliente.CdCliente ORDER BY TbCliente.CdCliente";
        private final String SQL_CONSULTAR_POR_CLIENTE = "SELECT * FROM TbVenda, TbCliente WHERE TbVenda.CdCliente = TbCliente.CdCliente AND TbCliente.NmCliente LIKE ? ORDER BY TbCliente.CdCliente";
        private final String SQL_CONSULTAR_POR_FORMAPG = "SELECT * FROM TbVenda, TbCliente WHERE TbVenda.CdCliente = TbCliente.CdCliente AND TbVenda.FormaPgVenda LIKE ? ORDER BY TbCliente.CdCliente";
        private final String SQL_CONSULTAR_POR_CLIENTE_FORMAPG = "SELECT * FROM TbVenda, TbCliente WHERE TbVenda.CdCliente = TbCliente.CdCliente AND TbCliente.NmCliente LIKE ? AND TbVenda.FormaPgVenda LIKE ? ORDER BY TbCliente.CdCliente";


        public List<VendaCliente> consultarPorCliente (String nome) throws DaoException {
        
        List<VendaCliente> listaVendaClientes = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_CLIENTE);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();

            while(rs.next()){
                VendaCliente v = getVendaClienteFromRs(rs);
                listaVendaClientes.add(v);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaClienteDao.consultarPorCliente", e);
        }
        return listaVendaClientes;
    }
        
        public List<VendaCliente> consultarTodos () throws DaoException {
        
        List<VendaCliente> listaVendaClientes = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LISTAR_TODOS);
            rs = ps.executeQuery();

            while(rs.next()){
                VendaCliente v = getVendaClienteFromRs(rs);
                listaVendaClientes.add(v);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaClienteDao.consultarTodos", e);
        }
        return listaVendaClientes;
    }
        
    public List<VendaCliente> consultarPorFormaPg (String formapg) throws DaoException {
        
        List<VendaCliente> listaVendaClientes = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_FORMAPG);
            ps.setString(1, "%"+formapg+"%");
            rs = ps.executeQuery();

            while(rs.next()){
                VendaCliente v = getVendaClienteFromRs(rs);
                listaVendaClientes.add(v);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaClienteDao.consultarPorFormaPg", e);
        }
        return listaVendaClientes;
    }
    
    public List<VendaCliente> consultarPorClienteFormaPg (String nome, String formapg) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<VendaCliente> listaVendaClientes = new ArrayList<>(); 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_CLIENTE_FORMAPG);
            ps.setString(1, "%"+nome+"%");
            ps.setString(2, "%"+formapg+"%");
            rs = ps.executeQuery();

           while (rs.next()){
               VendaCliente v = getVendaClienteFromRs(rs);
               listaVendaClientes.add(v);
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaClienteDao.consultarTodos", e);
        }
        return listaVendaClientes;
    }
    
        private VendaCliente getVendaClienteFromRs(ResultSet rs) throws DaoException {

        VendaCliente cv = new VendaCliente ();

        try {

            cv.setCodVenda(rs.getInt("CdVenda"));
            cv.setCodCliente(rs.getInt("CdCliente"));
            cv.setData(rs.getString("DtVenda"));
            cv.setValor(rs.getDouble("ValorVenda"));
            cv.setFormapg(rs.getString("FormaPgVenda")); 
            cv.setNome(rs.getString("NmCliente"));
        } catch (SQLException e){
            throw new DaoException("Erro no metodo VendaClienteDao.getVendaFromRs (" + cv.getNome() + ")-:" + cv.getClass(), e);
        }

        return cv;
    } //FUNCIONANDO
}
