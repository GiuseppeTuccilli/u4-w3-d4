package giuseppetuccilli.dao;

import giuseppetuccilli.entities.Evento;
import giuseppetuccilli.entities.Partecipazioni;
import giuseppetuccilli.enums.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public List<Partecipazioni> getDaConfPerEvent(Evento ev) {
        TypedQuery<Partecipazioni> query = em.createQuery("SELECT p FROM Partecipazione p WHERE p.evento= :ev AND p.stato = :nonC", Partecipazioni.class);
        query.setParameter("evento", ev);
        query.setParameter("nonC", Stato.NON_CONFERMATA);
        return query.getResultList();
    }

}
