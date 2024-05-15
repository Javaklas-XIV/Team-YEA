package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.GeenNumeriekAntwoordException;
import nl.YEA.exceptions.GeenNumeriekeVraagException;
import nl.YEA.exceptions.OngeldigAntwoordException;
import nl.YEA.model.Antwoord;
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

    public int getAntwoord(int vraagNr) {
        Antwoord antwoord = Singleton.getInstance().getRepo().ingevuldeVragenlijstGetAntwoord(vraagNr);
        if (antwoord instanceof NumeriekAntwoord) {
            return ((NumeriekAntwoord) antwoord).getAntwoord();
        } else {
            throw new GeenNumeriekAntwoordException();
        }
    }

}
