package giuseppetuccilli.dao;

import giuseppetuccilli.entities.Concerto;
import giuseppetuccilli.entities.Evento;
import giuseppetuccilli.entities.Partita;
import giuseppetuccilli.enums.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventiDAO {

    private final EntityManager ent;

    public EventiDAO(EntityManager em) {
        this.ent = em;
    }

    public void save(Evento e) {
        EntityTransaction tr = ent.getTransaction();
        tr.begin();
        ent.persist(e);
        tr.commit();
        System.out.println("l' evento " + e.getTitolo() + " è stato salvato");
    }

    public Evento getById(String id) {
        Evento found = ent.find(Evento.class, UUID.fromString(id));
        if (found == null) {
            throw new RuntimeException("evento non trovato");
        }
        return found;
    }

    public void delete(String id) {
        Evento found = this.getById(id);
        EntityTransaction tr = ent.getTransaction();
        tr.begin();
        ent.remove(found);
        tr.commit();
        System.out.println("evento rimosso");
    }

    public List<Partita> getPartVinteCasa() {
        TypedQuery query = ent.createQuery("SELECT p FROM Partita p WHERE p.squadraVincente = p.squadraCasa", Partita.class);
        return query.getResultList();
    }

    public List<Concerto> getConcPerGener(Genere gen) {
        TypedQuery query = ent.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", gen);
        return query.getResultList();
    }
}
