
package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.HqDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Hq;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Obra;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import java.util.List;

public class HqControle {
    private HqDao hqDao;
    private ObraControle oControle;
    private static HqControle instance;
    private CompraControle comControle;
    
    public static HqControle getInstance(){
        if(instance == null){
            instance = new HqControle();
        }
        return instance;
    }

    public HqControle(HqDao hqDao, ObraControle oControle) {
        this.hqDao = hqDao;
        this.oControle = oControle;
    }

    public HqControle() {
        this.hqDao = HqDao.getInstance();
    }

    //double preco, String nmHq, String vendaApenas, String aluguelApenas, String vendaAluguel
    private String validaDados(Hq hq){
           //valida todos os dados
        if (hq.getNmHq()!= null && hq.getNmHq()instanceof String) {
        } else {
            return "Erro de tipo do nome da HQ";
        }
        if (hq.getPreco() < 0){
            return "Preço inválido";
        } 
        if (hq.getSinopse().length() > 100) {
            return "A sinopse deve ter no máximo 100 caracteres";
        }    
        if (hq.getConservacao().length() > 45) {
            return "O estado de conservação deve ter no máximo 45 caracteres";
        }
        return "ok";
    }
    
    public int inserir(Hq hq, Obra o, Usuario u ) throws ControleException, DaoException{
        String valida = validaDados(hq);
        int ret;
        
         if (valida.equalsIgnoreCase("ok")) {
            ret = hqDao.inserir(hq, o, u);
        } else {
            throw new ControleException("Erro ao inserir categoria:" + valida);
        }
        return ret;
    }
    
    public int alterar(Hq hq) throws DaoException, ControleException{
        int ret = 0;
        String valida = validaDados(hq);

        if (valida.equalsIgnoreCase("ok")) {
            ret = hqDao.alterar(hq);
        } else {
            throw new ControleException("Erro ao alterar usuário:" + valida);
        }
        return ret;
    }
    
     public int alterarDono(Hq hq, Usuario u) throws DaoException {
        int ret = 0;
        ret = hqDao.alterarDono(hq, u);
       
        return ret;
    }
    
    
    
    public int excluir(int id) throws DaoException{
        comControle = CompraControle.getInstance();
        comControle.alteraHq(id);
        return hqDao.excluir(id);
    }
    
    public int excluirPorObra(int id) throws DaoException{
        return hqDao.excluirPorObra(id);
    }
    
     int excluirPorUsuario(int cd) throws DaoException {
         return hqDao.excluirPorUsuario(cd);
    }
     
    public List<Hq> consultaTudo() throws DaoException{
        List<Hq> todos = hqDao.consultaTudo();
        return todos;
    }
    
    public List<Hq> consultaTudoUsuario(Usuario u) throws DaoException{
        List<Hq> todosUsuario = hqDao.consultaTudoUsuario(u);
        return todosUsuario;
    }
    
    public List<Hq> consultaTudoObra(Obra o) throws DaoException{
        List<Hq> todosObra = hqDao.consultaTudoObra(o);
        return todosObra;
    }
    
    public List<Hq> consultaPorNome(String nome) throws DaoException{
        List<Hq> todosNome = hqDao.consultarPorNome(nome);
        return todosNome;
    }  
     
    public List<Hq> consultaVendaUsuario(Usuario u) throws DaoException{
        List<Hq> hqs = hqDao.consultaVendaUsuario(u);
        return hqs;
    } 
     
    public Hq consultaPorCd(int cd) throws DaoException{
        Hq hq = hqDao.consultarPorCd(cd);
        return hq;
    }

    public Obra consultaObraPorCd(int cdHq) throws DaoException {
        Obra o = hqDao.consultarObraPorCd(cdHq);
        return o;
    }

    public List<Hq> consultaPorNomeUsuario(String text, Usuario uLogado) throws DaoException {
        List<Hq> hqs = hqDao.consultarPorNomeUsuario(text, uLogado);
        return hqs;
    }

    public List<Hq> consultaRelatorio(String nome, Double preco1, Double preco2) throws DaoException {
        List<Hq> hqs = hqDao.consultaRelatorio(nome, preco1, preco2);
        return hqs;
    }
        

   
     
}
