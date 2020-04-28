
package br.com.Raissa_Tassis.TrabalhoBim1.Entidade;

public class Hq {
    private int cdHq;
    private double preco;
    private String nmHq;
    private String sinopse;
    private String conservacao;
    
    public Hq(){
        
    }
    
     private Hq(double preco, String nmHq, String sinopse, String conservacao) {
        this.preco = preco;
        this.nmHq = nmHq;
        this.sinopse = sinopse;
        this.conservacao = conservacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }
     
    public int getCdHq() {
        return cdHq;
    }

    public void setCdHq(int cdHq) {
        this.cdHq = cdHq;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNmHq() {
        return nmHq;
    }

    public void setNmHq(String nmHq) {
        this.nmHq = nmHq;
    }
    
    
    
}
