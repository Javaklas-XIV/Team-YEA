package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.model.Antwoord;
import nl.YEA.model.MeerkeuzeAntwoord;
import nl.YEA.repos.IngevuldeVragenlijstRepo;

public class AntwoordController {
    public Antwoord getGeneriekAntwoord(int vraagNr){
        IngevuldeVragenlijstRepo repo = Singleton.getInstance().getRepo();
        return repo.ingevuldeVragenlijstGetAntwoord(vraagNr);
    }

    public boolean antwoordExists(int vraagNr){
        IngevuldeVragenlijstRepo repo = Singleton.getInstance().getRepo();
        return repo.ingevuldeVragenlijstContains(vraagNr);
    }
}
