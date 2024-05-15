package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.OpenAntwoordController;
import nl.YEA.controller.OpenVraagController;
import nl.YEA.model.Antwoord;
import nl.YEA.model.OpenAntwoord;

public class OpenAntwoordInzienScherm extends AntwoordInzienScherm{
    public OpenAntwoordInzienScherm(int vraagNr) {
        super(vraagNr);
    }

    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        io.printNl(" ");
        OpenAntwoordController openAntwoordController = singleton.getOpenAntwoordController();
        OpenVraagController openVraagController = singleton.getOpenvraagController();
        OpenAntwoord antwoord = openAntwoordController.getAntwoord(vraagNr);
        String beschrijving = openVraagController.getVraagBeschrijving(vraagNr);
        io.printNl(beschrijving);
        io.printNl(antwoord.getAntwoord());
        io.printNl(" ");
    }
}
