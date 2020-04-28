package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends Dao {

    private final String SQL_INSERIR_PRODUTO = "INSERT INTO TbProduto (NmProduto, Marca, QtdEstoque, Preco)" 
                                            + " VALUES (?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "SELECT * FROM TbProduto WHERE CdProduto = ?";
    private final String SQL_CONSULTAR_POR_NOME = "SELECT * FROM TbProduto WHERE NmProduto LIKE ?";
    private final String SQL_LISTAR_PRODUTOS = "SELECT * FROM TbProduto ";
    private final String SQL_ALTERAR_PRODUTO = "UPDATE TbProduto "
                                              + "SET NmProduto = ?, Marca = ?, "
                                              + "QtdEstoque = ?, Preco = ? "
                                              + "WHERE CdProduto = ?";
    private final String SQL_EXCLUIR_PRODUTO = " DELETE FROM TbProduto WHERE CdProduto = ?";


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
            ps.setDouble(4, p.getPreco());
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo ProdutoDao.inserir( " + p.getNome() + ")-:" + p.getClass(), e);
        }
    }

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
    }

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
    }

    public List<Produto> listarProdutos () throws DaoException {

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
    }

    public void excluirProduto (int cod) throws DaoException {

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
    }

    public void alterarProduto(int cod, Produto p) throws DaoException {;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_PRODUTO);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getMarca());
            ps.setInt(3, p.getQtdEstoque());
            ps.setDouble(4, p.getPreco());
            ps.setInt(5, cod);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo ProdutoDao.Inserir( " + p.getNome() + ")-:" + p.getClass(), e);
        }
    }

    private Produto getProdutoFromRs(ResultSet rs) throws DaoException {

        Produto p = new Produto ();

        try {

            p.setCod(rs.getInt("CdProduto"));
            p.setNome(rs.getString("NmProduto"));
            p.setMarca(rs.getString("Marca"));
            p.setQtdEstoque(rs.getInt("QtdEtoque"));
            p.setPreco(rs.getDouble("Preco"));

        } catch (SQLException e){
            throw new DaoException("Erro no metodo ProdutoDao.getProdutoFromRs (" + p.getNome() + ")-:" + p.getClass(), e);
        }

        return p;
    }

}
