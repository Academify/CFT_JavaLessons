package br.com.Raissa_Tassis.TrabalhoBim1.Entidade;

import java.util.ArrayList;
import java.util.List;

public class Obra {
    
    private int cdObra;
    private int dtLancamento;
    private String nmObra;
    private List<Hq> hqs;
    
    public Obra(){
        
    }

    private Obra(int dtLancamento, String nmObra, List<Hq> hqs) {
        this.dtLancamento = dtLancamento;
        this.nmObra = nmObra;
        this.hqs = hqs;
    }
    
    public static Obra newInstance(int dtLancamento, String nmObra, List<Hq> hqs){
        if(nmObra != null){
            return new Obra(dtLancamento, nmObra, hqs);
        }else
            return null;
    }

    public List<Hq> getHqs() {
        return hqs;
    }

    public void setHqs(List<Hq> hqs) {
        this.hqs = hqs;
    }

    public int getCdObra() {
        return cdObra;
    }

    public void setCdObra(int cdObra) {
        this.cdObra = cdObra;
    }

    public int getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(int dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public String getNmObra() {
        return nmObra;
    }

    public void setNmObra(String nmObra) {
        this.nmObra = nmObra;
    }
}
