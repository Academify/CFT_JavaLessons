package br.cefet.renatathiago.trabalhoBim2.Entidade;

public class CompraFornecedor {
    private int codCompra;
    private int codFornecedor;
    private String data;
    private double valor;
    private String formapg;
    private String nome;

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
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
