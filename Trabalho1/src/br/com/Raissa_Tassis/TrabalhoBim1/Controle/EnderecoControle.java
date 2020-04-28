
package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.EnderecoDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Endereco;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import br.com.Raissa_Tassis.TrabalhoBim1.Utils.Valida;
import java.util.List;



public class EnderecoControle {
    
    private EnderecoDao endDao;
    private static EnderecoControle instance;

    public EnderecoControle(EnderecoDao endDao) {
        this.endDao = endDao;
    }

    public EnderecoControle() {
       this.endDao = EnderecoDao.getInstance();
    }
    public static EnderecoControle getInstance(){
        if(instance == null){
            instance = new EnderecoControle();
        }
        return instance;
    }
    
    public String valida(Endereco e) throws ControleException{
        Valida valida = new Valida();
        if(!valida.validaCep(e.getCep())){
            return "CEP inválido";
        }
        if(e.getEstado().length() != 2){
            return "UF inválida. Informe apenas a sigla";
        }
        if(e.getNumero() <= 0 ){
            return "Número inválido. Informe um número maior que 0";
        }
        
        return "OK";
    }
    
    public int inserir(Endereco e, Usuario u) throws ControleException, DaoException{
        int ret = -1;
        String valido = valida(e);
        
        if(valido.equalsIgnoreCase("OK")){
            ret = endDao.inserir(e, u);
        } else {
            throw new ControleException("Erro no inserir endereço"+valido);
        }
        return ret;
    }
    public int alterar(Endereco e) throws ControleException, DaoException{
        String valido = valida(e);     
        if(valido.equals("OK")){
            System.out.println(e.getLogradouro());
            return endDao.alterar(e);
        } else{
            throw new ControleException("Erro no inserir endereço"+valido);
        }
    }
    
    public int excluir(int cd) throws DaoException{
        int ret = endDao.excluir(cd);
        return ret;
    } 
    
    public int excluirPorUsuario(int cd) throws DaoException{
        int ret = endDao.excluirPorUsuario(cd);
        return ret;
    } 
    
    public Endereco ConsultarPorCdEndereco(int cd) throws DaoException{
        Endereco ret = endDao.consultarPorCdEndereco(cd);
        return ret;
    } 
    
    public List<Usuario> consultaPorUsuarios(List<Usuario> us) throws DaoException{
        List<Endereco> es;
        
        for(int i=0; i<us.size();i++){
            es = endDao.consultarPorCd(us.get(i).getCdUsuario());
            us.get(i).setEnderecos(es);
        }
        return us;
    }
    
    public List<Endereco> consultaPorUsuario(Usuario u) throws DaoException{
        List<Endereco> es;
        
        es = endDao.consultarPorCd(u.getCdUsuario());
        u.setEnderecos(es);
        
        return es;
    }
    
     public List<Endereco> consultaPorLogradouro(Usuario u, String logradouro) throws DaoException{
        List<Endereco> es;
        
        es = endDao.consultarPorLogradouro(u.getCdUsuario(), logradouro);
        u.setEnderecos(es);
        
        return es;
    }
    
    
}
