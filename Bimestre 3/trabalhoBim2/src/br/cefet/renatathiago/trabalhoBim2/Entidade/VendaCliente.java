package br.cefet.renatathiago.trabalhoBim2.Entidade;

public class VendaCliente {
    private int codVenda;
    private int codCliente;
    private String data;
    private double valor;
    private String formapg;
    private String nome;

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormapg() {
        return formapg;
    }

    public void setFormapg(String formapg) {
        this.formapg = formapg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
