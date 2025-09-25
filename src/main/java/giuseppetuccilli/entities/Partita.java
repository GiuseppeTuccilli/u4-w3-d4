package giuseppetuccilli.entities;

import giuseppetuccilli.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partite")
public class Partita extends Evento {
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golSqCasa;
    private int golSqOspite;

    public Partita() {
    }

    public Partita(String titolo, LocalDate data, String desc, EventType tipo, int maxP, Location loc, String sCasa, String sOspite, int golCasa, int golOspite) {
        super(titolo, data, desc, tipo, maxP, loc);
        this.squadraCasa = sCasa;
        this.squadraOspite = sOspite;
        this.golSqCasa = golCasa;
        this.golSqOspite = golOspite;
        if (golCasa > golOspite) {
            this.squadraVincente = sCasa;
        } else if (golOspite > golCasa) {
            this.squadraVincente = sOspite;
        } else {
            this.squadraVincente = null;
        }
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSqCasa() {
        return golSqCasa;
    }

    public void setGolSqCasa(int golSqCasa) {
        this.golSqCasa = golSqCasa;
    }

    public int getGolSqOspite() {
        return golSqOspite;
    }

    public void setGolSqOspite(int golSqOspite) {
        this.golSqOspite = golSqOspite;
    }

    @Override
    public String toString() {
        return "Partita{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSqCasa=" + golSqCasa +
                ", golSqOspite=" + golSqOspite +
                "} " + super.toString();
    }
}
