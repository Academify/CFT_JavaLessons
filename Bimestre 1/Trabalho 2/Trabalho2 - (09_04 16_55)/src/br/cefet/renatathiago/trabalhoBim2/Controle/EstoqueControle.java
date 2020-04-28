package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.LojaDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.VendaDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Produto;
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

    
    public void inserirCompra(List<Produto> listaP, Compra c) throws DaoException {
        
        try{
            double valor = 0;
            for (int i=0; i<listaP.size(); i++){
                valor = valor + listaP.get(i).getPreco();
            }
            c.setValorTotal(valor);
            
            if (valor > 0){
                cDao.inserir(c);
                for (int i=0; i<listaP.size(); i++){
                    cDao.inserirProdutoEmCompra(c.getCod(), listaP.get(i).getCod(), );
                }
                lDao.diminuirSaldo(c.getValorTotal());  
            }

            
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
        
        try{
        
            vDao.inserir(v);
            lDao.aumentarSaldo(v.getValorTotal());  
            
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirVenda", e); 
        }
    }
    
    public void excluirVenda(int cod) throws DaoException {
        
        lDao.diminuirSaldo(vDao.consultarPorCod(cod).getValorTotal());
        vDao.excluir(cod);    
    }
    
    public void alterarVenda(int cod, Venda v2) throws DaoException {
    
        try{
        
            lDao.aumentarSaldo(vDao.consultarPorCod(cod).getValorTotal());
            lDao.diminuirSaldo(v2.getValorTotal());
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
