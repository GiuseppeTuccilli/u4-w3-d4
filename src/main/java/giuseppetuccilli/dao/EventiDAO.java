package giuseppetuccilli.dao;

import giuseppetuccilli.entities.*;
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

    public void aggPartecipanti(Gara gara, List<Persona> persone) {
        EntityTransaction tr = ent.getTransaction();
        tr.begin();
        gara.setPartecipanti(persone);
        ent.merge(gara);
        tr.commit();

    }

    public List<Partita> getPartVinteCasa() {
        TypedQuery<Partita> query = ent.createQuery("SELECT p FROM Partita p WHERE p.squadraVincente = p.squadraCasa", Partita.class);
        return query.getResultList();
    }

    public List<Concerto> getConcPerGener(Genere gen) {
        TypedQuery<Concerto> query = ent.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", gen);
        return query.getResultList();
    }

    public List<Concerto> getConcStreaming(boolean isStr) {
        TypedQuery<Concerto> query = ent.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :isStr", Concerto.class);
        query.setParameter("isStr", isStr);
        return query.getResultList();
    }

    public List<Partita> getPartiteVinTrasferta() {
        TypedQuery<Partita> query = ent.createNamedQuery("partVinTrasferta", Partita.class);
        return query.getResultList();
    }

    public List<Partita> getPareggiate() {
        TypedQuery<Partita> query = ent.createQuery("SELECT p FROM Partita p WHERE p.golSqCasa = p.golSqOspite", Partita.class);
        return query.getResultList();
    }

    public List<Gara> getGaraPerVincitore(Persona vincitore) {
        TypedQuery<Gara> query = ent.createQuery("SELECT g FROM Gara g WHERE g.vincitore = :nomeVin", Gara.class);
        query.setParameter("nomeVin", vincitore.getNome());
        return query.getResultList();
    }

   
}
