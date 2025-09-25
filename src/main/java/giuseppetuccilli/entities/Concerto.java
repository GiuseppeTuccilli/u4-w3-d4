package giuseppetuccilli.entities;

import giuseppetuccilli.enums.EventType;
import giuseppetuccilli.enums.Genere;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {
    private Genere genere;
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate data, String desc, EventType tipo, int maxP, Location loc, Genere gen, boolean stream) {
        super(titolo, data, desc, tipo, maxP, loc);
        this.inStreaming = stream;
        this.genere = gen;

    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
