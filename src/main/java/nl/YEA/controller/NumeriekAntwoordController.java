package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.OngeldigAntwoordException;
import nl.YEA.model.NumeriekAntwoord;

public class NumeriekAntwoordController extends AntwoordController {
    private NumeriekeVraagController nvController = new NumeriekeVraagController();

    public void addAntwoord(int vraagNr, int antwoord) {
        if (antwoordGeldig(vraagNr, antwoord)) {
            Singleton.getInstance().getRepo().addAntwoord(new NumeriekAntwoord(vraagNr, antwoord));
        }
        else
            throw new OngeldigAntwoordException();
    }

    public boolean antwoordGeldig(int vraagNr, int antwoord) {
        return antwoord >= nvController.getMinimum(vraagNr) && antwoord <= nvController.getMaximum(vraagNr);
    }

}
