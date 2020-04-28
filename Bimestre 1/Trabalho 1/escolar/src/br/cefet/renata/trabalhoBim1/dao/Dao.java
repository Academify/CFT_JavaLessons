package br.cefet.renata.trabalhoBim1.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
    public Connection getConnection() throws DaoException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbescolar?useSSL=false", "root", "renatinha");
        }catch(ClassNotFoundException e){
            throw new DaoException("Erro no getConnection - Biblioteca de conexão com BD não importada." + e.getClass().getName() + "-" + e.getMessage(), e);   
        }catch (SQLException e){
             throw new DaoException("Erro no getConnection - Falha na conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }catch (Exception e){
             throw new DaoException("Erro no getConnection - Falha na conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }
            
        return conn;  
    }
}