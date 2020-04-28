package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Entidade.VendaProduto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class VendaControle {
    VendaDao vDao = new VendaDao();
    ProdutoDao pDao = new ProdutoDao();
    VendaProdutoDao vpDao = new VendaProdutoDao();

    
    public void inserirVenda(Venda v , List<ProdutoCV> listaP) throws DaoException {
        
        try{
            double valor = 0;
            for (int i=0; i<listaP.size(); i++){
                valor = valor + listaP.get(i).getPrecoVenda()*listaP.get(i).getQtd();
            }
            v.setValorTotal(valor);
            
            vDao.inserir(v);
            int quantEstoque;
            
            for (int i=0; i<listaP.size(); i++){
                    vpDao.inserirProduto(v.getCod(), listaP.get(i).getCod(), listaP.get(i).getQtd(), listaP.get(i).getPrecoVenda());
                    quantEstoque = listaP.get(i).getQtdEstoque();
                    pDao.alterarQtdEstoque(quantEstoque - listaP.get(i).getQtd(), listaP.get(i).getCod());
            }
             
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirVenda", e); 
        }
    } //PRONTO
    
    public void excluirVenda(int codVenda) throws DaoException {

        Venda c = new Venda();
        int quantEstoque;
        List<ProdutoCV> listaP = new ArrayList();
        listaP = consultarProdutos(codVenda);
        for (int i = 0; i<listaP.size(); i++){
            quantEstoque = pDao.consultarPorCod(listaP.get(i).getCod()).getQtdEstoque();
            pDao.alterarQtdEstoque(quantEstoque + vpDao.consultarQtdProdutoEmVenda(codVenda, listaP.get(i).getCod()), listaP.get(i).getCod());            
            excluirProdutoDeVenda(codVenda, listaP.get(i).getCod());
        }
        vDao.excluir(codVenda);
        
    }    
    
    public void alterarVenda(int cod, Venda c2) throws DaoException {
        
        try{
        
            vDao.alterar(cod, c2);
            
        } catch(DaoException e){  
            throw new DaoException("Erro no método EstoqueControle.alterarVenda", e); 
        }
    }

    public List<Venda> consultarVendas() throws DaoException {
        
        List<Venda> listaV = new ArrayList();
        listaV = vDao.consultarTodos();
        
        return listaV;
    }

    public List<Venda> consultarVendaPorCliente(int cod) throws DaoException {
        
        List<Venda> listaV = new ArrayList();
        listaV = vDao.consultarPorCliente(cod);
        return listaV;
        
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
    
    public void inserirProdutoEmVenda(int codVenda, int codproduto, int qtd) throws DaoException {
        
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
    
    public List<ProdutoCV> consultarProdutos (int cod) throws DaoException{
        
        List<VendaProduto> listaVP = new ArrayList();
        List<ProdutoCV> listaP = new ArrayList();
        listaVP = vpDao.consultarVendaProdutos(cod);
        ProdutoCV p = new ProdutoCV();
        
        for (int i = 0; i<listaVP.size(); i++){
            p = pDao.deProdutoParaProdutoCVVenda(pDao.consultarPorCod(listaVP.get(i).getCodProduto()), listaVP.get(i).getQtd());
            listaP.add(p);
        }
        return listaP;
    }
}
