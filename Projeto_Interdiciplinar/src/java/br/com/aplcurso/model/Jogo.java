package br.com.aplcurso.model;

public class Jogo {

    private int idJogo;
    private String descricao;
    private String tipo;

    public Jogo() {
        this.idJogo = 0;
        this.descricao = "";
        this.tipo = "";
    }

    public Jogo(int idJogo, String descricao, String tipo) {
        this.idJogo = idJogo;
        this.descricao = descricao;
        this.tipo = tipo;
    }
    

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}