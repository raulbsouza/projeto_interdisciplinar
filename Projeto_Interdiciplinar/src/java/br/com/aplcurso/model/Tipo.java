package br.com.aplcurso.model;

public class Tipo {
    
    private int idtipo;
    private String nome;

    public Tipo(int idtipo, String nome) {
        this.idtipo = idtipo;
        this.nome = nome;
    }

    public Tipo() {
        this.idtipo = 0;
        this.nome = "";
    }
    
    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
