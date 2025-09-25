package giuseppetuccilli.dao;

import giuseppetuccilli.entities.Partecipazioni;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioniDao {
    private EntityManager em;

    public PartecipazioniDao(EntityManager e) {
        this.em = e;
    }

    public void save(Partecipazioni e) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(e);
        tr.commit();
    }

    public Partecipazioni getById(String id) {
        Partecipazioni found = em.find(Partecipazioni.class, UUID.fromString(id));
        if (found == null) {
            throw new RuntimeException("location non trovata");
        }
        return found;
    }

    public void delete(String id) {
        Partecipazioni found = this.getById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(found);
        tr.commit();
        System.out.println("rimosso");
    }

}
