/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Controle;

import br.com.Raissa_Tassis.TrabalhoBim1.Dao.DaoException;
import br.com.Raissa_Tassis.TrabalhoBim1.Dao.UsuarioDao;
import br.com.Raissa_Tassis.TrabalhoBim1.Entidade.Usuario;

/**
 *
 * @author Jos? Fernandes
 */
public class ControleLogin {

    UsuarioDao usuDao;

    public ControleLogin() {
        this.usuDao = UsuarioDao.getInstance();
    }

    public boolean fazerLogin(String email, String senha) throws DaoException {
        Usuario u1 = usuDao.login(email, senha);
        
        if (u1 != null) {
            return true;
        } else {
            return false;
        }
    }

}
