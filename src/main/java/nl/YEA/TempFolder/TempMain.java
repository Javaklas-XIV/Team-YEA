package nl.YEA.TempFolder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nl.YEA.model.*;
import nl.YEA.repos.IngevuldeVragenlijstRepo;

public class TempMain {
    private static final EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private static EntityManager em;

    static {
        em = mySQL.createEntityManager();
    }


    public static void main(String[] args) {

        IngevuldeVragenlijst iv = new IngevuldeVragenlijst();
        IngevuldeVragenlijstRepo ingevuldeVragenlijstRepo = new IngevuldeVragenlijstRepo(em);

        NumeriekAntwoord vraag1 = new NumeriekAntwoord(1,25);
        MeerkeuzeAntwoord vraag2 = new MeerkeuzeAntwoord(2,1,3,4);
        OpenAntwoord vraag3 = new OpenAntwoord( 3,"Test");

        ingevuldeVragenlijstRepo.addAntwoord(vraag1);
        ingevuldeVragenlijstRepo.addAntwoord(vraag2);
        ingevuldeVragenlijstRepo.addAntwoord(vraag3);
        ingevuldeVragenlijstRepo.save(iv);
        em.close();
        mySQL.close();
    }
}