package br.com.aplcurso.model;

public class Player {
    private int idPlayer;
    private Jogo idJogo;
    private String nome;

    public Player(int idPlayer, Jogo idJogo, String nome) {
        this.idPlayer = idPlayer;
        this.idJogo = idJogo;
        this.nome = nome;
    }
    
    public Player() {
        this.idPlayer = 0;
        this.nome = "";
        this.idJogo = new Jogo();
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Jogo getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Jogo idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
