package giuseppetuccilli.entities;

import giuseppetuccilli.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "partVinTrasferta", query = "SELECT p FROM Partita p WHERE p.squadraVincente = p.squadraOspite")
public class Evento {
    @Id
    @GeneratedValue
    @Column(name = "evento_id")
    protected UUID id;
    protected String titolo;
    protected LocalDate dataEvento;
    protected String descrizione;

    @Enumerated(EnumType.STRING)
    protected EventType tipoEvento;

    protected int maxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id")
    protected Location location;

    public Evento() {
    }


    public Evento(String titolo, LocalDate data, String desc, EventType tipo, int maxP, Location loc) {
        this.titolo = titolo;
        this.descrizione = desc;
        this.tipoEvento = tipo;
        this.maxPartecipanti = maxP;
        this.dataEvento = data;
        this.location = loc;
    }

    public UUID getId() {
        return this.id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getMaxPartecipanti() {
        return maxPartecipanti;
    }

    public void setMaxPartecipanti(int maxPartecipanti) {
        this.maxPartecipanti = maxPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", maxPartecipanti=" + maxPartecipanti +
                '}';
    }
}