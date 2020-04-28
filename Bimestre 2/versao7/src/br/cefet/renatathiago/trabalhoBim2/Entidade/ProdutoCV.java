package br.cefet.renatathiago.trabalhoBim2.Entidade;

public class ProdutoCV extends Produto {
    
    private int qtd;
    private double precoAntigo;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPrecoAntigo() {
        return precoAntigo;
    }

    public void setPrecoAntigo(double precoAntigo) {
        this.precoAntigo = precoAntigo;
    }
    
}
