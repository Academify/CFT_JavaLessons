package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.LojaDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Loja;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.ControleException;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.SQLException;

public class EstoqueControle{
    
    CompraDao cDao = new CompraDao();
    VendaDao vDao = new VendaDao();
    LojaDao lDao = new LojaDao();
     
    public void inserirCompra(Loja l, Compra c) throws ControleException{
        
        try{
        
            cDao.inserir(c);
            lDao.realizarCompra(l, c.getValorTotal());  
            
        } catch(DaoException e){  
            throw new ControleException("Erro no metodo EstoqueControle.inserirCompra", e); 
        }
    }
    
    public void excluirCompra() throws DaoException {
        
    }    
    
    public void alterarCompra() throws DaoException {
        
    }

    public void consultarCompras() throws DaoException {
        
    }

    public void consultarComprasPorFornecedor() throws DaoException {
        
    }
    
    public void consultarCompraPorCod() throws DaoException {
        
    }
    
    public void inserirVenda(Loja l, Venda v) throws DaoException {
        
        try{
        
            vDao.inserir(v);
            lDao.realizarCompra(l, v.getValorTotal());  
            
        } catch(DaoException e){  
            throw new DaoException("Erro no método inserirVenda.EstoqueControle", e); 
        }
        
    }
    
    public void excluirVenda() throws DaoException {
        
    }
    
    public void alterarVenda() throws DaoException {

    }
    
    public void consultarVendas() throws DaoException {
        
    }
    
    public void consultarVendasPorCliente() throws DaoException {
        
    }
    
    public void consultarVendaPorCod() throws DaoException {
        
    }
        
}
