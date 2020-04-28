package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.VendaProduto;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaProdutoDao extends Dao{
   private final String SQL_CONSULTAR_PRODUTOS_DE_VENDA = "SELECT * FROM TbVenda_Produto WHERE CdVenda = ?";
    private final String SQL_CONSULTAR_QTD_PRODUTO_EM_VENDA = "SELECT Qtd FROM TbVenda_Produto WHERE CdVenda = ? AND CdProduto = ?";
    private final String SQL_INSERIR_PRODUTO_EM_VENDA = "INSERT INTO TbVenda_Produto (CdVenda, CdProduto, Qtd, PrecoAntigo) VALUES (?, ?, ?, ?)";
    private final String SQL_EXCLUIR_PRODUTO_DE_VENDA = "DELETE FROM TbVenda_Produto WHERE CdVenda = ? AND CdProduto = ?";

    public List<VendaProduto> consultarVendaProdutos (int codVenda) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<VendaProduto> listaVP = new ArrayList();
        VendaProduto p = new VendaProduto();

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_PRODUTOS_DE_VENDA);
            ps.setInt(1, codVenda);
            rs = ps.executeQuery();

           while (rs.next()){
               p = getVendaProdutoFromRs(rs);
               listaVP.add(p);
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.consultarProdutosDeVenda", e);
        }
        return listaVP;
    }

    public int consultarQtdProdutoEmVenda (int codVenda, int codproduto) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int quantidade = 0; 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_QTD_PRODUTO_EM_VENDA);
            ps.setInt(1, codVenda);
            ps.setInt(2, codproduto);
            rs = ps.executeQuery();

            if (rs.next()){
                quantidade = rs.getInt("Qtd");
            }

        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.consultarQtdProdutoEmVenda", e);
        }
        return quantidade;
    }
    
    public void inserirProduto(int codVenda, int codproduto, int qtd, double preco) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_PRODUTO_EM_VENDA);
            ps.setInt(1, codVenda);
            ps.setInt(2, codproduto);
            ps.setInt(3, qtd);
            ps.setDouble(4, preco);
            ps.execute();
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaDao.inserirProdutoEmVenda", e);
        }
    }
    
    public void excluirProduto (int codVenda, int codproduto) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR_PRODUTO_DE_VENDA);
            ps.setInt(1,codVenda);
            ps.setInt(2, codproduto);
            ps.execute();

        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.excluirProduto", e);
        }
    } 
    
    private VendaProduto getVendaProdutoFromRs(ResultSet rs) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        VendaProduto vp = new VendaProduto();
        
        try {

            vp.setCodVenda(rs.getInt("CdVenda"));
            vp.setCodProduto(rs.getInt("CdProduto"));
            vp.setQtd(rs.getInt("Qtd"));
            vp.setPrecoAntigo(rs.getDouble("PrecoAntigo"));
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaProdutoDao.getVendaProdutoFromRs", e);
        }

        return vp;
        
    } 
}
