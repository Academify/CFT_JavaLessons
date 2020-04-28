package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.List;

public class EstoqueControle {
 
    public void inserirCompra(Compra c) throws DaoException {
         
    }
    
    public void excluirCompra(int cod) throws DaoException {
        
    }    
    
    public void alterarCompra(int cod, Compra c2) throws DaoException {
        
    }

    public List<Compra> consultarCompras() throws DaoException {
        return null;
        
    }

    public List<Compra> consultarComprasPorFornecedor(int cod) throws DaoException {
        return null;
        
    }
    
    public Compra consultarCompraPorCod(int cod) throws DaoException {
        return null;
        
    }
    
    public void inserirVenda(Venda v) throws DaoException {
        
    }
    
    public void excluirVenda(int cod) throws DaoException {
        
    }
    
    public void alterarVenda(int cod) throws DaoException {

    }
    
    public List<Venda> consultarVendas() throws DaoException {
        return null;
        
    }
    
    public List<Venda> consultarVendasPorCliente(int cod) throws DaoException {
        return null;
        
    }
    
    public Venda consultarVendaPorCod(int cod)throws DaoException {
        return null;
        
    }
        
}
