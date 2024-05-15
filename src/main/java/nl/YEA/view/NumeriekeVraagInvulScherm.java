package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.NumeriekAntwoordController;
import nl.YEA.controller.NumeriekeVraagController;

public class NumeriekeVraagInvulScherm extends VraagInvulScherm {
    private InOutputUtil inOutputUtil;

    public NumeriekeVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        inOutputUtil = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        NumeriekeVraagController nvController = singleton.getNumeriekeVraagController();
        NumeriekAntwoordController naController = singleton.getNumeriekAntwoordController();

        inOutputUtil.printNl(nvController.getVraagBeschrijving(super.vraagNr));

        int antwoord = getNumeriekeInput();
        boolean geldigAntwoord = false;
        while (!geldigAntwoord) {
            if (antwoord >= nvController.getMinimum(vraagNr) && antwoord <= nvController.getMaximum(vraagNr)) {
                geldigAntwoord = true;
                naController.addAntwoord(vraagNr, antwoord);
            } else {
                inOutputUtil.printNl("Ongeldig getal");
                antwoord = getNumeriekeInput();
            }
        }
    }

    private int getNumeriekeInput() {
        String strAntwoord = inOutputUtil.getNextLine();
        int antwoord = -1;
        boolean isGetal = false;
        while (!isGetal) {
            try {
                antwoord = Integer.parseInt(strAntwoord);
                isGetal = true;
            } catch (NumberFormatException e) {
                inOutputUtil.printNl("Geen geldige input");
                strAntwoord = inOutputUtil.getNextLine();
            }
        }
        return antwoord;
    }
}
