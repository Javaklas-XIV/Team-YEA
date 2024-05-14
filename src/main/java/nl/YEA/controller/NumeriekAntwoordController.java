package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.OngeldigAntwoordException;
import nl.YEA.model.NumeriekAntwoord;

public class NumeriekAntwoordController extends AntwoordController {

    public void addAntwoord(int vraagNr, int antwoord) {
        Singleton singleton = Singleton.getInstance();
        NumeriekeVraagController nvController = singleton.getNumeriekeVraagController();
        if (antwoord >= nvController.getMinimum(vraagNr) && antwoord <= nvController.getMaximum(vraagNr)) {
            singleton.getRepo().addAntwoord(new NumeriekAntwoord(vraagNr, antwoord));
        }
        else
            throw new OngeldigAntwoordException();
    }

}
