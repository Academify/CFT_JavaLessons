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
    private final String SQL_LISTAR_VENDAS = "SELECT * FROM TbVenda";
    private final String SQL_ALTERAR_VENDA = "UPDATE TbVenda "
                                              + "SET DtVenda = ?, ValorVenda = ?, "
                                              + "FormaPgVenda = ?, CdCliente = ? "
                                              + "WHERE CdVenda = ?";
    private final String SQL_EXCLUIR_VENDA = " DELETE FROM TbVenda WHERE CdVenda = ?";
    
    private final String SQL_ALTERAR_VALOR_VENDA = "UPDATE TbVenda SET ValorVenda = ? WHERE CdVenda = ?";
        
    public void inserir(Venda v) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_VENDA, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, v.getData());
            ps.setDouble(2, v.getValorTotal());
            ps.setString(3, v.getFormaPg());
            ps.setInt(4, v.getCodCliente());
            ps.execute();

            rs = ps.getGeneratedKeys();
            
            while(rs.next()){
                v.setCod(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaDao.inserir( " + v.getData() + ")-:" + v.getClass(), e);
        }
    } //FUNCIONANDO

    public Venda consultarPorCod (int cod) throws DaoException {
        Venda c = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1,cod);
            rs = ps.executeQuery();

            if (rs.next()){
                c = getVendaFromRs(rs);
            }
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.consultarPorCod", e);
        }
        return c;
    } //FUNCIONANDO

    public List<Venda> consultarPorCliente (int cod) throws DaoException {
        
        List<Venda> listaVendas = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_CLIENTE);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            while(rs.next()){
                Venda v = getVendaFromRs(rs);
                listaVendas.add(v);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.consultarPorCliente", e);
        }
        return listaVendas;
    }

    public List<Venda> consultarTodos () throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Venda> listaVendas = new ArrayList<>(); 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LISTAR_VENDAS);
            rs = ps.executeQuery();

           while (rs.next()){
               Venda v = getVendaFromRs(rs);
               listaVendas.add(v);
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.listarVendas", e);
        }
        return listaVendas;
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

    public void alterar(int cod, Venda v) throws DaoException {;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_VENDA);
            ps.setString(1, v.getData());
            ps.setDouble(2, v.getValorTotal());
            ps.setString(3, v.getFormaPg());
            ps.setInt(4, v.getCodCliente());
            ps.setInt(5, cod);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaDao.AlterarVenda( " + v.getData() + ")-:" + v.getClass(), e);
        }
    } //FUNCIONANDO
            
    private Venda getVendaFromRs(ResultSet rs) throws DaoException {

        Venda v = new Venda ();

        try {

            v.setCod(rs.getInt("CdVenda"));
            v.setData(rs.getString("DtVenda"));
            v.setValorTotal(rs.getDouble("ValorVenda"));
            v.setFormaPg(rs.getString("FormaPgVenda")); 
            v.setCodCliente(rs.getInt("CdCliente"));

        } catch (SQLException e){
            throw new DaoException("Erro no metodo VendaDao.getVendaFromRs (" + v.getData() + ")-:" + v.getClass(), e);
        }

        return v;
    } //FUNCIONANDO
    
    public void alterarValorVenda(double valor, int codVenda) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_VALOR_VENDA);
            ps.setDouble(1, valor);
            ps.setInt(2, codVenda);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo ProdutoDao.AlterarValorVenda( " + consultarPorCod(codVenda).getData() + ")-:" + consultarPorCod(codVenda).getClass(), e);
        }
    }

        
}
