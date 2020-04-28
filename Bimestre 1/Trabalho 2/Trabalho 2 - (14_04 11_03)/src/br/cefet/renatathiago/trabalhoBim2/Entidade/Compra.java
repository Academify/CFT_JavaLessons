package br.cefet.renatathiago.trabalhoBim2.Entidade;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    
    private int cod;
    private int codFornecedor;
    private String data;
    private double valorTotal;
    private String formaPg;
    private List<ProdutoCV> listaP;

    public List<ProdutoCV> getListaP() {
        return listaP;
    }

    public void setListaP(List<ProdutoCV> listaP) {
        this.listaP = listaP;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPg() {
        return formaPg;
    }

    public void setFormaPg(String formaPg) {
        this.formaPg = formaPg;
    }

}
