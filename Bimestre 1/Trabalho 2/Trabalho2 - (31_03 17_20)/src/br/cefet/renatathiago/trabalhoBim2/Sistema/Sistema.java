package br.cefet.renatathiago.trabalhoBim2.Sistema;

import br.cefet.renatathiago.trabalhoBim2.Controle.EstoqueControle;
import br.cefet.renatathiago.trabalhoBim2.Dao.AdministradorDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.Dao;
import br.cefet.renatathiago.trabalhoBim2.Dao.FornecedorDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.LojaDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Fornecedor;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Loja;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
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
        
        //CRIAR OBJETOS - LOJA
        //Loja l = new Loja();
        //l.setSaldo(1000);        
        
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
        
        Fornecedor f = new Fornecedor();
        f.setCnpj("123");
        f.setNome("Batatas");
        f.setTelefone("9898");
        f.setCod(1);
        
        //CRIAR OBJETOS - CLIENTE
        
        Cliente cl = new Cliente();
        cl.setEndereco("123");
        cl.setNome("Batatas");
        cl.setTelefone("9898");
        cl.setCod(1);
        cl.setDocumento("0000");
        cl.setTipoCliente("F");
        
        //CRIAR OBJETOS - PRODUTO
        
        //CRIAR OBJETOS - COMPRA
        
        Compra c = new Compra();
        c.setData("01/01/2001");
        c.setFormaPg("D");
        c.setFornecedor(f);
        c.setValorTotal(100);
        
        Compra c2 = new Compra();
        c2.setData("02/01/2001");
        c2.setFormaPg("D");
        c2.setFornecedor(f);
        c2.setValorTotal(100);
        
        //CRIAR OBJETOS - VENDA
        
        Venda v = new Venda();
        v.setData("01/01/2001");
        v.setFormaPg("D");
        v.setCliente(cl);
        v.setValorTotal(100);
        
        Venda v2 = new Venda();
        v2.setData("02/01/2001");
        v2.setFormaPg("D");
        v2.setCliente(cl);
        v2.setValorTotal(100);
        
        //FIM DA CRIAÇÃO DE OBJETOS PARA TESTE
        
        try{
            
            LojaDao lDao = new LojaDao();
            AdministradorDao admDao = new AdministradorDao(); 
            FornecedorDao fDao = new FornecedorDao();
            ClienteDao clDao = new ClienteDao();
            ProdutoDao pDao = new ProdutoDao();
            CompraDao cDao = new CompraDao();
            VendaDao vDao = new VendaDao();
            EstoqueControle estoque = new EstoqueControle();
            
            //INÍCIO DO TESTE DAS DAO'S
            
            //TESTE - LOJA
            
            //lDao.inserir(l);
            
            //TESTE - ADM
            
            Administrador aTeste = new Administrador();
            List<Administrador> listaAdm = new ArrayList();
            
            //INSERINDO OBJETOS
            admDao.inserir(a);
            admDao.inserir(a);
            admDao.inserir(a2);
            admDao.inserir(a2);
            
            
           // LISTANDO OBJETOS
            listaAdm = admDao.consultarTodos();           
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS
            admDao.alterar(3, a);
            listaAdm = admDao.consultarTodos(); 
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //CONSULTANDO TODOS
            
            listaAdm = admDao.consultarTodos();
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //CONSULTANDO POR CÓDIGO
            
            aTeste = admDao.consultarPorCod(2);
            System.out.println(aTeste);
            
            //CONSULTANDO POR NOME
            
            listaAdm = admDao.consultarPorNome("Thiago"); 
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //EXCLUINDO UM OBJETO
            
            admDao.excluir(1);
            listaAdm = admDao.consultarTodos();
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
     
              
            //TESTE - FORNECEDOR
            //fDao.inserir(f);
            
            //TESTE - CLIENTE
            //clDao.inserir(cl);
            
            //TESTE - PRODUTO
            
            //TESTE - ESTOQUE
             
            //Compra cTeste = new Compra();
            //cDao.inserir(c);
            //cDao.alterarCompra(8, c2);
            //cDao.excluirCompra(7);
            //cTeste = cDao.consultarPorCod(8);
            //System.out.print(cTeste.getData());
            
            // Venda vTeste = new Venda();
            //vDao.inserir(v);
            //vDao.alterarVenda(2, v2);
            //vDao.excluirVenda(1);
            //vTeste = vDao.consultarPorCod(2);
            //System.out.println(vTeste.getData());
            
            //FIM DO TESTE DAS DAO'S
                                        
        }catch (Exception e){
            throw new DaoException("Erro no metodo main.Sistema");
        }
        
    }
    
}
