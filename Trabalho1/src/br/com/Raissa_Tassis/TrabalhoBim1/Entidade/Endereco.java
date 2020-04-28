package br.com.Raissa_Tassis.TrabalhoBim1.Entidade;

public class Endereco {
    
    private int cdEndereco;
    private String logradouro;
    private int numero;
    private String complemento;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    
    public Endereco(){
        
    }

    private Endereco(String logradouro, int numero, String complemento, String estado, String cidade, String bairro, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
    }
    
    public static Endereco newInstance(String logradouro, int numero, String complemento, String estado, String cidade, 
        String bairro, String cep){
        if(logradouro != null && numero >= 0 && estado.length() == 2 && cidade != null && bairro != null && cep.length() == 8){
            return new Endereco(logradouro, numero, complemento, estado, cidade, bairro, cep);
        } else
            return null;
    }
    

    public int getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(int cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
