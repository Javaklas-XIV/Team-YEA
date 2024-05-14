package nl.YEA.view;

import nl.YEA.controller.NumeriekAntwoordController;
import nl.YEA.controller.NumeriekeVraagController;

public class NumeriekeVraagInvulScherm extends VraagInvulScherm {

    private NumeriekeVraagController nvController = new NumeriekeVraagController();
    private NumeriekAntwoordController naController = new NumeriekAntwoordController();


    public NumeriekeVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputUtil.getInstance().printNl(nvController.getVraagBeschrijving(super.vraagNr));

        int antwoord = getNumeriekeInput();
        boolean geldigAntwoord = false;
        while (!geldigAntwoord) {
            if (antwoord >= nvController.getMinimum(vraagNr) && antwoord <= nvController.getMaximum(vraagNr)) {
                geldigAntwoord = true;
                naController.addAntwoord(vraagNr, antwoord);
            } else {
                InOutputUtil.getInstance().printNl("Ongeldig getal");
                antwoord = getNumeriekeInput();
            }
        }
    }

    private int getNumeriekeInput() {
        String strAntwoord = InOutputUtil.getInstance().getNextLine();
        int antwoord = -1;
        boolean isGetal = false;
        while (!isGetal) {
            try {
                antwoord = Integer.parseInt(strAntwoord);
                isGetal = true;
            } catch (NumberFormatException e) {
                InOutputUtil.getInstance().printNl("Geen geldige input");
                strAntwoord = InOutputUtil.getInstance().getNextLine();
            }
        }
        return antwoord;
    }
}
