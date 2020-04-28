package br.com.Raissa_Tassis.TrabalhoBim1.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Dao {
    public Connection getConnection() throws DaoException{
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/lp3bim3", "root", "");
        }catch(ClassNotFoundException e){
            throw new DaoException("Erro no getConnection - biblioteca de conexão com BD não importada" + e.getClass().getName()+ " _ " +e.getMessage(), e);
        } catch (SQLException e) {
            throw new DaoException("Erro no getConnection - Falha na conexao", e);
        }catch (Exception e) {
            throw new DaoException("Erro no getConnection - Falha na conexao", e);
        }
        return conn;
    }
    
    protected void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn, ps);
    }

    protected void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn);
    }

    
    protected void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
    }

    
//    public static void main(String args[]){
//        Dao d = new Dao();
//        try{
//            Connection conn = d.getConnection();
//            System.out.println(conn);
//        } catch (Exception e)   {
//            e.printStackTrace();
//        }
//    }
}