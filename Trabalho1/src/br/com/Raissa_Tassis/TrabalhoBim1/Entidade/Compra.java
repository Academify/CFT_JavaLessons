package br.com.Raissa_Tassis.TrabalhoBim1.Entidade;

import java.util.Date;
import java.util.List;


public class Compra {
    
      private int cdCompra;
      private Date dtCompra;
      private double valorCompra;
      private List<Hq> hqsCompra;
      private Usuario comprador;
      private Usuario vendedor;

    public Compra(){
        
    }  
    
    private Compra(Date dtCompra, double valorCompra) {
        this.dtCompra = dtCompra;
        this.valorCompra = valorCompra;
    }

    public List<Hq> getHqsCompra() {
        return hqsCompra;
    }

    public void setHqsCompra(List<Hq> hqsCompra) {
        this.hqsCompra = hqsCompra;
    }
    
    public void setHqCompra(Hq hqCompra) {
        this.hqsCompra.add(hqCompra);
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }
      
    public static Compra newInstance(Date dtCompra, double valorCompra){
        if(dtCompra != null && valorCompra >= 0){
            return new Compra(dtCompra, valorCompra);
        } else
            return null;
    }  
      
    public int getCdCompra() {
        return cdCompra;
    }

    public void setCdCompra(int cdCompra) {
        this.cdCompra = cdCompra;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
      
      
}
