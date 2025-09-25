package giuseppetuccilli.dao;

import giuseppetuccilli.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersoneDAO {
    private EntityManager em;

    public PersoneDAO(EntityManager e) {
        this.em = e;
    }

    public void save(Persona e) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(e);
        tr.commit();
    }

    public Persona getById(String id) {
        Persona found = em.find(Persona.class, UUID.fromString(id));
        if (found == null) {
            throw new RuntimeException("persona non trovata");
        }
        return found;
    }

    public void delete(String id) {
        Persona found = this.getById(id);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(found);
        tr.commit();
        System.out.println(" rimosso");
    }
}
