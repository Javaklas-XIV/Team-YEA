package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.TeGrootAntwoordException;
import nl.YEA.model.OpenAntwoord;

public class OpenAntwoordController extends AntwoordController{

    public boolean antwoordGoedgekeurd(int vraagNr){
        long nummer = new OpenVraagController().getmaxAantalTekens(vraagNr);
        return nummer > 0 && nummer < 257;
    }

    public void addAntwoord(int vraagNr, String antwoord){
        if(antwoordGoedgekeurd(vraagNr)){
            Singleton.getInstance().getRepo().addAntwoord(new OpenAntwoord(vraagNr, antwoord));
        } else {
            throw new TeGrootAntwoordException("Antwoord mag niet leeg of boven 256 characters zijn");
        }
    }
}
