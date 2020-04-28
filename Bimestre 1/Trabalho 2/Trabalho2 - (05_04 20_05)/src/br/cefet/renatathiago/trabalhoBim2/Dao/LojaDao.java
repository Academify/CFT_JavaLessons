package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LojaDao extends Dao{
    
    private final String SQL_INSERIR_LOJA = "INSERT INTO TbLoja (Saldo) VALUES (?)";
    private final String SQL_DIMINUIR_SALDO = "UPDATE TbLoja SET Saldo=Saldo-?";
    private final String SQL_AUMENTAR_SALDO = "UPDATE TbLoja SET Saldo=Saldo+?";
    
    public void inicializarSaldo(double valorSaldo) throws DaoException{
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERIR_LOJA, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, valorSaldo);
            ps.execute();
            rs = ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo LojaDao.inicializarSaldo", e);
        }
    }
    
    public void diminuirSaldo(double valor) throws DaoException{
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_DIMINUIR_SALDO);
            ps.setDouble(1, (valor));
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo LojaDao.diminuirSaldo", e);
        }
       
   }
    
     public void aumentarSaldo(double valor) throws DaoException{
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = getConnection();
            ps = conn.prepareStatement(SQL_AUMENTAR_SALDO);
            ps.setDouble(1, (valor));
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo LojaDao.aumentarSaldo", e);
        }
       
   }
    
}
