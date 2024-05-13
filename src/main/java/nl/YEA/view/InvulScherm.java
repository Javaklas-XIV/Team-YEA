package nl.YEA.view;

import nl.YEA.model.MeerkeuzeVraag;
import nl.YEA.model.NumeriekeVraag;
import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;

public class InvulScherm implements Scherm{
    @Override
    public void show() {
        boolean running = true;
        int vraagNr = 0;
        while (running){
            Vraag nextVraag = null;//TODO get volgende vraag
            if (nextVraag != null){
                VraagInvulScherm invulScherm = InOutputController.getInstance().getVraagInvulScherm(nextVraag);
                invulScherm.show();
                vraagNr += invulScherm.getNavigationInput();
            }else{
                running = false;
            }
        }
    }
}
