package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.LojaDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Venda;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.ControleException;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueControle{
    
    CompraDao cDao = new CompraDao();
    VendaDao vDao = new VendaDao();
    LojaDao lDao = new LojaDao();
     
    public void inserirCompra(Compra c) throws DaoException {
        
        try{
        
            cDao.inserir(c);
            lDao.diminuirSaldo(c.getValorTotal());  
            
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirCompra", e); 
        }
    }
    
    public void excluirCompra(int cod) throws DaoException {
        
        lDao.aumentarSaldo(cDao.consultarPorCod(cod).getValorTotal());
        cDao.excluir(cod);
        
    }    
    
    public void alterarCompra(int cod, Compra c2) throws DaoException {
        
        try{
        
            lDao.diminuirSaldo(cDao.consultarPorCod(cod).getValorTotal());
            lDao.aumentarSaldo(c2.getValorTotal());
            cDao.alterar(cod, c2);
            
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirCompra", e); 
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
    
    public void inserirVenda(Venda v) throws DaoException {
        
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
