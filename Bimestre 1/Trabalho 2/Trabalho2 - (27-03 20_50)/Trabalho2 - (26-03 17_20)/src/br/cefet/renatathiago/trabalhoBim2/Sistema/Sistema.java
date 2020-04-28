package br.cefet.renatathiago.trabalhoBim2.Sistema;

import br.cefet.renatathiago.trabalhoBim2.Dao.AdministradorDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.Dao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

   public static void main(String[] args) throws DaoException{
        Dao d = new Dao();
        try {
            Connection conn = d.getConnection();
            
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
        
         Administrador a2 = new Administrador();
        a2.setNome("Renata");
        a2.setCpf("123");
        a2.setEndereco("Rua");
        a2.setLogin("fon");
        a2.setTelefone("12345678");
        a2.setSenha("123");
        
        
        try{

            AdministradorDao admDao = new AdministradorDao();
            admDao.inserir(a);
            
            admDao.excluir(1);
            
            admDao.alterar(2, a2);
            
            Administrador aTeste = admDao.consultarPorCod(2);
            System.out.println(aTeste.getNome());
            
            Compra c1 = new Compra();
            c1.setData("02.01.2001");
            c1.setCpf("123");
            c1.setEndereco("Rua pedronildo");
            c1.setLogin("fon");
            c1.setTelefone("12345678");
            c1.setSenha("123");
        
            Compra c2 = new Compra();
            c2.setNome("Renata");
            c2.setCpf("123");
            c2.setEndereco("Rua");
            c2.setLogin("fon");
            c2.setTelefone("12345678");
            c2.setSenha("123");
            
            CompraDao cDao = new CompraDao();
            cDao.inserir(c);
            
            cDao.excluirCompra(1);
            
            cDao.alterarCompra(2, a2);
            
            Administrador aTeste = admDao.consultarPorCod(2);
            System.out.println(aTeste.getNome());
            
            
                                        
        }catch (Exception e){
            throw new DaoException("DEu merda");
        }
        
    }
    
}
