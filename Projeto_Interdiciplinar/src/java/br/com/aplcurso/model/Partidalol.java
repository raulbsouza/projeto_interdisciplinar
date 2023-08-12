
package br.com.aplcurso.model;

/**
 *
 * @author Pref São Francisco
 */
public class Partidalol {
    private int idPartida;
    private String jogoPartida;
    private String campPartida;
    private String timeUm;
    private String timeDois;
    private String dataPartida;
    private String horaPartida;

    public Partidalol(){
        this.idPartida = 0;
        this.jogoPartida = "";
        this.campPartida = "";
        this.timeUm = "";
        this.timeDois = "";
        this.dataPartida = "";
        this.horaPartida = "";
    }
    public Partidalol(int idPartida, String jogoPartida, String campPartida, String timeUm, String timeDois, String dataPartida, String horaPartida) {
        this.idPartida = idPartida;
        this.jogoPartida = jogoPartida;
        this.campPartida = campPartida;
        this.timeUm = timeUm;
        this.timeDois = timeDois;
        this.dataPartida = dataPartida;
        this.horaPartida = horaPartida;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getJogoPartida() {
        return jogoPartida;
    }

    public void setJogoPartida(String jogoPartida) {
        this.jogoPartida = jogoPartida;
    }

    public String getCampPartida() {
        return campPartida;
    }

    public void setCampPartida(String campPartida) {
        this.campPartida = campPartida;
    }

    public String getTimeUm() {
        return timeUm;
    }

    public void setTimeUm(String timeUm) {
        this.timeUm = timeUm;
    }

    public String getTimeDois() {
        return timeDois;
    }

    public void setTimeDois(String timeDois) {
        this.timeDois = timeDois;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    
   
    
}
