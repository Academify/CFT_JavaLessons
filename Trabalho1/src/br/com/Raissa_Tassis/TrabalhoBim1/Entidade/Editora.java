/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Raissa_Tassis.TrabalhoBim1.Entidade;

import java.util.List;

/**
 *
 * @author José Fernandes
 */
public class Editora {

    private int cdEditora;
    private String nmEditora;
    private List<Obra> obras;

    public int getCdEditora() {
        return cdEditora;
    }

    public void setCdEditora(int cdEditora) {
        this.cdEditora = cdEditora;
    }

    public String getNmEditora() {
        return nmEditora;
    }

    public void setNmEditora(String nmEditora) {
        this.nmEditora = nmEditora;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }

    
}
