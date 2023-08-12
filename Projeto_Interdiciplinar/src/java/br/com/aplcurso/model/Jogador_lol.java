package br.com.aplcurso.model;

public class Jogador_lol {

    private int idJogadorLOL;
    private String nomeJogadorLOL;
    private double kdaJogadorLOL;
    private double csMinute;
    private int goldMinute;
    private String part;
    
    public Jogador_lol() {
        this.idJogadorLOL = 0;
        this.nomeJogadorLOL = "";
        this.kdaJogadorLOL = 0;
        this.csMinute = 0;
        this.goldMinute = 0;
        this.part = "";
    }

    public Jogador_lol(int idJogadorLOL, String nomeJogadorLOL, double kdaJogadorLOL, double csMinute, int goldMinute, String part) {
        this.idJogadorLOL = idJogadorLOL;
        this.nomeJogadorLOL = nomeJogadorLOL;
        this.kdaJogadorLOL = kdaJogadorLOL;
        this.csMinute = csMinute;
        this.goldMinute = goldMinute;
        this.part = part;
    }

    public int getIdJogadorLOL() {
        return idJogadorLOL;
    }

    public void setIdJogadorLOL(int idJogadorLOL) {
        this.idJogadorLOL = idJogadorLOL;
    }

    public String getNomeJogadorLOL() {
        return nomeJogadorLOL;
    }

    public void setNomeJogadorLOL(String nomeJogadorLOL) {
        this.nomeJogadorLOL = nomeJogadorLOL;
    }

    public double getKdaJogadorLOL() {
        return kdaJogadorLOL;
    }

    public void setKdaJogadorLOL(double kdaJogadorLOL) {
        this.kdaJogadorLOL = kdaJogadorLOL;
    }

    public double getCsMinute() {
        return csMinute;
    }

    public void setCsMinute(double csMinute) {
        this.csMinute = csMinute;
    }

    public int getGoldMinute() {
        return goldMinute;
    }

    public void setGoldMinute(int goldMinute) {
        this.goldMinute = goldMinute;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
    
    
}
