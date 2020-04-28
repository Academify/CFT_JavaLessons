package br.cefet.renatathiago.trabalhoBim2.Entidade;

import java.util.ArrayList;
import java.util.List;

public class Cliente{
   
   private int cod;
   private String nome;
   private String telefone; 
   private String endereco;
   private String tipoCliente;
   private String documento;
   private List<Venda> vendasCliente = new ArrayList();   

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String isTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Venda> getVendasCliente() {
        return vendasCliente;
    }

    public void setVendasCliente(List<Venda> vendasCliente) {
        this.vendasCliente = vendasCliente;
    }

}
