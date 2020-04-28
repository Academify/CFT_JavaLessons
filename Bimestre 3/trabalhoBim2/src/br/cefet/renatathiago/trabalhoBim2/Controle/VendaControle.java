package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.ClienteDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Entidade.VendaProduto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaControle {
    VendaDao vDao = new VendaDao();
    ProdutoDao pDao = new ProdutoDao();
    VendaProdutoDao vpDao = new VendaProdutoDao();
    ClienteDao cDao = new ClienteDao ();

    
    public void inserirVenda(Venda v , List<ProdutoCV> listaP) throws DaoException {
        
        if (validarCodCliente(v.getCodCliente()) && listaP.size()>0){
            try{
                double valor = 0;
                for (int i=0; i<listaP.size(); i++){
                    valor = valor + listaP.get(i).getPrecoVenda()*listaP.get(i).getQtd();
                }
                v.setValorTotal(valor);

                vDao.inserir(v);

                for (int i=0; i<listaP.size(); i++){
                        vpDao.inserirProduto(v.getCod(), listaP.get(i).getCod(), listaP.get(i).getQtd(), listaP.get(i).getPrecoVenda());
                }

            } catch(DaoException e){  
                throw new DaoException("Erro no metodo EstoqueControle.inserirVenda", e); 
            }
        }
    } 
    
    public void excluirVenda(int codvenda) throws DaoException {

        if (validarCodVenda(codvenda)){

            Venda c = new Venda();
            int quantEstoque;
            List<ProdutoCV> listaP = new ArrayList();
            listaP = consultarProdutos(codvenda);
            for (int i = 0; i<listaP.size(); i++){
                quantEstoque = pDao.consultarPorCod(listaP.get(i).getCod()).getQtdEstoque();
                pDao.alterarQtdEstoque(quantEstoque + vpDao.consultarQtdProdutoEmVenda(codvenda, listaP.get(i).getCod()), listaP.get(i).getCod());            
                excluirProdutoDeVenda(codvenda, listaP.get(i).getCod());
            }
            vDao.excluir(codvenda);
        }  
    }    
    
    public void alterarVenda(int cod, Venda c2) throws DaoException {
        
        if (validarCodVenda(cod)){
            try{

                vDao.alterar(cod, c2);

            } catch(DaoException e){  
                throw new DaoException("Erro no método EstoqueControle.alterarVenda", e); 
            }
        }
    }

    public List<Venda> consultarVendas() throws DaoException {
        
        List<Venda> listaV = new ArrayList();
        listaV = vDao.consultarTodos();
        
        return listaV;
    }

    public List<Venda> consultarVendaPorCliente(int cod) throws DaoException {
        
        if (validarCodCliente(cod)){
            List<Venda> listaV = new ArrayList();
            listaV = vDao.consultarPorCliente(cod);
            return listaV;
        } else {
            return null;
        }
    }
    
    public Venda consultarPorCod(int cod) throws DaoException {
        
        Venda C = new Venda ();
        C = vDao.consultarPorCod(cod);
        return C;
        
    }
    
    public void excluirProdutoDeVenda(int codVenda, int codproduto) throws DaoException{
        
        double valorAntigo;
        double valorNovo;
        int quantEstoque;
        
        if (validarCodProduto(codproduto) && validarCodVenda(codVenda) && validarProdutoEmVenda(codVenda, codproduto)){
            try{
                valorAntigo = vDao.consultarPorCod(codVenda).getValorTotal();
                quantEstoque = pDao.consultarPorCod(codproduto).getQtdEstoque();
                pDao.alterarQtdEstoque(quantEstoque + vpDao.consultarQtdProdutoEmVenda(codVenda, codproduto), codproduto);            
                vpDao.excluirProduto(codVenda, codproduto);
                valorNovo = valorAntigo - pDao.consultarPorCod(codproduto).getPrecoVenda()*vpDao.consultarQtdProdutoEmVenda(codVenda, codproduto);
                vDao.alterarValorVenda(valorNovo, codVenda);

            } catch (DaoException e){
                throw new DaoException("Erro no metodo EstoqueControle.excluirProdutoDeVenda", e); 

            }
        }
    }
    
    public void inserirProdutoEmVenda(int codVenda, int codproduto, int qtd) throws DaoException {
        
        if (validarCodVenda(codVenda) && validarCodProduto(codproduto) && checagemEstoque(codproduto, qtd)){
            try{    

                double valorAntigo = vDao.consultarPorCod(codVenda).getValorTotal();
                int quantEstoque = pDao.consultarPorCod(codproduto).getQtdEstoque();
                vpDao.inserirProduto(codVenda, codproduto, qtd, pDao.consultarPorCod(codproduto).getPrecoVenda());
                pDao.alterarQtdEstoque(quantEstoque - qtd, codproduto);
                double valorNovo = valorAntigo +  pDao.consultarPorCod(codproduto).getPrecoVenda()*qtd;
                vDao.alterarValorVenda(valorNovo, codVenda);

            } catch (DaoException e){
                throw new DaoException ("Erro no método EstoqueControle.inserirProdutoEmVenda", e);
            }
        }
    } 
    
    public List<ProdutoCV> consultarProdutos (int cod) throws DaoException{
        
        if (validarCodVenda(cod)){
            List<VendaProduto> listaVP = new ArrayList();
            List<ProdutoCV> listaP = new ArrayList();
            listaVP = vpDao.consultarVendaProdutos(cod);
            ProdutoCV p = new ProdutoCV();

            for (int i = 0; i<listaVP.size(); i++){
                p = pDao.deProdutoParaProdutoCVVenda(pDao.consultarPorCod(listaVP.get(i).getCodProduto()), listaVP.get(i).getQtd());
                listaP.add(p);
            }
            return listaP;
        } else {
            return null;
        }
    }

    private boolean validarCodCliente(int codCliente) throws DaoException {
        
        List<Cliente> listaC = new ArrayList();
        boolean resposta = false;
        listaC = cDao.consultarTodos();
        for (int i = 0; i<listaC.size(); i++){
            if (codCliente == listaC.get(i).getCod()){
                resposta = true;
                break;
            }      
        }
        return resposta;
    }

    private boolean validarCodVenda(int codvenda) throws DaoException {
        
        List<Venda> listaV = new ArrayList();
        boolean resposta = false;
        listaV = vDao.consultarTodos();
        for (int i = 0; i<listaV.size(); i++){
            if (codvenda == listaV.get(i).getCod()){
                resposta = true;
                break;
            }      
        }
        return resposta;  
    }

    private boolean validarCodProduto(int cod) throws DaoException {
        
        List<Produto> listaP = new ArrayList();
        boolean resposta = false;
        listaP = pDao.consultarTodos();
        for (int i = 0; i<listaP.size(); i++){
            if (cod == listaP.get(i).getCod()){
                resposta = true;
                break;
            }      
        }
        return resposta;        }

    private boolean validarProdutoEmVenda(int codVenda, int codproduto) throws DaoException {
       
        List<VendaProduto> listaVP = new ArrayList();
        boolean resposta = false;
        listaVP = vpDao.consultarVendaProdutos(codVenda);
        for (int i = 0; i<listaVP.size(); i++){
            if (codproduto == listaVP.get(i).getCodProduto()){
                resposta = true;
                break;
            }      
        }
        return resposta;     
    }

    private boolean checagemEstoque(int cod, int qtd) throws DaoException {
        
        return (pDao.consultarPorCod(cod).getQtdEstoque() >= qtd);
    }
        public int proximoCod() throws DaoException {
        try {
            return vDao.proximoCod();
        } catch (DaoException ex) {
            Logger.getLogger(AdministradorControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
