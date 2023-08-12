/* Olhar apostila !!! */
package br.com.aplcurso.model;

import br.com.aplcurso.utils.Conversao;
import java.util.Date;

public class Partida {
    
    private Integer idPartida;
    private Jogo idJogo;
    private Time timeUm;
    private Time timeDois;
    private Date dataPartida;
    private String hora;

    public Partida() {
        this.idPartida = 0;
        this.idJogo = new Jogo();
        this.timeUm = new Time();
        this.timeDois = new Time();
        this.dataPartida = Conversao.dataAtual();
        this.hora = "";
    }

    public Partida(Integer idPartida, Jogo idJogo, Time timeUm, Time timeDois, Date dataPartida, String hora) {
        this.idPartida = idPartida;
        this.idJogo = idJogo;
        this.timeUm = timeUm;
        this.timeDois = timeDois;
        this.dataPartida = dataPartida;
        this.hora = hora;
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Jogo getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Jogo idJogo) {
        this.idJogo = idJogo;
    }

    public Time getTimeUm() {
        return timeUm;
    }

    public void setTimeUm(Time timeUm) {
        this.timeUm = timeUm;
    }

    public Time getTimeDois() {
        return timeDois;
    }

    public void setTimeDois(Time timeDois) {
        this.timeDois = timeDois;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    
    
}
