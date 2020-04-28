package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendaDao extends Dao {
    
    private final String SQL_INSERIR_VENDA = "INSERT INTO TbVenda (DtVenda, ValorVenda, FormaPgVenda, CdCliente)" 
                                            + " VALUES (?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "SELECT * FROM TbVenda WHERE CdVenda = ?";
    private final String SQL_CONSULTAR_POR_CLIENTE = "SELECT * FROM TbVenda WHERE CdCliente = ?";
    private final String SQL_LISTAR_VENDAS = "SELECT * FROM TbVenda ";
    private final String SQL_ALTERAR_VENDA = "UPDATE TbVenda "
                                              + "SET DtVenda = ?, ValorVenda = ?, "
                                              + "FormaPgVenda = ?, CdCliente = ? "
                                              + "WHERE CdVenda = ?";
    private final String SQL_EXCLUIR_VENDA = " DELETE FROM TbVenda WHERE CdVenda = ?";


    public void inserir(Venda c) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_VENDA, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getData());
            ps.setDouble(2, c.getValorTotal());
            ps.setString(3, c.getFormaPg());
            ps.setInt(4, c.getCodCliente());
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaDao.inserir( " + c.getData() + ")-:" + c.getClass(), e);
        }
    } // FUNCIONANDO

    public Venda consultarPorCod (int cod) throws DaoException {
        Venda ret = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1,cod);
            rs = ps.executeQuery();

            if (rs.next()){
                ret = getVendaFromRs(rs);
            }
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.consultarPorCod", e);
        }
        return ret;
    }

    public List<Venda> consultarPorCliente(int cod) throws DaoException {
        
        List<Venda> lista = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_CLIENTE);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            while(rs.next()){
                Venda c = getVendaFromRs(rs);
                lista.add(c);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.consultarPorCliente", e);
        }
        return lista;
    }

    public List<Venda> consultarTodos () throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Venda> lista = new ArrayList<>(); 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LISTAR_VENDAS);
            rs = ps.executeQuery();

           while (rs.next()){
               Venda c = getVendaFromRs(rs);
               lista.add(c); 
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.listarVendas", e);
        }
        return lista;
    }

    public void excluir (int cod) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR_VENDA);
            ps.setInt(1,cod);
            ps.execute();

        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.excluirVenda", e);
        }
    } //FUNCIONANDO

    public void alterar(int cod, Venda c) throws DaoException {;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_VENDA);
            ps.setString(1, c.getData());
            ps.setDouble(2, c.getValorTotal());
            ps.setString(3, c.getFormaPg());
            ps.setInt(4, c.getCodCliente());
            ps.setInt(5, cod);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaDao.AlterarVenda( " + c.getData() + ")-:" + c.getClass(), e);
        }
    } //FUNCIONANDO

    private Venda getVendaFromRs(ResultSet rs) throws DaoException {

        Venda c = new Venda ();
        ClienteDao clDao = new ClienteDao ();

        try {

            c.setCod(rs.getInt("CdVenda"));
            c.setData(rs.getString("DtVenda"));
            c.setValorTotal(rs.getDouble("ValorVenda"));
            c.setFormaPg(rs.getString("FormaPgVenda")); 
            c.setCodCliente(rs.getInt("CdCliente"));

        } catch (SQLException e){
            throw new DaoException("Erro no metodo VendaDao.getVendaFromRs (" + c.getData() + ")-:" + c.getClass(), e);
        }

        return c;
    }

}

