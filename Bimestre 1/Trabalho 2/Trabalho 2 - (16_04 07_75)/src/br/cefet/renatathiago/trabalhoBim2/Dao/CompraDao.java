package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompraDao extends Dao {
    
    private final String SQL_INSERIR_COMPRA = "INSERT INTO TbCompra (DtCompra, ValorCompra, FormaPgCompra, CdFornecedor)" 
                                            + " VALUES (?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "SELECT * FROM TbCompra WHERE CdCompra = ?";
    private final String SQL_CONSULTAR_POR_FORNECEDOR = "SELECT * FROM TbCompra WHERE CdFornecedor = ?";
    private final String SQL_LISTAR_COMPRAS = "SELECT * FROM TbCompra";
    private final String SQL_ALTERAR_COMPRA = "UPDATE TbCompra "
                                              + "SET DtCompra = ?, ValorCompra = ?, "
                                              + "FormaPgCompra = ?, CdFornecedor = ? "
                                              + "WHERE CdCompra = ?";
    private final String SQL_EXCLUIR_COMPRA = " DELETE FROM TbCompra WHERE CdCompra = ?";
    
    private final String SQL_INSERIR_PRODUTO_EM_COMPRA = "INSERT INTO TbCompra_Produto (CdCompra, CdProduto, Qtd, PrecoAntigo) VALUES (?, ?, ?, ?)";
    private final String SQL_EXCLUIR_PRODUTO_DE_COMPRA = "DELETE FROM TbCompra_Produto WHERE CdCompra = ? AND CdProduto = ?";
    
    public void inserir(Compra c) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_COMPRA, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getData());
            ps.setDouble(2, c.getValorTotal());
            ps.setString(3, c.getFormaPg());
            ps.setInt(4, c.getCodFornecedor());
            ps.execute();

            rs = ps.getGeneratedKeys();
            while(rs.next()){
                c.setCod(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo CompraDao.inserir( " + c.getData() + ")-:" + c.getClass(), e);
        }
    } //FUNCIONANDO

    public Compra consultarPorCod (int cod) throws DaoException {
        Compra c = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1,cod);
            rs = ps.executeQuery();

            if (rs.next()){
                c = getCompraFromRs(rs);
            }
        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraDao.consultarPorCod", e);
        }
        return c;
    } //FUNCIONANDO

    public List<Compra> consultarPorFornecedor (int cod) throws DaoException {
        
        List<Compra> listaCompras = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_FORNECEDOR);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            while(rs.next()){
                Compra c = getCompraFromRs(rs);
                listaCompras.add(c);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraDao.consultarPorFornecedor", e);
        }
        return listaCompras;
    }

    public List<Compra> consultarTodos () throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Compra> listaCompras = new ArrayList<>(); 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LISTAR_COMPRAS);
            rs = ps.executeQuery();

           while (rs.next()){
               Compra c = getCompraFromRs(rs);
               listaCompras.add(c); 
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraDao.listarCompras", e);
        }
        return listaCompras;
    }

    public void excluir (int cod) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR_COMPRA);
            ps.setInt(1,cod);
            ps.execute();

        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraDao.excluirCompra", e);
        }
    } //FUNCIONANDO

    public void alterar(int cod, Compra c) throws DaoException {;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_COMPRA);
            ps.setString(1, c.getData());
            ps.setDouble(2, c.getValorTotal());
            ps.setString(3, c.getFormaPg());
            ps.setInt(4, c.getCodFornecedor());
            ps.setInt(5, cod);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo CompraDao.AlterarCompra( " + c.getData() + ")-:" + c.getClass(), e);
        }
    } //FUNCIONANDO
    
    public void inserirProduto(int codcompra, int codproduto, int qtd, double preco) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_PRODUTO_EM_COMPRA);
            ps.setInt(1, codcompra);
            ps.setInt(2, codproduto);
            ps.setInt(3, qtd);
            ps.setDouble(4, preco);
            ps.execute();
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo CompraDao.inserirProdutoEmCompra", e);
        }
    }
    
    public void excluirProduto (int codcompra, int codproduto) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR_PRODUTO_DE_COMPRA);
            ps.setInt(1,codcompra);
            ps.setInt(2, codproduto);
            ps.execute();

        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraDao.excluirProdutoDeCompra", e);
        }
    } 
        
    private Compra getCompraFromRs(ResultSet rs) throws DaoException {

        Compra c = new Compra ();
        FornecedorDao fDao = new FornecedorDao ();

        try {

            c.setCod(rs.getInt("CdCompra"));
            c.setData(rs.getString("DtCompra"));
            c.setValorTotal(rs.getDouble("ValorCompra"));
            c.setFormaPg(rs.getString("FormaPgCompra")); 
            c.setCodFornecedor(rs.getInt("CdFornecedor"));

        } catch (SQLException e){
            throw new DaoException("Erro no metodo CompraDao.getCompraFromRs (" + c.getData() + ")-:" + c.getClass(), e);
        }

        return c;
    } //FUNCIONANDO
        
}
