package br.cefet.renatathiago.trabalhoBim2.Controle;

import br.cefet.renatathiago.trabalhoBim2.Dao.CompraDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.CompraProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Dao.ProdutoDao;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Compra;
import br.cefet.renatathiago.trabalhoBim2.Entidade.CompraProduto;
import br.cefet.renatathiago.trabalhoBim2.Entidade.ProdutoCV;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.util.ArrayList;
import java.util.List;

public class CompraControle {
    
    CompraDao cDao = new CompraDao();
    ProdutoDao pDao = new ProdutoDao();
    CompraProdutoDao cpDao = new CompraProdutoDao();

    
    public void inserirCompra(Compra c , List<ProdutoCV> listaP) throws DaoException {
        
        try{
            double valor = 0;
            for (int i=0; i<listaP.size(); i++){
                valor = valor + listaP.get(i).getPrecoCompra()*listaP.get(i).getQtd();
            }
            c.setValorTotal(valor);
            
            cDao.inserir(c);
            int quantEstoque;
            
            for (int i=0; i<listaP.size(); i++){
                    cpDao.inserirProduto(c.getCod(), listaP.get(i).getCod(), listaP.get(i).getQtd(), listaP.get(i).getPrecoCompra());
                    quantEstoque = listaP.get(i).getQtdEstoque();
                    pDao.alterarQtdEstoque(quantEstoque + listaP.get(i).getQtd(), listaP.get(i).getCod());
            }
             
        } catch(DaoException e){  
            throw new DaoException("Erro no metodo EstoqueControle.inserirCompra", e); 
        }
    } //PRONTO
    
    public void excluirCompra(int codcompra) throws DaoException {

        Compra c = new Compra();
        int quantEstoque;
        List<ProdutoCV> listaP = new ArrayList();
        listaP = consultarProdutos(codcompra);
        for (int i = 0; i<listaP.size(); i++){
            quantEstoque = pDao.consultarPorCod(listaP.get(i).getCod()).getQtdEstoque();
            pDao.alterarQtdEstoque(quantEstoque - cpDao.consultarQtdProdutoEmCompra(codcompra, listaP.get(i).getCod()), listaP.get(i).getCod());            
            excluirProdutoDeCompra(codcompra, listaP.get(i).getCod());
        }
        cDao.excluir(codcompra);
        
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
    
    public Compra consultarPorCod(int cod) throws DaoException {
        
        Compra C = new Compra ();
        C = cDao.consultarPorCod(cod);
        return C;
        
    }
    
    public void excluirProdutoDeCompra(int codcompra, int codproduto) throws DaoException{
        
        double valorAntigo;
        double valorNovo;
        int quantEstoque;
        
        try{
            valorAntigo = cDao.consultarPorCod(codcompra).getValorTotal();
            quantEstoque = pDao.consultarPorCod(codproduto).getQtdEstoque();
            pDao.alterarQtdEstoque(quantEstoque - cpDao.consultarQtdProdutoEmCompra(codcompra, codproduto), codproduto);            
            cpDao.excluirProduto(codcompra, codproduto);
            valorNovo = valorAntigo - pDao.consultarPorCod(codproduto).getPrecoCompra()*cpDao.consultarQtdProdutoEmCompra(codcompra, codproduto);
            cDao.alterarValorCompra(valorNovo, codcompra);
            
        } catch (DaoException e){
            throw new DaoException("Erro no metodo EstoqueControle.excluirProdutoDeCompra", e); 

        }
    }
    
    public void inserirProdutoEmCompra(int codcompra, int codproduto, int qtd) throws DaoException {
        
        try{    
            
            double valorAntigo = cDao.consultarPorCod(codcompra).getValorTotal();
            int quantEstoque = pDao.consultarPorCod(codproduto).getQtdEstoque();
            cpDao.inserirProduto(codcompra, codproduto, qtd, pDao.consultarPorCod(codproduto).getPrecoCompra());
            pDao.alterarQtdEstoque(quantEstoque + qtd, codproduto);
            double valorNovo = valorAntigo +  pDao.consultarPorCod(codproduto).getPrecoCompra()*qtd;
            cDao.alterarValorCompra(valorNovo, codcompra);
            
        } catch (DaoException e){
            throw new DaoException ("Erro no método EstoqueControle.inserirProdutoEmCompra", e);
        }
    } 
    
    public List<ProdutoCV> consultarProdutos (int cod) throws DaoException{
        
        List<CompraProduto> listaCP = new ArrayList();
        List<ProdutoCV> listaP = new ArrayList();
        listaCP = cpDao.consultarCompraProdutos(cod);
        ProdutoCV p = new ProdutoCV();
        
        for (int i = 0; i<listaCP.size(); i++){
            p = pDao.deProdutoParaProdutoCVCompra(pDao.consultarPorCod(listaCP.get(i).getCodProduto()), listaCP.get(i).getQtd());
            listaP.add(p);
        }
        return listaP;
    }     
    
    public static void main(String[] args) throws DaoException {
        CompraControle cc = new CompraControle();
        cc.excluirProdutoDeCompra(2, 3);
    }
}