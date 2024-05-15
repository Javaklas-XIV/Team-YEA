package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.NumeriekAntwoordController;
import nl.YEA.controller.NumeriekeVraagController;

public class NumeriekAntwoordInzienScherm extends AntwoordInzienScherm{
    public NumeriekAntwoordInzienScherm(int vraagNr) {
        super(vraagNr);
    }

    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        NumeriekeVraagController nvController = singleton.getNumeriekeVraagController();
        NumeriekAntwoordController naController = singleton.getNumeriekAntwoordController();
        String vraagbeschrijving = nvController.getVraagBeschrijving(super.vraagNr);
        String antwoord = "";
        if (isHeeftAntwoord()) {
            antwoord += naController.getAntwoord(super.vraagNr);
        }
        io.printNl(vraagbeschrijving);
        io.printNl(antwoord);
    }
}
