package nl.YEA.TempFolder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TempMain {
    private static final EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private static EntityManager em;

    static {
        em = mySQL.createEntityManager();
    }

    public static void main(String[] args) {
        TempTestRepo tempTestRepo = new TempTestRepo(em);
        TempTest klaas = new TempTest("Klaas", "Male");
        tempTestRepo.save(klaas);
        em.close();
        mySQL.close();
    }
}