package nl.YEA.controller;

import nl.YEA.exceptions.GeenNumeriekeVraagException;
import nl.YEA.model.NumeriekeVraag;
import nl.YEA.model.Vraag;

public class NumeriekeVraagController extends VraagController {
    public int getMinimum(int vraagNr) {
        return getNumeriekeVraag(vraagNr).getMinimum();
    }

    public int getMaximum(int vraagNr) {
        return getNumeriekeVraag(vraagNr).getMaximum();
    }

    private NumeriekeVraag getNumeriekeVraag(int vraagNr) {
        Vraag v = super.getVraag(vraagNr);
        if (v instanceof NumeriekeVraag)
            return (NumeriekeVraag) v;
        else
            throw new GeenNumeriekeVraagException();
    }
}
