package giuseppetuccilli.dao;

import giuseppetuccilli.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LoactionsDAO {
    private EntityManager em;

    public LoactionsDAO(EntityManager e) {
        this.em = e;
    }

    public void save(Location e) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(e);
        tr.commit();
    }

    public Location getById(String id) {
        Location found = em.find(Location.class, UUID.fromString(id));
        if (found == null) {
            throw new RuntimeException("location non trovata");
        }
        return found;
    }

    public void delete(String id) {
        Location found = this.getById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(found);
        tr.commit();
        System.out.println("rimosso");
    }
}
