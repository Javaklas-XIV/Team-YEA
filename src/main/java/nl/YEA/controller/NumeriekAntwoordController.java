package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.OnjuistAntwoordException;
import nl.YEA.model.NumeriekAntwoord;

public class NumeriekAntwoordController extends AntwoordController {
    private NumeriekeVraagController nvController;

    public void addAntwoord(int vraagNr, int antwoord) {
        if (antwoordGoedgekeurd(antwoord))
            Singleton.getInstance().getRepo().addAntwoord(new NumeriekAntwoord(vraagNr, antwoord));
        else
            throw new OnjuistAntwoordException();
    }

    private boolean antwoordGoedgekeurd(int antwoord) {
        return antwoord >= nvController.getMinimum(antwoord) && antwoord <= nvController.getMaximum(antwoord);
    }

}
