package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.MeerkeuzeVraagController;

import java.util.ArrayList;
import java.util.List;

public class MeerkeuzeVraagInvulScherm extends VraagInvulScherm {

    public MeerkeuzeVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        MeerkeuzeVraagController meerkeuzeVraagController = singleton.getMeerkeuzeVraagController();
        String vraagbeschrijving = meerkeuzeVraagController.getVraagBeschrijving(vraagNr);
        List<String> gekozenAntwoorden = new ArrayList<>();
        List<String> mogelijkeAntwoorden = meerkeuzeVraagController.getMogelijkeAntwoorden(vraagNr);
        int max = meerkeuzeVraagController.getMaxKeuzes(vraagNr);
        int min = meerkeuzeVraagController.getMinKeuzes(vraagNr);
        boolean running = true;
        io.printNl(vraagbeschrijving);
        if (meerkeuzeVraagController.getVraag(vraagNr).isOptioneel()){
            io.handleOptioneel();
        }
        while (running) {
            if (!gekozenAntwoorden.isEmpty()) {
                io.print("reeds gekozen antwoorden:\n");
                for (String keuze : gekozenAntwoorden) {
                    io.print(keuze + "\n");
                }
            }
            io.print("min: " + min + "  max: " + max + "\n");
            io.print("maak uw keuze:\n");
            List<String> nogKiesbaareAntworden = new ArrayList<>(mogelijkeAntwoorden);
            nogKiesbaareAntworden.removeAll(gekozenAntwoorden);
            printAntwoordKeuzes(io, nogKiesbaareAntworden);
            int i = nogKiesbaareAntworden.size() + 1;
            if (!gekozenAntwoorden.isEmpty()) {
                io.print("[" + i + "] : wis antwoorden\n");
                i++;
            }
            if (gekozenAntwoorden.size() >= min) {
                io.print("[" + i + "] : akkoord\n");
            }
            running = listenforKeuze(io, nogKiesbaareAntworden, gekozenAntwoorden, min, max);
        }
        int[] antwoordIndexes = new int[gekozenAntwoorden.size()];
        for (int i = 0; i < antwoordIndexes.length; i++) {
            antwoordIndexes[i] = mogelijkeAntwoorden.indexOf(gekozenAntwoorden.get(i));
        }
        singleton.getMeerkeuzeAntwoordController().addToList(vraagNr, antwoordIndexes);

    }

    private void printAntwoordKeuzes(InOutputUtil io, List<String> hedenMogelijkeAntworden) {
        int i = 1;
        for (String keuze : hedenMogelijkeAntworden) {
            io.print("[" + i + "] : " + keuze + "\n");
            i++;
        }
    }

    private boolean listenforKeuze(InOutputUtil io, List<String> hedenMogelijkeKeuzes, List<String> alGekozen,
                                   int min, int max) {
        String input = io.getNextLine();
        int keuze = 0;
        try {
            keuze = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            io.print("geen nummer probeer opniew:\n");
            return true;
        }
        int clearNr = !alGekozen.isEmpty() ? hedenMogelijkeKeuzes.size() + 1 : -1;
        int accept = (alGekozen.size() >= min ? hedenMogelijkeKeuzes.size() + (clearNr != -1 ? 2 : 1) : -1);
        if (keuze <= hedenMogelijkeKeuzes.size() && keuze > 0) {
            alGekozen.add(hedenMogelijkeKeuzes.get(keuze - 1));
            if (alGekozen.size() >= max) {
                return false;
            } else {
                return true;
            }
        } else if (keuze == clearNr && clearNr != -1) {
            alGekozen.clear();
            return true;
        } else if (keuze == accept && accept != -1) {
            return false;
        } else {
            io.print("ongeldige keuze probeer opniew: \n");
            return true;
        }
    }

}
