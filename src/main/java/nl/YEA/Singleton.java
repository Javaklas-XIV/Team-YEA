package nl.YEA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nl.YEA.controller.VraagController;
import nl.YEA.model.Vraag;
import nl.YEA.repos.IngevuldeVragenlijstRepo;

import java.util.List;

public class Singleton {
    private static Singleton singletonInstance;
    private List<Vraag> vragenlijst;
    private VraagController invulController;
    private IngevuldeVragenlijstRepo repo;
    private final EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();

    private Singleton() {
        vragenlijst = new VragenlijstWerkEnGehoor().vragenlijstWerkEnGehoorSamenstellen();
        invulController = new VraagController();
        repo = new IngevuldeVragenlijstRepo(em);
    }

    public static Singleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }

        return singletonInstance;
    }

    public List<Vraag> getVragenlijst() {
        return vragenlijst;
    }

    public VraagController getInvulController() {
        return invulController;
    }

    public IngevuldeVragenlijstRepo getRepo() {
        return repo;
    }

    public void setSingletonInstance(Singleton singletonInstance){
        Singleton.singletonInstance = singletonInstance;
    }

    public void closeDbConnection(){
        em.close();
        mySQL.close();
    }

}
