package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.AntwoordController;
import nl.YEA.controller.VraagController;
import nl.YEA.model.FormulierObject;
import nl.YEA.model.FormulierOnderdeel;
import nl.YEA.model.Vraag;

import java.util.List;

public class InvulScherm implements Scherm {
    Singleton singleton = Singleton.getInstance();
    InOutputUtil io;

    @Override
    public void show() {
        io = InOutputUtil.getInstance();
        singleton.getRepo().clearIngevuldeVragenLijst();
        VraagController vraagController = singleton.getInvulController();
        List<FormulierObject> vragenlijst = vraagController.getVragenLijst();
        boolean running = true;
        //int vraagNr;
        //int nextVraagNr = 1;
        int i = 0;
        while (running) {
            if (i < vragenlijst.size()) {
                handleFormulierObject(vragenlijst.get(i));
                i++;
            } else {
                running = false;
            }
        }
        singleton.getRepo().saveIngevuldeVragenlijst();
    }
    private void handleFormulierObject(FormulierObject object){
        if (object instanceof FormulierOnderdeel){
            handleFormulierOnderdeel((FormulierOnderdeel) object);
        }else if (object instanceof Vraag){
            handleVraag((Vraag) object);
        }else{
            throw new RuntimeException("formobject not handled in invul scherm");
        }
    }

    private void handleFormulierOnderdeel(FormulierOnderdeel onderdeel){
        io.printNl(onderdeel.getBeschrijving());
        if (onderdeel.isOptioneel()){
            boolean skip = io.handleOptioneel();
            if (skip){
                return;
            }
        }
        for (FormulierObject object:onderdeel.getOnderdeelen()){
            handleFormulierObject(object);
        }
    }

    private void handleVraag(Vraag vraag){
        int vraagNr = vraag.getVraagnummer();
        AntwoordController antwoordController = singleton.getAntwoordController();
        VraagInvulScherm scherm = io.getVraagInvulScherm(vraagNr);
        scherm.show();
        if(antwoordController.antwoordExists(vraag.getVraagnummer())){
            for (FormulierObject object:vraag.getLinksByAntwoord(antwoordController.getGeneriekAntwoord(vraagNr))){
                handleFormulierObject(object);
            }
        }
    }
}
