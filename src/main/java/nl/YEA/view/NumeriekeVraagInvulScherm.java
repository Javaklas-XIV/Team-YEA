package nl.YEA.view;

import nl.YEA.model.NumeriekeVraag;
import nl.YEA.model.Vraag;

public class NumeriekeVraagInvulScherm extends VraagInvulScherm {

    public NumeriekeVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputController.getInstance().printNl("num");
    }
}