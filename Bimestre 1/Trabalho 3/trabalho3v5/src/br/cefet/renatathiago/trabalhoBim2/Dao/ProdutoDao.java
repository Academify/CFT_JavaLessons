package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends Dao {

    private final String SQL_INSERIR_PRODUTO = "INSERT INTO TbProduto (NmProduto, Marca, QtdEstoque, PrecoCompra, PrecoVenda)" 
                                            + " VALUES (?, ?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "SELECT * FROM TbProduto WHERE CdProduto = ?";
    private final String SQL_CONSULTAR_POR_NOME = "SELECT * FROM TbProduto WHERE NmProduto LIKE ?";
    private final String SQL_LISTAR_PRODUTOS = "SELECT * FROM TbProduto";
    private final String SQL_ALTERAR_PRODUTO = "UPDATE TbProduto "
                                              + "SET NmProduto = ?, Marca = ?, "
                                              + "QtdEstoque = ?, PrecoCompra = ?, "
                                              + "PrecoVenda = ? WHERE CdProduto = ?";
    private final String SQL_EXCLUIR_PRODUTO = " DELETE FROM TbProduto WHERE CdProduto = ?";
    private final String SQL_ALTERAR_QTDESTOQUE_PRODUTO = "UPDATE TbProduto SET QtdEstoque = ? WHERE CdProduto = ?";
    
    public void inserir(Produto p) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_PRODUTO, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getMarca());
            ps.setInt(3, p.getQtdEstoque());
            ps.setDouble(4, p.getPrecoCompra());
            ps.setDouble(5, p.getPrecoVenda());
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo ProdutoDao.inserir( " + p.getNome() + ")-:" + p.getClass(), e);
        }
    } //FUNCIONANDO

    public Produto consultarPorCod (int cod) throws DaoException {
        Produto p = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1,cod);
            rs = ps.executeQuery();

            if (rs.next()){
                p = getProdutoFromRs(rs);
            }
        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.consultarPorCod", e);
        }
        return p;
    } //FUNCIONANDO

    public List<Produto> consultarPorNome (String nome) throws DaoException {
        
        List<Produto> listaProdutos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome);
            rs = ps.executeQuery();

            while(rs.next()){
                Produto p = getProdutoFromRs(rs);
                listaProdutos.add(p);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.consultarPorNome", e);
        }
        return listaProdutos;
    } //FUNCIONANDO

    public List<Produto> consultarTodos () throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Produto> listaProdutos = new ArrayList<>(); 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LISTAR_PRODUTOS);
            rs = ps.executeQuery();

           while (rs.next()){
               Produto p = getProdutoFromRs(rs);
               listaProdutos.add(p); 
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.listarProduto", e);
        }
        return listaProdutos;
    } // FUNCIONANDO

    public void excluir (int cod) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR_PRODUTO);
            ps.setInt(1,cod);
            ps.execute();

        } catch (SQLException e){
             throw new DaoException("Erro no metodo ProdutoDao.excluirProduto", e);
        }
    } //FUNCIONANDO

    public void alterar(int cod, Produto p) throws DaoException {;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_PRODUTO);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getMarca());
            ps.setInt(3, p.getQtdEstoque());
            ps.setDouble(4, p.getPrecoCompra());
            ps.setDouble(5, p.getPrecoVenda());
            ps.setInt(6, cod);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo ProdutoDao.Inserir( " + p.getNome() + ")-:" + p.getClass(), e);
        }
    } // FUNCIONANDO
    
    private Produto getProdutoFromRs(ResultSet rs) throws DaoException {

        Produto p = new Produto ();

        try {

            p.setCod(rs.getInt("CdProduto"));
            p.setNome(rs.getString("NmProduto"));
            p.setMarca(rs.getString("Marca"));
            p.setQtdEstoque(rs.getInt("QtdEstoque"));
            p.setPrecoCompra(rs.getDouble("PrecoCompra"));
            p.setPrecoVenda(rs.getDouble("PrecoVenda"));

        } catch (SQLException e){
            throw new DaoException("Erro no metodo ProdutoDao.getProdutoFromRs", e);
        }

        return p;
    } // FUNCIONANDO
    
    public ProdutoCV deProdutoParaProdutoCVVenda (Produto p, int qtd){
        
        ProdutoCV pcv = new ProdutoCV();
        
        pcv.setCod(p.getCod());
        pcv.setMarca(p.getMarca());
        pcv.setNome(p.getNome());
        pcv.setPrecoCompra(p.getPrecoCompra());
        pcv.setPrecoVenda(p.getPrecoVenda());
        pcv.setQtdEstoque(p.getQtdEstoque());
        pcv.setPrecoAntigo(p.getPrecoVenda());
        pcv.setQtd(qtd);
        
        return pcv;
        
    }
        
    public ProdutoCV deProdutoParaProdutoCVCompra(Produto p, int qtd){
        
        ProdutoCV pcv = new ProdutoCV();
        
        pcv.setCod(p.getCod());
        pcv.setMarca(p.getMarca());
        pcv.setNome(p.getNome());
        pcv.setPrecoCompra(p.getPrecoCompra());
        pcv.setPrecoVenda(p.getPrecoVenda());
        pcv.setQtdEstoque(p.getQtdEstoque());
        pcv.setPrecoAntigo(p.getPrecoCompra());
        pcv.setQtd(qtd);
        
        return pcv;
        
    }
    
    public Produto deProdutoCVParaProduto (ProdutoCV pcv){
        
        Produto p = new Produto();
        
        p.setCod(pcv.getCod());
        p.setMarca(pcv.getMarca());
        p.setNome(pcv.getNome());
        p.setPrecoCompra(pcv.getPrecoCompra());
        p.setPrecoVenda(pcv.getPrecoVenda());
        p.setQtdEstoque(pcv.getQtdEstoque());
        
        return pcv;
        
    }
    
    public void alterarQtdEstoque(int qtd, int codproduto) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_QTDESTOQUE_PRODUTO);
            ps.setInt(1, qtd);
            ps.setInt(2, codproduto);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo ProdutoDao.AlterarQtdEstoqueProduto( " + consultarPorCod(codproduto).getNome() + ")-:" + consultarPorCod(codproduto).getClass(), e);
        }
    }

}
