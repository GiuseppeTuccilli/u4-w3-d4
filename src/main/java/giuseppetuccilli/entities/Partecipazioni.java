package giuseppetuccilli.entities;

import giuseppetuccilli.enums.Stato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "patecipazioni")
public class Partecipazioni {

    @Id
    @GeneratedValue
    private UUID partId;

    @ManyToOne
    @JoinColumn(name = "personaid", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazioni() {
    }

    public Partecipazioni(Persona per, Evento ev, Stato stato) {
        this.persona = per;
        this.evento = ev;
        this.stato = stato;

    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "stato=" + stato +
                '}';
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Evento getEvento() {
        return evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public UUID getPartId() {
        return partId;
    }
}
