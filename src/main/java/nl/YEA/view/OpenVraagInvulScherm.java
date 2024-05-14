package nl.YEA.view;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import nl.YEA.Singleton;
import nl.YEA.controller.OpenAntwoordController;
import nl.YEA.controller.OpenVraagController;
import nl.YEA.model.Vraag;

public class OpenVraagInvulScherm extends VraagInvulScherm{
    private InOutputUtil inOutputUtil;
    private OpenVraagController openVraagController;
    private OpenAntwoordController openAntwoordController;
    public OpenVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputUtil.getInstance().printNl("Open-Vraag");
        OpenVraagController openVraagController = new OpenVraagController();
        OpenAntwoordController openAntwoordController = new OpenAntwoordController();
        String beschrijving = openVraagController.getVraagBeschrijving(super.vraagNr);
        Vraag vraag = openVraagController.getVraag(super.vraagNr);
        int nummer = vraag.getVraagnummer();
        boolean running = true;


        while (running) {
            inOutputUtil = InOutputUtil.getInstance();
            inOutputUtil.print("\n"+"Vraag "+nummer+":\n"+ "\n" + beschrijving);
            String input = inOutputUtil.getNextLine();
            long max = openVraagController.getmaxAantalTekens(vraagNr);
            if (input.length() < max && !input.isEmpty()) {
                openAntwoordController.addAntwoord(nummer, input);
                running = false;
                inOutputUtil.print("""

                        Vraag succesvol opgeslagen

                        """);
            } else {
                inOutputUtil.print("""

                        Niks ingevuld/Te lang antwoord, probeer opnieuw
                        
                        """);
            }
        }
    }
}
