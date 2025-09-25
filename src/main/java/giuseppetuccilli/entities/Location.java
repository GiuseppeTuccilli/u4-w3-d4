package giuseppetuccilli.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID locationId;
    private String nome;
    private String città;

    public Location() {
    }

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }
}
