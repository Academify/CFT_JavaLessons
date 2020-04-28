package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Dao {
    
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DATABASE_URL = "jdbc:mysql://localhost/bdtrabalho2?useSSL=false";
    private static String DATABASE_USER = "root";
    private static String DATABASE_PWD = "renatinha";
    
    private static ConfigApp conf = null;
	
	protected final Connection getConnection() throws DaoException {
        Connection con = null;

        try {
        	carregaConf();
        	
                Class.forName(JDBC_DRIVER); 
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PWD);
        } catch ( ClassNotFoundException e){
        	throw new DaoException("Error - Driver not found: " + e.getMessage());
        } catch (ConfigException e) {
        	throw new DaoException(e.getMessage());
        } catch (Exception e) {
        	throw new DaoException("Erro - Acess to Data Base denied: " + e.getMessage());
        }

        return con;

    }
	
	private static void carregaConf() throws ConfigException {
		if (conf == null){
			conf = ConfigApp.getInstance();
			JDBC_DRIVER   = conf.getPropertie("JDBC_DRIVER");
			DATABASE_URL  = conf.getPropertie("DATABASE_URL");
			DATABASE_USER = conf.getPropertie("DATABASE_USER");
			DATABASE_PWD  = conf.getPropertie("DATABASE_PWD");
		}
		
	}

	protected void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }
        }
        close(conn, ps);
    }

    protected void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
            }
        }
        close(conn);
    }

    
    protected void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                
            }
        }
    }
}
