package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.VraagController;

public class InvulScherm implements Scherm{
    Singleton singleton = Singleton.getInstance();
    @Override
    public void show() {
        singleton.getRepo().clearIngevuldeVragenLijst();
        VraagController vraagController = singleton.getInvulController();
        boolean running = true;
        int vraagNr = -1;
        int nextVraagNr = 1;
        while (running){
            vraagNr = vraagController.vraagExists(nextVraagNr) ? nextVraagNr : -1;
            if (vraagNr != -1){
                VraagInvulScherm vraagInvulScherm = InOutputUtil.getInstance().getVraagInvulScherm(nextVraagNr);
                vraagInvulScherm.show();
                nextVraagNr += vraagInvulScherm.getNavigationInput();
            }else{
                running = false;
            }
        }
        singleton.getRepo().saveIngevuldeVragenlijst();
    }
}
