package giuseppetuccilli;

import giuseppetuccilli.dao.EventiDAO;
import giuseppetuccilli.dao.LoactionsDAO;
import giuseppetuccilli.dao.PartecipazioniDao;
import giuseppetuccilli.dao.PersoneDAO;
import giuseppetuccilli.entities.*;
import giuseppetuccilli.enums.EventType;
import giuseppetuccilli.enums.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

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
        Concerto conc1 = new Concerto("totlo3", d, "lkjlkj", EventType.PUBBLICO, 25, locFromDb, Genere.ROCK, true);
        // ed.save(conc1);
        Partita par2 = new Partita("titoloPart2", d2, "hjghj", EventType.PUBBLICO, 25, locFromDb, "juve", "lecce", 1, 3);
        // ed.save(par2);

        ArrayList<Persona> listaPart = new ArrayList<>();
        Persona p2 = new Persona("tizio", "pluto", "ghghjhgj", d, "M");
        Persona p3 = new Persona("caio", "fghgfh", "ghjghj", d, "M");
        // pd.save(p2);
        //pd.save(p3);
        listaPart.add(pd.getById("7956fbe5-c380-4185-bd6b-599cde916f8d"));
        listaPart.add(pd.getById("d8e8ea4d-dcd8-46d7-abaa-dc373c2c5da0"));
        listaPart.add(pd.getById("ebf91920-7dab-4686-9aa9-fbf92482b7b6"));

        ed.aggPartecipanti(gara1, listaPart);

        System.out.println(ed.getPartVinteCasa());
        System.out.println("fuori casa:" + ed.getPartiteVinTrasferta());
        System.out.println(ed.getConcPerGener(Genere.ROCK));

        em.close();
        emf.close();


        System.out.println("Hello World!");
    }
}
