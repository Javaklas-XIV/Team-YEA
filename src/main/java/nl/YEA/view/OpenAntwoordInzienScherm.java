package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.OpenAntwoordController;
import nl.YEA.controller.OpenVraagController;
import nl.YEA.model.OpenAntwoord;

public class OpenAntwoordInzienScherm extends AntwoordInzienScherm{
    public OpenAntwoordInzienScherm(int vraagNr) {
        super(vraagNr);
    }

    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        OpenAntwoordController openAntwoordController = singleton.getOpenAntwoordController();
        OpenVraagController openVraagController = singleton.getOpenvraagController();
        String beschrijving = openVraagController.getVraagBeschrijving(vraagNr);
        io.printNl(beschrijving);
        if(isHeeftAntwoord()){
            OpenAntwoord antwoord = openAntwoordController.getAntwoord(vraagNr);
            io.printNl(antwoord.getAntwoord());
        } else {
            io.printNl("");
        }
    }
}
