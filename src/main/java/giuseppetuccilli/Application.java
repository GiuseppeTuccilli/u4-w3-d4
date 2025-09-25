package giuseppetuccilli;

import giuseppetuccilli.dao.EventiDAO;
import giuseppetuccilli.dao.LoactionsDAO;
import giuseppetuccilli.dao.PartecipazioniDao;
import giuseppetuccilli.dao.PersoneDAO;
import giuseppetuccilli.entities.Location;
import giuseppetuccilli.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d4pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);
        PersoneDAO pd = new PersoneDAO(em);
        LoactionsDAO ld = new LoactionsDAO(em);
        PartecipazioniDao pard = new PartecipazioniDao(em);
        LocalDate d = LocalDate.of(1991, 10, 10);
        LocalDate d2 = LocalDate.of(2025, 5, 10);

        Persona p1 = new Persona("pippo", "pluto", "emaildipippo", d, "M");
        Location loc1 = new Location("location1", "Milano");


        em.close();
        emf.close();


        System.out.println("Hello World!");
    }
}
