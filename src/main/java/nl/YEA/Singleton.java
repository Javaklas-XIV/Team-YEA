package nl.YEA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nl.YEA.controller.OpenAntwoordController;
import nl.YEA.controller.OpenVraagController;

import nl.YEA.controller.AntwoordController;
import nl.YEA.controller.MeerkeuzeAntwoordController;
import nl.YEA.controller.MeerkeuzeVraagController;

import nl.YEA.controller.VraagController;
import nl.YEA.model.Vraag;
import nl.YEA.repos.IngevuldeVragenlijstRepo;

import java.util.List;

public class Singleton {
    private static Singleton singletonInstance;
    private List<Vraag> vragenlijst;
    private VraagController invulController;

    private OpenAntwoordController openAntwoordController;
    private OpenVraagController openvraagController;;

    private AntwoordController antwoordController;
    private MeerkeuzeVraagController meerkeuzeVraagController;
    private MeerkeuzeAntwoordController meerkeuzeAntwoordController;

    private IngevuldeVragenlijstRepo repo;
    private final EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();

    private Singleton() {
        vragenlijst = new VragenlijstWerkEnGehoor().vragenlijstWerkEnGehoorSamenstellen();
        invulController = new VraagController();
        repo = new IngevuldeVragenlijstRepo(em);

        openAntwoordController = new OpenAntwoordController();
        openvraagController = new OpenVraagController();

        meerkeuzeVraagController = new MeerkeuzeVraagController();
        meerkeuzeAntwoordController = new MeerkeuzeAntwoordController();
        antwoordController = new AntwoordController();

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

    public AntwoordController getAntwoordController() {
        return antwoordController;
    }

    public IngevuldeVragenlijstRepo getRepo() {
        return repo;
    }

    public static void setSingletonInstance(Singleton singletonInstance){
        Singleton.singletonInstance = singletonInstance;
    }

    public void closeDbConnection(){
        em.close();
        mySQL.close();
    }

    public OpenAntwoordController getOpenAntwoordController() {
        return openAntwoordController;
    }

    public OpenVraagController getOpenvraagController() {
        return openvraagController;
    }

    public MeerkeuzeVraagController getMeerkeuzeVraagController() {
        return meerkeuzeVraagController;
    }

    public MeerkeuzeAntwoordController getMeerkeuzeAntwoordController() {
        return meerkeuzeAntwoordController;

    }
}
