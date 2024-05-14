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
        String antwoord = InOutputUtil.getInstance().getNextLine();
        try {
            naController.addAntwoord(super.vraagNr, Integer.parseInt(antwoord));
        } catch (NumberFormatException e) {

        }
    }
}
