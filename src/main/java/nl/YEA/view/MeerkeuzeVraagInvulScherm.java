package nl.YEA.view;

import nl.YEA.model.MeerkeuzeVraag;
import nl.YEA.model.Vraag;

public class MeerkeuzeVraagInvulScherm extends VraagInvulScherm{

    public MeerkeuzeVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputController.getInstance().printNl("meerkeuze");
    }
}
