package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.model.Vraag;

public class VraagController {
    public String getVraagBeschrijving(int vraagNr){
        return getVraag(vraagNr).getBeschrijving();
    }
    public Vraag getVraag(int vraagNr){
        return Singleton.getInstance().getVragenlijst().get(vraagNr-1);
    }
    public boolean vraagExists(int vraagNr){
        return Singleton.getInstance().getVragenlijst().size()>=vraagNr && 0<vraagNr;
    }
}
