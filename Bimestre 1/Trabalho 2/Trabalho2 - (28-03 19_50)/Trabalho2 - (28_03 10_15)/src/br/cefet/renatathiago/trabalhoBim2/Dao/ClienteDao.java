
package br.cefet.renatathiago.trabalhoBim2.Dao;

import br.cefet.renatathiago.trabalhoBim2.Entidade.Administrador;
import br.cefet.renatathiago.trabalhoBim2.Entidade.Cliente;
import br.cefet.renatathiago.trabalhoBim2.Excecoes.DaoException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao extends Dao {
    
    private Cliente getClienteFromRs(ResultSet rs) throws DaoException {

        Cliente cli = new Cliente();

        try {

            cli.setCod(rs.getInt("CdCliente"));
            cli.setNome(rs.getString("NmCliente"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setEndereco(rs.getString("endereco"));
            cli.setTipoCliente(rs.getString("tipoCliente"));
            cli.setDocumento(rs.getString("documento"));
           // cli.setVendasCliente(rs.getString("vendasCliente"));
            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.getClienteFromRs", e);
        }

        return cli;
    }
    
    public Cliente consultarPorCod (int cod){
     return null;
    }
}
