package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.AntwoordIndexOutOfBoundsException;
import nl.YEA.exceptions.ToFewAntwoordenException;
import nl.YEA.exceptions.ToManyAntwoordenException;
import nl.YEA.model.MeerkeuzeAntwoord;
import nl.YEA.repos.IngevuldeVragenlijstRepo;

public class MeerkeuzeAntwoordController extends AntwoordController{

    public void addToList(int vraagId, int[] antwoord){
        IngevuldeVragenlijstRepo repo = Singleton.getInstance().getRepo();
        MeerkeuzeVraagController vraagController = Singleton.getInstance().getMeerkeuzeVraagController();
        if (vraagController.getMinKeuzes(vraagId)> antwoord.length){
            throw new ToFewAntwoordenException();
        }
        if (vraagController.getMaxKeuzes(vraagId)< antwoord.length){
            throw new ToManyAntwoordenException();
        }
        for (int i : antwoord){
            if (i<0||i>vraagController.getMogelijkeAntwoorden(vraagId).size()){
                throw new AntwoordIndexOutOfBoundsException();
            }
        }
        repo.addAntwoord(new MeerkeuzeAntwoord(vraagId,antwoord));
    }
}
