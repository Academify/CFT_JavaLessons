package br.com.Raissa_Tassis.TrabalhoBim1.Entidade;

import java.util.List;

public class Usuario {
    
    private int cdUsuario;
    private String nmUsuario;
    private String email;
    private String senha;
    private String cpf;
    private String rg;
    private String telefone;
    private List<Endereco> enderecos;
    private List<Hq> hqs;

    public List<Hq> getHqs() {
        return hqs;
    }

    public void setHqs(List<Hq> hqs) {
        this.hqs = hqs;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public void setEndereco(Endereco e){
          this.enderecos.add(e);
    }
    
    public Endereco getEndereco(int pos){
        return enderecos.get(pos);
    }

    public Usuario(){
        
    }
    
    private Usuario(String nmUsuario, String email, String senha, String cpf, String rg, String telefone, List<Endereco> e) {
        this.nmUsuario = nmUsuario;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.enderecos = e;
    }
    
    public static Usuario newInstance(String nmUsuario, String email, String senha, String cpf, String rg, String telefone, List<Endereco> e){
        if(nmUsuario != null && email != null && senha.length() <= 20 && cpf.length() == 11 && rg.length() == 10 && telefone != null && e!=null){
            return new Usuario(nmUsuario, email, senha, cpf, rg, telefone, e);
        }else 
            return null;
    }

    public int getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
