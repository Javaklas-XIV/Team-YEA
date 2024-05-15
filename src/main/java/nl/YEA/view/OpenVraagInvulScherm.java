package nl.YEA.view;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import nl.YEA.Singleton;
import nl.YEA.controller.OpenAntwoordController;
import nl.YEA.controller.OpenVraagController;
import nl.YEA.model.Vraag;

public class OpenVraagInvulScherm extends VraagInvulScherm {

    public OpenVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
//        InOutputUtil.getInstance().printNl("Open-Vraag");
        InOutputUtil inOutputUtil = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();

        OpenVraagController openVraagController = singleton.getOpenvraagController();
        OpenAntwoordController openAntwoordController = singleton.getOpenAntwoordController();
        String beschrijving = openVraagController.getVraagBeschrijving(super.vraagNr);
        int vraagnummer = openVraagController.getVraag(super.vraagNr).getVraagnummer();
        boolean running = true;
        inOutputUtil.print(beschrijving + "\n");
        if (openVraagController.getVraag(vraagNr).isOptioneel()) {
            inOutputUtil.handleOptioneel();
        }
        while (running) {
            String input = inOutputUtil.getNextLine();
            long max = openVraagController.getmaxAantalTekens(vraagNr);
            if (input.length() < max && !input.isEmpty()) {
                openAntwoordController.addAntwoord(vraagnummer, input);
                running = false;
            } else {
                inOutputUtil.printNl("Niks ingevuld/Te lang antwoord, probeer opnieuw:");
            }
        }
    }
}
