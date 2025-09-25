package giuseppetuccilli;

import giuseppetuccilli.dao.EventiDAO;
import giuseppetuccilli.dao.LoactionsDAO;
import giuseppetuccilli.dao.PartecipazioniDao;
import giuseppetuccilli.dao.PersoneDAO;
import giuseppetuccilli.entities.Gara;
import giuseppetuccilli.entities.Location;
import giuseppetuccilli.entities.Partita;
import giuseppetuccilli.entities.Persona;
import giuseppetuccilli.enums.EventType;
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
        Persona atleta1 = new Persona("atl", "dfgfd", "emaildip", d, "M");
        /*
        pd.save(p1);
        pd.save(atleta1);
        ld.save(loc1); */
        Persona atFromDb = pd.getById("ebf91920-7dab-4686-9aa9-fbf92482b7b6");
        Location locFromDb = ld.getById("6a1539db-804e-4971-8d2c-5b6bca939eb5");

        Gara gara1 = new Gara("titoloGara", d, "khjkjh", EventType.PUBBLICO, 20, locFromDb, atFromDb.getNome());

        // ed.save(gara1);

        Partita par1 = new Partita("titoloPart", d2, "kkjhkjh", EventType.PUBBLICO, 25, locFromDb, "inter", "milan", 2, 1);
        //ed.save(par1);

        System.out.println(ed.getPartVinteCasa());

        em.close();
        emf.close();


        System.out.println("Hello World!");
    }
}
