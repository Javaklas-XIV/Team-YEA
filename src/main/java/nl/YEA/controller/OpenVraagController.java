package nl.YEA.controller;

import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;

public class OpenVraagController extends VraagController {
    public long getmaxAantalTekens(int vraagNr){
        if(vraagExists(vraagNr)) {
            Vraag vraag = getVraag(vraagNr);
            if (vraag.getClass().equals(OpenVraag.class)) {
                return ((OpenVraag) vraag).getMaxAantalTekens();
            }
        }
        return 256;
    }
}
