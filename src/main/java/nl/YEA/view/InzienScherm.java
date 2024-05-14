package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.AntwoordController;
import nl.YEA.controller.VraagController;

public class InzienScherm implements Scherm{
    Singleton singleton = Singleton.getInstance();
    @Override
    public void show() {
        AntwoordController antwoordController = singleton.getAntwoordController();
        VraagController vraagController = singleton.getInvulController();
        boolean running = true;
        int vraagNr;
        int nextVraagNr = 1;
        while (running){
            vraagNr = vraagController.vraagExists(nextVraagNr) ? nextVraagNr : -1;
            if (vraagNr != -1){
                AntwoordInzienScherm antwoordInzienScherm = InOutputUtil.getInstance().getAntwoordInzienScherm(nextVraagNr);
                antwoordInzienScherm.setHeeftAntwoord(singleton.getRepo().ingevuldeVragenlijstContains(vraagNr));
                antwoordInzienScherm.show();
                nextVraagNr++;
            }else{
                running = false;
            }
        }
    }
}
