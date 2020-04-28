package br.cefet.renatathiago.trabalhoBim2.Sistema;

import br.cefet.renatathiago.trabalhoBim2.Controle.EstoqueControle;
import br.cefet.renatathiago.trabalhoBim2.Dao.AdministradorDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.Dao;
import br.cefet.renatathiago.trabalhoBim2.Dao.FornecedorDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Fornecedor;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.ControleException;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

   public static void main(String[] args) throws ControleException, DaoException, Exception{
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
        
        Fornecedor f = new Fornecedor();
        f.setCnpj("123");
        f.setNome("Batatas");
        f.setTelefone("9898");
        
        Fornecedor f2 = new Fornecedor();
        f2.setNome("Tomates");
        f2.setCnpj("456");
        f2.setTelefone("7845");
        
        //CRIAR OBJETOS - CLIENTE
        
        Cliente cl = new Cliente();
        cl.setEndereco("123");
        cl.setNome("Craudio");
        cl.setTelefone("9898");
        cl.setDocumento("0000");
        cl.setTipoCliente("F");
        
        Cliente cl2 = new Cliente();
        cl2.setNome("Kréber");
        cl2.setTelefone("4567");
        cl2.setEndereco("Rua vazia, 345");
        cl2.setTipoCliente("F");
        cl2.setDocumento("346");
        
        //CRIAR OBJETOS - PRODUTO
        
        Produto p = new Produto();
        p.setNome("Cenoura kg");
        p.setMarca("Cenourinhas");
        p.setPreco(2.90);
        p.setQtdEstoque(70);
        
        Produto p2 = new Produto();
        p2.setNome("Ropolho kg");
        p2.setMarca("Repolhinho");
        p2.setPreco(2.50);
        p2.setQtdEstoque(50);
        
        //CRIAR OBJETOS - COMPRA
        
        Compra c = new Compra();
        c.setData("01/01/2001");
        c.setFormaPg("D");
        c.setCodFornecedor(2);
        c.setValorTotal(100);
        // criar e preencher o list de produtosCV 
        
        Compra c2 = new Compra();
        c2.setData("02/01/2001");
        c2.setFormaPg("D");
        c2.setCodFornecedor(3);
        c2.setValorTotal(100);
        // criar e preencher o list de produtosCV 
        
        //CRIAR OBJETOS - VENDA
        
        Venda v = new Venda();
        v.setData("01/01/2001");
        v.setFormaPg("D");
        v.setCodCliente(2);
        v.setValorTotal(100);
        
        Venda v2 = new Venda();
        v2.setData("02/01/2001");
        v2.setFormaPg("D");
        v2.setCodCliente(3);
        v2.setValorTotal(100);
        
        //FIM DA CRIAÇÃO DE OBJETOS PARA TESTE
        
        try{
            
            AdministradorDao admDao = new AdministradorDao(); 
            FornecedorDao fDao = new FornecedorDao();
            ClienteDao clDao = new ClienteDao();
            ProdutoDao pDao = new ProdutoDao();
            EstoqueControle estoque = new EstoqueControle();
            
            //INÍCIO DO TESTE DAS DAO'S
                                              
            //TESTE - ADM
            
            Administrador aTeste = new Administrador();
            List<Administrador> listaAdm = new ArrayList();
            
            //INSERINDO OBJETOS
            admDao.inserir(a);
            admDao.inserir(a);
            admDao.inserir(a2);
            admDao.inserir(a2);
            
            
           // LISTANDO OBJETOS
            System.out.println("\nTodos os objetos\n");;
            listaAdm = admDao.consultarTodos();           
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            admDao.alterar(3, a);
            listaAdm = admDao.consultarTodos(); 
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //CONSULTANDO POR CÓDIGO
            System.out.println("\nTodos os objetos de código 2\n");
            aTeste = admDao.consultarPorCod(2);
            System.out.println(aTeste.getNome());
            
            //CONSULTANDO POR NOME
            System.out.println("\nTodos os objetos de nome Thiago\n");
            listaAdm = admDao.consultarPorNome("Thiago"); 
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
            
            //EXCLUINDO UM OBJETO
            System.out.println("\nTodos os objetos depois de excluir o de código 1\n");
            admDao.excluir(1);
            listaAdm = admDao.consultarTodos();
            for(int i = 0; i< listaAdm.size(); i++){
                System.out.println(listaAdm.get(i).getNome());
            }
     
              
            //TESTE - FORNECEDOR
            Fornecedor fTeste = new Fornecedor();
            List <Fornecedor> ListaForn = new ArrayList();
            
            //INSERINDO OBJETOS
            fDao.inserir(f);
            fDao.inserir(f);
            fDao.inserir(f2);
            fDao.inserir(f2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaForn = fDao.consultarTodos();
            for(int i = 0; i< ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS 
            System.out.println("\nTodos os objetos depois de alterar\n");
            fDao.alterar(3, f);
            ListaForn = fDao.consultarTodos();
            for(int i = 0; i<ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
            
            //CONSULTANDO POR CÓDIGO
            System.out.println("\nTodos os objetos de código 4\n");
            fTeste = fDao.consultarPorCod(4);
            System.out.println(fTeste.getNome());
            
            //CONSULTANDO POR NOME
            System.out.println("\n Todos os objetos de nome Batatas");
            ListaForn = fDao.consultarPorNome("Batatas");
            for(int i=0; i<ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
            
            //ECLUINDO UM OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            fDao.excluir(1);
            ListaForn = fDao.consultarTodos();
            for(int i =0; i<ListaForn.size(); i++){
                System.out.println(ListaForn.get(i).getNome());
            }
            
            //TESTE - CLIENTE
            Cliente cTeste = new Cliente();
            List <Cliente> ListaCli = new ArrayList();
            
            //INSERINDO OBJETOS
            clDao.inserir(cl);
            clDao.inserir(cl);
            clDao.inserir(cl2);
            clDao.inserir(cl2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaCli = clDao.consultarTodos();
            for(int i=0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            clDao.alterar(2, cl2);
            ListaCli = clDao.consultarTodos();
            for(int i=0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
            
            //CONSULTANDO POR CÓDIGO
            System.out.println("\nTodos os objetos de código 1\n");
            cTeste = clDao.consultarPorCod(1);
            System.out.println(cTeste.getNome());
            
            //CONSULTANDO OBJETO POR NOME
            System.out.println("\n Todos os objetos de nome Kréber");
            ListaCli = clDao.consultarPorNome("Kréber");
            for(int i = 0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            clDao.excluir(1);
            ListaCli = clDao.consultarTodos();
            for(int i = 0; i<ListaCli.size(); i++){
                System.out.println(ListaCli.get(i).getNome());
            }
            
            //TESTE - PRODUTO
            Produto pTeste = new Produto();
            List <Produto> ListaProd = new ArrayList();
            
            //INSERINDO OBJETOS
            pDao.inserir(p);
            pDao.inserir(p);
            pDao.inserir(p2);
            pDao.inserir(p2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaProd = pDao.consultarTodos();
            for(int i= 0 ; i<ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            pDao.alterar(1,p2);
            ListaProd = pDao.consultarTodos();
            for(int i=0; i<ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            pTeste = pDao.consultarPorCod(2);
            System.out.println(pTeste.getNome());
            
            //CONSULTANDO OBJETO POR NOME
            System.out.println("\n Todos os objetos de nome Cenoura");
            ListaProd = pDao.consultarPorNome("Cenoura kg");
            for(int i =0; i<ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            pDao.excluir(1);
            ListaProd = pDao.consultarTodos();
            for(int i =0; i< ListaProd.size(); i++){
                System.out.println(ListaProd.get(i).getNome());
            }
            
            
            //TESTE - ESTOQUE
             
            Compra coTeste = new Compra();
            List <Compra> ListaComp = new ArrayList();
            
            //INSERINDO OBJETOS
            estoque.inserirCompra(c);
            estoque.inserirCompra(c);
            estoque.inserirCompra(c2);
            estoque.inserirCompra(c2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaComp = estoque.consultarCompras();
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            estoque.alterarCompra(1, c2);
            ListaComp = estoque.consultarCompras();
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            coTeste = estoque.consultarCompraPorCod(2);
            System.out.println(coTeste.getData());
            
            //CONSULTANDO OBJETO POR FORNECEDOR
            System.out.println("\n Todos os objetos de Fornecedor de código 2");
            ListaComp = estoque.consultarCompraPorFornecedor(2);
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData() + " " + ListaComp.get(i).getCodFornecedor());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            estoque.excluirCompra(1);
            ListaComp = estoque.consultarCompras();
            for(int i= 0 ; i<ListaComp.size(); i++){
                System.out.println(ListaComp.get(i).getData());
            }
            
            
            Venda vTeste = new Venda();
            List <Venda> ListaV = new ArrayList();
            
            //INSERINDO OBJETOS
            estoque.inserirVenda(v);
            estoque.inserirVenda(v);
            estoque.inserirVenda(v2);
            estoque.inserirVenda(v2);
            
            //LISTANDO OBJETOS
            System.out.println("\nListando todos os objetos\n");
            ListaV = estoque.consultarVendas();
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData());
            }
            
            //ALTERANDO OBJETOS
            System.out.println("\nTodos os objetos depois de alterar\n");
            estoque.alterarVenda(1, v2);
            ListaV = estoque.consultarVendas();
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData());
            }
            
            //CONSULTANDO POR CODIGO
            System.out.println("\nTodos os objetos de código 2\n");
            vTeste = estoque.consultarVendaPorCod(2);
            System.out.println(vTeste.getData());
            
            //CONSULTANDO OBJETO POR CLIENTE
            System.out.println("\n Todos os objetos de Cliente de código 2");
            ListaV = estoque.consultarVendasPorCliente(2);
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData() + " " + ListaV.get(i).getCodCliente());
            }
            
            //EXCLUINDO OBJETO
            System.out.println("\n Todos os objetos depois de excluir o de código 1\n");
            estoque.excluirVenda(1);
            ListaV = estoque.consultarVendas();
            for(int i= 0 ; i<ListaV.size(); i++){
                System.out.println(ListaV.get(i).getData());
            }
            
            //FIM DO TESTE DAS DAO'S
                                        
        } catch (DaoException de) {
            throw new DaoException("Erro no metodo main.Sistema");
        } catch (Exception e){
            throw new Exception("Erro no metodo main.Sistema");
        }
    }
}