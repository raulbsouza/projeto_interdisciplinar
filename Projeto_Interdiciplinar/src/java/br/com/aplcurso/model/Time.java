package br.com.aplcurso.model;

public class Time {
    
    private Integer idTime;
    private Jogo idJogo;
    private String nomeTime;

    public Time() {
        this.idTime = 0;
        this.idJogo = new Jogo();
        this.nomeTime = "";
    }

    public Time(Integer idTime, Jogo idJogo, String nomeTime) {
        this.idTime = idTime;
        this.idJogo = idJogo;
        this.nomeTime = nomeTime;
    }

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }

    public Jogo getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Jogo idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    
    
}
