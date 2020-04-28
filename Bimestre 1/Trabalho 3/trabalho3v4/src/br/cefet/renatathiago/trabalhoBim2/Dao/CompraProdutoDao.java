package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.CompraProduto;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraProdutoDao extends Dao{
    
    private final String SQL_CONSULTAR_PRODUTOS_DE_COMPRA = "SELECT * FROM TbCompra_Produto WHERE CdCompra = ?";
    private final String SQL_CONSULTAR_QTD_PRODUTO_EM_COMPRA = "SELECT Qtd FROM TbCompra_Produto WHERE CdCompra = ? AND CdProduto = ?";
    private final String SQL_INSERIR_PRODUTO_EM_COMPRA = "INSERT INTO TbCompra_Produto (CdCompra, CdProduto, Qtd, PrecoAntigo) VALUES (?, ?, ?, ?)";
    private final String SQL_EXCLUIR_PRODUTO_DE_COMPRA = "DELETE FROM TbCompra_Produto WHERE CdCompra = ? AND CdProduto = ?";

    public List<CompraProduto> consultarCompraProdutos (int codcompra) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<CompraProduto> listaCP = new ArrayList();
        CompraProduto p = new CompraProduto();

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_PRODUTOS_DE_COMPRA);
            ps.setInt(1, codcompra);
            rs = ps.executeQuery();

           while (rs.next()){
               p = getCompraProdutoFromRs(rs);
               listaCP.add(p);
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.consultarProdutosDeCompra", e);
        }
        return listaCP;
    }

    public int consultarQtdProdutoEmCompra (int codcompra, int codproduto) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int quantidade = 0; 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_QTD_PRODUTO_EM_COMPRA);
            ps.setInt(1, codcompra);
            ps.setInt(2, codproduto);
            rs = ps.executeQuery();

            if (rs.next()){
                quantidade = rs.getInt("Qtd");
            }

        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.consultarQtdProdutoEmCompra", e);
        }
        return quantidade;
    }
    
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
             throw new DaoException("Erro no metodo CompraDao.excluirProduto", e);
        }
    } 
    
    private CompraProduto getCompraProdutoFromRs(ResultSet rs) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        CompraProduto cp = new CompraProduto();
        
        try {

            cp.setCodCompra(rs.getInt("CdCompra"));
            cp.setCodProduto(rs.getInt("CdProduto"));
            cp.setQtd(rs.getInt("Qtd"));
            cp.setPrecoAntigo(rs.getDouble("PrecoAntigo"));
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo CompraProdutoDao.getCompraProdutoFromRs", e);
        }

        return cp;
        
    }
}
