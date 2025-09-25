package giuseppetuccilli.dao;

import giuseppetuccilli.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
