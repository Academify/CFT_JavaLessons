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
        
        //CRIAÇÃO DE OBJETOS PRA TESTE 
        
        //CRIAR OBJETOS - ADM
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
        
        //CRIAR OBJETOS - FORNECEDOR
        
        //CRIAR OBJETOS - CLIENTE
        
        //CRIAR OBJETOS - PRODUTO
        
        //CRIAR OBJETOS - COMPRA
        
        //CRIAR OBJETOS - VENDA
        
        //FIM DA CRIAÇÃO DE OBJETOS PARA TESTE
        
        try{
            
            //INÍCIO DO TESTE DAS DAO'S
            
            //TESTE - ADM

            AdministradorDao admDao = new AdministradorDao();
            admDao.inserir(a);
            
            admDao.excluir(1);
            
            admDao.alterar(2, a2);
            
            Administrador aTeste = admDao.consultarPorCod(2);
            System.out.println(aTeste.getNome()); 
            
            admDao.consultarTodos();
            
            admDao.consultarPorNome("Thiago");
            
            
            
            //TESTE - FORNECEDOR
            
            //TESTE - CLIENTE
            
            //TESTE - PRODUTO
            
            //TESTE - COMPRA
            
            //TESTE - VENDA
            
            //FIM DO TESTE DAS DAO'S
                                        
        }catch (Exception e){
            throw new DaoException("Erro no metodo main.Sistema");
        }
        
    }
    
}
