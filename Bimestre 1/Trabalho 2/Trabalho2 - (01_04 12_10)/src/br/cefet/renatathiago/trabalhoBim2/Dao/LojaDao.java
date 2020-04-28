package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Loja;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LojaDao extends Dao{
    
    private final String SQL_INSERIR_LOJA = "INSERT INTO TbLoja (Saldo) VALUES (?)";
    private final String SQL_ALTERAR_SALDO = "UPDATE TbLoja SET Saldo=? WHERE CdLoja = ?";
    
    public void inserir(Loja l) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_LOJA, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, l.getSaldo());
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo LojaDao.inserir( " + l.getSaldo() + ")-:" + l.getClass(), e);
        }
    }
    
    public void realizarCompra(Loja l, double valor) throws DaoException{
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_SALDO);
            ps.setDouble(1, (l.getSaldo()+valor));
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo LojaDao.realizarCompra( " + l.getSaldo() + ")-:" + l.getClass(), e);
        }
       
   }
    
     public void realizarVenda(Loja l, double valor) throws DaoException{
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR_SALDO);
            ps.setDouble(1, (l.getSaldo()-valor));
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo LojaDao.realizarVenda( " + l.getSaldo() + ")-:" + l.getClass(), e);
        }
       
   }
    
}
