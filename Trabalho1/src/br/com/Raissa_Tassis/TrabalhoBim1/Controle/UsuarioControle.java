package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.UsuarioDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;
import br.com.Raissa_Tassis.TrabalhoBim1.Utils.Valida;
import java.util.List;

public class UsuarioControle {

    private UsuarioDao usuDao;
    private EnderecoControle endControle;
    private HqControle hqControle;
    private CompraControle comControle;
    private static UsuarioControle instance;

    public UsuarioControle(UsuarioDao usuDao, EnderecoControle endControle, HqControle hqControle) {
        this.usuDao = usuDao;
        this.endControle = endControle;
        this.hqControle = hqControle;
    }

    public static UsuarioControle getInstance() {
        if (instance == null) {
            instance = new UsuarioControle();
        }
        return instance;
    }

    public UsuarioControle() {
        this.usuDao = UsuarioDao.getInstance();
    }

    public String validaDados(Usuario u) {

        //valida cpf
        Valida valida = new Valida();
        if (!valida.validaCpf(u.getCpf())) {
            return "CPF inválido";
        }
        if (!valida.validaEmail(u.getEmail())) {
            return "Email inválido";
        }
        if (u.getSenha().length() == 0 || u.getSenha().length() > 20) {
            return "Senha inválida";
        }

        if (u.getNmUsuario().length() > 100 || u.getNmUsuario().length() == 0) {
            return "Nome inválido";
        }
        if (u.getRg().length() != 10) {
            return "RG inválido";
        }
        return "OK";
    }

    public int inserir(Usuario u) throws DaoException, ControleException {
        int ret = -1;
        String valido = validaDados(u);

        if (valido.equalsIgnoreCase("OK")) {
            ret = usuDao.inserir(u);
        } else {
            throw new ControleException("Erro ao inserir usuário: " + valido);
        }

        return ret;
    }

    public int excluir(int cd) throws DaoException {
        endControle = EnderecoControle.getInstance();
        hqControle = HqControle.getInstance();
        comControle = CompraControle.getInstance();

        comControle.alteraComprador(cd);
        comControle.alteraVendedor(cd);

        boolean ret = false;
        boolean ret2 = false;
        boolean ret3 = false;

        if (endControle.excluirPorUsuario(cd) != 0) {
            ret = true;
        }
        if (hqControle.excluirPorUsuario(cd) != 0) {
            ret2 = true;
        }
        if (usuDao.excluir(cd) != 0) {
            ret3 = true;
        }

        if (ret3) {
            return 1;
        } else {
            return 0;
        }
    }

    public int alterar(Usuario u) throws DaoException, ControleException {
        int ret = 0;
        String valida = validaDados(u);

        if (valida.equalsIgnoreCase("ok")) {
            ret = usuDao.alterar(u);
        } else {
            throw new ControleException("Erro ao alterar usuário:" + valida);
        }

        return ret;
    }

    public List<Usuario> consultaTudo() throws DaoException {
        List<Usuario> ret = usuDao.consultaTudo();
        hqControle = HqControle.getInstance();

        for (int i = 0; i < ret.size(); i++) {
            ret.get(i).setHqs(hqControle.consultaTudoUsuario(ret.get(i)));
        }
        return ret;
    }

    public List<Usuario> consultaTudoExceto(int cd) throws DaoException {
        List<Usuario> ret = usuDao.consultarTudoExceto(cd);
        hqControle = HqControle.getInstance();

        for (int i = 0; i < ret.size(); i++) {
            ret.get(i).setHqs(hqControle.consultaTudoUsuario(ret.get(i)));
        }
        return ret;
    }

    public Usuario consultaPorCd(int cd) throws DaoException {
        hqControle = HqControle.getInstance();
        Usuario ret = usuDao.consultarPorCd(cd);
        if (ret != null) {
            ret.setHqs(hqControle.consultaTudoUsuario(ret));
        }
        return ret;
    }

    public Usuario consultaPorEmail(String email) throws DaoException {
        hqControle = HqControle.getInstance();
        Usuario ret = usuDao.consultarPorEmail(email);
        if (ret != null) {
            ret.setHqs(hqControle.consultaTudoUsuario(ret));
        }
        return ret;
    }

    public List<Usuario> consultaPorNome(String nome) throws DaoException {
        List<Usuario> ret = usuDao.consultarPorNome(nome);
        hqControle = HqControle.getInstance();

        for (int i = 0; i < ret.size(); i++) {
            ret.get(i).setHqs(hqControle.consultaTudoUsuario(ret.get(i)));
        }
        return ret;
    }

}
