package giuseppetuccilli.entities;

import giuseppetuccilli.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gare")
public class Gara extends Evento {
    private String vincitore;

    @ManyToMany
    @JoinTable(
            name = "atleti_gare",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private List<Persona> partecipanti;

    public Gara() {
    }

    public Gara(String titolo, LocalDate data, String desc, EventType tipo, int maxP, Location loc, String vin) {
        super(titolo, data, desc, tipo, maxP, loc);
        this.vincitore = vin;

    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public List<Persona> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(List<Persona> partecipanti) {
        this.partecipanti = partecipanti;
    }

    @Override
    public String toString() {
        return "Gara{" +
                "vincitore='" + vincitore + '\'' +
                ", partecipanti=" + partecipanti +
                "} " + super.toString();
    }
}
