package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.CompraFornecedor;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraFornecedorDao extends Dao {
    
        private final String SQL_LISTAR_TODOS = "SELECT * FROM TbCompra, TbFornecedor WHERE TbCompra.CdFornecedor = TbFornecedor.CdFornecedor ORDER BY TbFornecedor.CdFornecedor";
        private final String SQL_CONSULTAR_POR_FORNECEDOR = "SELECT * FROM TbCompra, TbFornecedor WHERE TbCompra.CdFornecedor = TbFornecedor.CdFornecedor AND TbFornecedor.NmFornecedor LIKE ? ORDER BY TbFornecedor.CdFornecedor";
        private final String SQL_CONSULTAR_POR_FORMAPG = "SELECT * FROM TbCompra, TbFornecedor WHERE TbCompra.CdFornecedor = TbFornecedor.CdFornecedor AND TbCompra.FormaPgCompra LIKE ? ORDER BY TbFornecedor.CdFornecedor";
        private final String SQL_CONSULTAR_POR_FORNECEDOR_FORMAPG = "SELECT * FROM TbCompra, TbFornecedor WHERE TbCompra.CdFornecedor = TbFornecedor.CdFornecedor AND TbFornecedor.NmFornecedor LIKE ? AND TbCompra.FormaPgCompra LIKE ? ORDER BY TbFornecedor.CdFornecedor";


        public List<CompraFornecedor> consultarPorFornecedor (String nome) throws DaoException {
        
        List<CompraFornecedor> listaCompraFornecedors = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_FORNECEDOR);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();

            while(rs.next()){
                CompraFornecedor v = getCompraFornecedorFromRs(rs);
                listaCompraFornecedors.add(v);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraFornecedorDao.consultarPorFornecedor", e);
        }
        return listaCompraFornecedors;
    }
        
        public List<CompraFornecedor> consultarTodos () throws DaoException {
        
        List<CompraFornecedor> listaCompraFornecedors = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LISTAR_TODOS);
            rs = ps.executeQuery();

            while(rs.next()){
                CompraFornecedor v = getCompraFornecedorFromRs(rs);
                listaCompraFornecedors.add(v);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraFornecedorDao.consultarTodos", e);
        }
        return listaCompraFornecedors;
    }
        
    public List<CompraFornecedor> consultarPorFormaPg (String formapg) throws DaoException {
        
        List<CompraFornecedor> listaCompraFornecedors = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_FORMAPG);
            ps.setString(1, "%"+formapg+"%");
            rs = ps.executeQuery();

            while(rs.next()){
                CompraFornecedor v = getCompraFornecedorFromRs(rs);
                listaCompraFornecedors.add(v);
            }  
        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraFornecedorDao.consultarPorFormaPg", e);
        }
        return listaCompraFornecedors;
    }
    
    public List<CompraFornecedor> consultarPorFornecedorFormaPg (String nome, String formapg) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<CompraFornecedor> listaCompraFornecedors = new ArrayList<>(); 

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_FORNECEDOR_FORMAPG);
            ps.setString(1, "%"+nome+"%");
            ps.setString(2, "%"+formapg+"%");
            rs = ps.executeQuery();

           while (rs.next()){
               CompraFornecedor v = getCompraFornecedorFromRs(rs);
               listaCompraFornecedors.add(v);
           } 

        } catch (SQLException e){
             throw new DaoException("Erro no metodo CompraFornecedorDao.consultarTodos", e);
        }
        return listaCompraFornecedors;
    }
    
        private CompraFornecedor getCompraFornecedorFromRs(ResultSet rs) throws DaoException {

        CompraFornecedor cv = new CompraFornecedor ();

        try {

            cv.setCodCompra(rs.getInt("CdCompra"));
            cv.setCodFornecedor(rs.getInt("CdFornecedor"));
            cv.setData(rs.getString("DtCompra"));
            cv.setValor(rs.getDouble("ValorCompra"));
            cv.setFormapg(rs.getString("FormaPgCompra")); 
            cv.setNome(rs.getString("NmFornecedor"));
        } catch (SQLException e){
            throw new DaoException("Erro no metodo CompraFornecedorDao.getCompraFromRs (" + cv.getNome() + ")-:" + cv.getClass(), e);
        }

        return cv;
    } //FUNCIONANDO
}
