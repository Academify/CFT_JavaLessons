import br.cefet.renatathiago.trabalhoBim2.Dao.Dao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ClienteDao;
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
                                            + " VALUES (?, ?, ?, ?, ?)";
    private final String SQL_CONSULTAR_POR_COD = "SELECT * FROM TbVenda WHERE CdVenda = ?";
    private final String SQL_CONSULTAR_POR_CLIENTE = "SELECT * FROM TbVenda WHERE CdCliente = ?";
    private final String SQL_LISTAR_VENDAS = "SELECT * FROM TbVenda ";
    private final String SQL_ALTERAR_VENDA = "UPDATE TbVenda "
                                              + "SET DtVenda = ?, ValorVenda = ?, "
                                              + "FormaPgVenda = ?, CdCliente = ? "
                                              + "WHERE CdVenda = ?";
    private final String SQL_EXCLUIR_VENDA = " DELETE FROM TbVenda WHERE CdVenda = ?";

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
            ps.setInt(4, v.getCliente().getCod());
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaDao.inserir( " + v.getData() + ")-:" + v.getClass(), e);
        }
    }

    public Venda consultarPorCod (int cod) throws DaoException {
        Venda v = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_COD);
            ps.setInt(1,cod);
            rs = ps.executeQuery();

            if (rs.next()){
                v = getVendaFromRs(rs);
            }
        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.consultarPorCod", e);
        }
        return v;
    }

    public List<Venda> consultarPorCliente (String cod) throws DaoException {
        
        List<Venda> listaVendas = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_CLIENTE);
            ps.setString(1, cod);
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

    public List<Venda> listar() throws DaoException {

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
             throw new DaoException("Erro no metodo VendaDao.listar", e);
        }
        return listaVendas;
    }

    public void excluir(int cod) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR_VENDA);
            ps.setInt(1,cod);
            ps.execute();

        } catch (SQLException e){
             throw new DaoException("Erro no metodo VendaDao.excluir", e);
        }
    }

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
            ps.setInt(4, v.getCliente().getCod());
            ps.setInt(5, cod);
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo VendaDao.alterar( " + v.getData() + ")-:" + v.getClass(), e);
        }
    }

    private Venda getVendaFromRs(ResultSet rs) throws DaoException {

        Venda v = new Venda ();
        ClienteDao cDao = new ClienteDao ();

        try {

            v.setCod(rs.getInt("CdVenda"));
            v.setData(rs.getString("DtVenda"));
            v.setValorTotal(rs.getDouble("ValorVenda"));
            v.setFormaPg(rs.getString("FormaPgVenda")); 
            v.setCliente(cDao.consultarPorCod(rs.getInt("CdCliente")));

        } catch (SQLException e){
            throw new DaoException("Erro no metodo VendaDao.getVendaFromRs (" + v.getData() + ")-:" + v.getClass(), e);
        }

        return v;
    }

}

