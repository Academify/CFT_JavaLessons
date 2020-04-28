package br.cefet.renata.trabalhoBim1.entidade;

public class Aluno {

    private int CdAluno;
    private String NmAluno;
    private String CpfAluno;
    private String RgAluno;
    private String FoneAluno;
    
    public int getCdAluno() {
        return CdAluno;
    }

    public void setCdAluno(int CdAluno) {
        this.CdAluno = CdAluno;
    }
    
    public String getNmAluno() {
        return NmAluno;
    }

    public void setNmAluno(String NmAluno) {
        this.NmAluno = NmAluno;
    }

    public String getCpfAluno() {
        return CpfAluno;
    }

    public void setCpfAluno(String CpfAluno) {
        this.CpfAluno = CpfAluno;
    }

    public String getRgAluno() {
        return RgAluno;
    }

    public void setRgAluno(String RgAluno) {
        this.RgAluno = RgAluno;
    }

    public String getFoneAluno() {
        return FoneAluno;
    }

    public void setFoneAluno(String FoneAluno) {
        this.FoneAluno = FoneAluno;
    }
}
