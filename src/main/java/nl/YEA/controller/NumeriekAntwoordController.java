package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.model.NumeriekAntwoord;
import nl.YEA.model.NumeriekeVraag;

public class NumeriekAntwoordController extends AntwoordController {
    private NumeriekeVraagController nvController;

    public void setAntwoord(int antwoord) {
        if (antwoordGoedgekeurd(antwoord)) {
        }
    }

    private boolean antwoordGoedgekeurd(int antwoord) {
        return antwoord >= nvController.getMinimum(antwoord) && antwoord <= nvController.getMaximum(antwoord);
    }

}
