package br.cefet.renatathiago.trabalhoBim2.Entidade;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    
    private int cod;
    private int codCliente;
    private String data;
    private double valorTotal;
    private String formaPg;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
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
