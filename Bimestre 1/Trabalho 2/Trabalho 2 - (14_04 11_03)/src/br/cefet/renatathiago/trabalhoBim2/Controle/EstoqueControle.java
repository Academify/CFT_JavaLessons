package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.ControleException;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.SQLException;
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
                valor = valor + c.getListaP().get(i).getPreco()*c.getListaP().get(i).getQtd();
            }
            c.setValorTotal(valor);
            
            cDao.inserir(c);
            
            for (int i=0; i<c.getListaP().size(); i++){
                    cDao.inserirProdutoEmCompra(c.getCod(), c.getListaP().get(i).getCod(), c.getListaP().get(i).getQtd(), c.getListaP().get(i).getPreco());
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
        }
        cDao.excluirTodosOsProdutosDeCompra(cod);
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
            cDao.excluirProdutoDeCompra(codcompra, codproduto);
            double valorNovo = valorAntigo + pDao.consultarPorCod(codproduto).getPreco();
            cDao.consultarPorCod(codcompra).setValorTotal(valorNovo);
            
        } catch (DaoException e){
            throw new DaoException("Erro no metodo EstoqueControle.excluirProdutoDeCompra", e); 

        }
    }
    
    public void inserirProdutoEmCompra(int codcompra, int codproduto, int qtd) throws DaoException {
        
        try{    
            
            double valorAntigo = cDao.consultarPorCod(codcompra).getValorTotal();
            cDao.inserirProdutoEmCompra(codcompra, codproduto, qtd, pDao.consultarPorCod(codproduto).getPreco());
            pDao.consultarPorCod(codproduto).setQtdEstoque(pDao.consultarPorCod(codproduto).getQtdEstoque() + qtd);
            double valorNovo = valorAntigo - pDao.consultarPorCod(codproduto).getPreco()*qtd;
            cDao.consultarPorCod(codcompra).setValorTotal(valorNovo);
            
        } catch (DaoException e){
            throw new DaoException ("Erro no método EstoqueControle.inserirProdutoEmCompra", e);
        }
    }
     
    public void excluirTodosOsProdutosDeCompra (int cod) throws DaoException {
        
    }   
    
    public List<ProdutoCV> consultarProdutosDeCompra (int cod) throws DaoException{
        return null;
    }    
    
    public void inserirVenda(Venda v) throws DaoException {
        
        try{
            double valor = 0;
            
            for (int i=0; i<v.getListaP().size(); i++){
                if (v.getListaP().get(i).getQtdEstoque()>v.getListaP().get(i).getQtd()){
                    valor = valor + v.getListaP().get(i).getPreco()*v.getListaP().get(i).getQtd();
                }
            }
            v.setValorTotal(valor);
            
            vDao.inserir(v);
            
            for (int i=0; i<v.getListaP().size(); i++){
                if (v.getListaP().get(i).getQtdEstoque()>v.getListaP().get(i).getQtd()){
                    vDao.inserirProdutoEmVenda(v.getCod(), v.getListaP().get(i).getCod(), v.getListaP().get(i).getQtd());
                    v.getListaP().get(i).setQtdEstoque(v.getListaP().get(i).getQtdEstoque() - v.getListaP().get(i).getQtd());
                }
            }
             
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirVenda", e); 
        }
    }
    
    public void excluirVenda(int cod) throws DaoException {
        
        vDao.excluirTodosOsProdutosDeVenda(cod);
        vDao.excluir(cod);
        
    }  
    
    public void alterarVenda(int cod, Venda v2) throws DaoException {
    
        try{
       
            vDao.alterar(cod, v2);
            
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirCompra", e); 
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
        
}
