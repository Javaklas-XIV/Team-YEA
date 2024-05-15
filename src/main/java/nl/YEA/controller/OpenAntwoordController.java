package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.TeGrootAntwoordException;
import nl.YEA.model.OpenAntwoord;
import nl.YEA.repos.IngevuldeVragenlijstRepo;

public class OpenAntwoordController extends AntwoordController{
    public OpenAntwoordController() {}

    public boolean antwoordGoedgekeurd(int vraagNr, String text){
        long nummer = new OpenVraagController().getmaxAantalTekens(vraagNr);
        return text.length() <= nummer && !text.isEmpty();
    }

    public void addAntwoord(int vraagNr, String antwoord){
        if(antwoordGoedgekeurd(vraagNr, antwoord)){
            Singleton.getInstance().getRepo().addAntwoord(new OpenAntwoord(vraagNr, antwoord));
        } else {
            throw new TeGrootAntwoordException("Antwoord mag niet leeg of boven 256 characters zijn");
        }
    }

    public OpenAntwoord getAntwoord(int vraagNr){
        IngevuldeVragenlijstRepo ingevuldeVragenlijstRepo = Singleton.getInstance().getRepo();
        return ((OpenAntwoord)ingevuldeVragenlijstRepo.ingevuldeVragenlijstGetAntwoord(vraagNr));
    }
}