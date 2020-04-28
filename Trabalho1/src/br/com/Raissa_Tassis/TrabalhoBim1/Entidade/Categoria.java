package br.com.Raissa_Tassis.TrabalhoBim1.Entidade;

import java.util.List;

public class Categoria {
    private int cdCategoria;
    private String nmCategoria;
    private List<Obra> obras;

    public Categoria(){
        
    }
    
    private Categoria(String nmCategoria) {
        this.nmCategoria = nmCategoria;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }
    
     public void setObra(Obra obra) {
        this.obras.add(obra);
    }
    
    public static Categoria newInstance(String nmCategoria){
        if(nmCategoria != null){
           return new Categoria(nmCategoria);
        } else
            return null;
    }
    
    public int getCdCategoria() {
        return cdCategoria;
    }

    public void setCdCategoria(int cdCategoria) {
        this.cdCategoria = cdCategoria;
    }

    public String getNmCategoria() {
        return nmCategoria;
    }

    public void setNmCategoria(String nmCategoria) {
        this.nmCategoria = nmCategoria;
    }
    
    @Override
    public String toString(){
        return this.cdCategoria + " - " + this.nmCategoria;
    }
    
    
}
