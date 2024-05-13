package nl.YEA.view;

import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;

public class OpenVraagInvulScherm extends VraagInvulScherm{

    public OpenVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputController.getInstance().printNl("open");
    }
}
