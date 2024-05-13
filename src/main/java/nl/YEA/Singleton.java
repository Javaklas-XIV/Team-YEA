package nl.YEA;

import nl.YEA.controller.VraagController;
import nl.YEA.model.Vraag;

import java.util.List;

public class Singleton {
    private static Singleton singletonInstance;
    private List<Vraag> vragenlijst;
    private VraagController invulController;

    private Singleton() {
        vragenlijst = new VragenlijstWerkEnGehoor().vragenlijstWerkEnGehoorSamenstellen();
        invulController = new VraagController();
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

    public void setSingletonInstance(Singleton singletonInstance){
        Singleton.singletonInstance = singletonInstance;
    }

}
