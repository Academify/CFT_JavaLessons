package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueControle{
    
    CompraDao cDao = new CompraDao();
    VendaDao vDao = new VendaDao();
    ProdutoDao pDao = new ProdutoDao();

    
    public void inserirCompra(Compra c) throws DaoException {
        
        try{
            double valor = 0;
            for (int i=0; i<c.getListaP().size(); i++){
                valor = valor + c.getListaP().get(i).getPrecoCompra()*c.getListaP().get(i).getQtd();
            }
            c.setValorTotal(valor);
            
            cDao.inserir(c);
            
            for (int i=0; i<c.getListaP().size(); i++){
                    cDao.inserirProduto(c.getCod(), c.getListaP().get(i).getCod(), c.getListaP().get(i).getQtd(), c.getListaP().get(i).getPrecoCompra());
                    c.getListaP().get(i).setQtdEstoque(c.getListaP().get(i).getQtdEstoque() + c.getListaP().get(i).getQtd());
            }
             
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirCompra", e); 
        }
    }
    
    public void excluirCompra(int cod) throws DaoException {

        Compra c = new Compra();
        c = cDao.consultarPorCod(cod);
        for (int i = 0; i<c.getListaP().size(); i++){
            c.getListaP().get(i).setQtdEstoque(c.getListaP().get(i).getQtdEstoque() - c.getListaP().get(i).getQtd());
            excluirProdutoDeCompra(cod, c.getListaP().get(i).getCod());
        }
        cDao.excluir(cod);
        
    }    
    
    public void alterarCompra(int cod, Compra c2) throws DaoException {
        
        try{
        
            cDao.alterar(cod, c2);
            
        } catch(DaoException e){  
            throw new DaoException("Erro no método EstoqueControle.alterarCompra", e); 
        }
    }

    public List<Compra> consultarCompras() throws DaoException {
        
        List<Compra> listaC = new ArrayList();
        listaC = cDao.consultarTodos();
        return listaC;
    }

    public List<Compra> consultarCompraPorFornecedor(int cod) throws DaoException {
        
        List<Compra> listaC = new ArrayList();
        listaC = cDao.consultarPorFornecedor(cod);
        return listaC;
        
    }
    
    public Compra consultarCompraPorCod(int cod) throws DaoException {
        
        Compra C = new Compra ();
        C = cDao.consultarPorCod(cod);
        return C;
        
    }
    
    public void excluirProdutoDeCompra(int codcompra, int codproduto) throws DaoException{
        
        try{
            double valorAntigo = cDao.consultarPorCod(codcompra).getValorTotal();
            pDao.consultarPorCod(codproduto).setQtdEstoque( pDao.consultarPorCod(codproduto).getQtdEstoque() - pDao.consultarQtdProdutoEmCompra(codcompra, codproduto));
            cDao.excluirProduto(codcompra, codproduto);
            double valorNovo = valorAntigo - pDao.consultarPorCod(codproduto).getPrecoCompra()*pDao.consultarQtdProdutoEmCompra(codcompra, codproduto);
            cDao.consultarPorCod(codcompra).setValorTotal(valorNovo);
            
        } catch (DaoException e){
            throw new DaoException("Erro no metodo EstoqueControle.excluirProdutoDeCompra", e); 

        }
    }
    
    public void inserirProdutoEmCompra(int codcompra, int codproduto, int qtd) throws DaoException {
        
        try{    
            
            double valorAntigo = cDao.consultarPorCod(codcompra).getValorTotal();
            cDao.inserirProduto(codcompra, codproduto, qtd, pDao.consultarPorCod(codproduto).getPrecoCompra());
            pDao.consultarPorCod(codproduto).setQtdEstoque(pDao.consultarPorCod(codproduto).getQtdEstoque() + qtd);
            double valorNovo = valorAntigo +  pDao.consultarPorCod(codproduto).getPrecoCompra()*qtd;
            cDao.consultarPorCod(codcompra).setValorTotal(valorNovo);
            
        } catch (DaoException e){
            throw new DaoException ("Erro no método EstoqueControle.inserirProdutoEmCompra", e);
        }
    } 
    
    public List<ProdutoCV> consultarProdutosDeCompra (int cod) throws DaoException{
        
        List<ProdutoCV> listaP = new ArrayList();
        listaP = cDao.consultarPorCod(cod).getListaP();
        return listaP;
    }    
    
    public void inserirVenda(Venda v) throws DaoException {
        
        try{
            double valor = 0;
            for (int i=0; i<v.getListaP().size(); i++){
                valor = valor + v.getListaP().get(i).getPrecoVenda()*v.getListaP().get(i).getQtd();
            }
            v.setValorTotal(valor);
            
            vDao.inserir(v);
            
            for (int i=0; i<v.getListaP().size(); i++){
                    vDao.inserirProduto(v.getCod(), v.getListaP().get(i).getCod(), v.getListaP().get(i).getQtd(), v.getListaP().get(i).getPrecoVenda());
                    v.getListaP().get(i).setQtdEstoque(v.getListaP().get(i).getQtdEstoque() - v.getListaP().get(i).getQtd());
            }
             
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirVenda", e); 
        }
    }
    
    public void excluirVenda(int cod) throws DaoException {

        Venda v = new Venda();
        v = vDao.consultarPorCod(cod);
        for (int i = 0; i<v.getListaP().size(); i++){
            v.getListaP().get(i).setQtdEstoque(v.getListaP().get(i).getQtdEstoque() - v.getListaP().get(i).getQtd());
            excluirProdutoDeVenda(cod, v.getListaP().get(i).getCod());
        }
        cDao.excluir(cod);
        
    }    
    
    public void alterarVenda(int cod, Venda v2) throws DaoException {
    
        try{
       
            vDao.alterar(cod, v2);
            
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.alterarVenda", e); 
        }
    }
    
    public List<Venda> consultarVendas() throws DaoException {
       
        List<Venda> listaV = new ArrayList();
        listaV = vDao.consultarTodos();
        return listaV;
    }
    
    public List<Venda> consultarVendasPorCliente(int cod) throws DaoException {
        
         List<Venda> listaV = new ArrayList();
        listaV = vDao.consultarPorCliente(cod);
        return listaV;
    }
    
    public Venda consultarVendaPorCod(int cod) throws DaoException {
        
        Venda V = new Venda ();
        V = vDao.consultarPorCod(cod);
        return V;
    }
    
    public void excluirProdutoDeVenda(int codvenda, int codproduto) throws DaoException{
        
        try{
            double valorAntigo = vDao.consultarPorCod(codvenda).getValorTotal();
            pDao.consultarPorCod(codproduto).setQtdEstoque( pDao.consultarPorCod(codproduto).getQtdEstoque() + pDao.consultarQtdProdutoEmVenda(codvenda, codproduto));
            vDao.excluirProduto(codvenda, codproduto);
            double valorNovo = valorAntigo - pDao.consultarPorCod(codproduto).getPrecoVenda()*pDao.consultarQtdProdutoEmVenda(codvenda, codproduto);
            vDao.consultarPorCod(codvenda).setValorTotal(valorNovo);
            
        } catch (DaoException e){
            throw new DaoException("Erro no metodo EstoqueControle.excluirProdutoDeVenda", e); 

        }
    }
    
    public void inserirProdutoEmVenda(int codvenda, int codproduto, int qtd) throws DaoException {
        
        try{    
            
            double valorAntigo = vDao.consultarPorCod(codvenda).getValorTotal();
            vDao.inserirProduto(codvenda, codproduto, qtd, pDao.consultarPorCod(codproduto).getPrecoVenda());
            pDao.consultarPorCod(codproduto).setQtdEstoque(pDao.consultarPorCod(codproduto).getQtdEstoque() - qtd);
            double valorNovo = valorAntigo +  pDao.consultarPorCod(codproduto).getPrecoVenda()*qtd;
            vDao.consultarPorCod(codvenda).setValorTotal(valorNovo);
            
        } catch (DaoException e){
            throw new DaoException ("Erro no método EstoqueControle.inserirProdutoEmVenda", e);
        }
    } 
        
}