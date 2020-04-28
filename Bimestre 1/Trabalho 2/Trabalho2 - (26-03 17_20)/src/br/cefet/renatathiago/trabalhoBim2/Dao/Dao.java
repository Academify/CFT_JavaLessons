package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class Dao {
    public Connection getConnection() throws DaoException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/BDTrabalho2", "root", "");
        }catch(ClassNotFoundException e){
            throw new DaoException("Erro no getConnection - Biblioteca de conexão com BD não importada." + e.getClass().getName() + "-" + e.getMessage(), e);   
        }catch (SQLException e){
             throw new DaoException("Erro no getConnection - Falha na conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }catch (Exception e){
             throw new DaoException("Erro no getConnection - Falha na conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }
            
        return conn;   
    }
    public static void main(String[] args) throws DaoException{
        Dao d = new Dao();
        try {
            Connection conn = d.getConnection();
            
            System.out.println(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
        Administrador a = new Administrador();
        a.setNome("Thiago");
        a.setCpf("123");
        a.setEndereco("Rua pedronildo");
        a.setLogin("fon");
        a.setTelefone("12345678");
        a.setSenha("123");
        System.out.println(a);
        
        try{
            
            AdministradorDao adm = new AdministradorDao();
            adm.inserir(a);
            
        }catch (Exception e){
            throw new DaoException("DEu merda");
        }
        
    }
}    
