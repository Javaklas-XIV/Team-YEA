package nl.YEA;

import nl.YEA.model.Vraag;

import java.util.List;

public class Singleton {
    private static Singleton singletonInstance;
    private static List<Vraag> vragenlijst;

    private Singleton() {
        vragenlijst = new VragenlijstWerkEnGehoor().vragenlijstWerkEnGehoorSamenstellen();
    }

    public static Singleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }

        return singletonInstance;
    }

    public static List<Vraag> getVragenlijst() {
        return vragenlijst;
    }
}
