package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.MeerkeuzeAntwoordController;
import nl.YEA.controller.MeerkeuzeVraagController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MeerkeuzeAntwoordInzienScherm extends AntwoordInzienScherm{
    public MeerkeuzeAntwoordInzienScherm(int vraagNr) {
        super(vraagNr);
    }

    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        MeerkeuzeVraagController meerkeuzeVraagController = singleton.getMeerkeuzeVraagController();
        MeerkeuzeAntwoordController meerkeuzeAntwoordController = singleton.getMeerkeuzeAntwoordController();
        String vraagbeschrijving = meerkeuzeVraagController.getVraagBeschrijving(vraagNr);
        List<String> mogelijkeAntwoorden = meerkeuzeVraagController.getMogelijkeAntwoorden(vraagNr);
        int max = meerkeuzeVraagController.getMaxKeuzes(vraagNr);
        int min = meerkeuzeVraagController.getMinKeuzes(vraagNr);
        io.printNl(vraagbeschrijving);
        if (min!=1 || max!=1) {
            io.printNl("(Kies minimaal "+min+" en maximaal "+max+" opties)");
        }
        Set<Integer> gekozen = new HashSet<>();
        if (isHeeftAntwoord()){
            gekozen.addAll(meerkeuzeAntwoordController.getAntwoord(vraagNr));
        }
        printAntwoordKeuzes(io, mogelijkeAntwoorden, gekozen);
    }
    private void printAntwoordKeuzes(InOutputUtil io, List<String> mogelijkeAntwoorden, Set<Integer> gekozen){
        int i = 0;
        for (String keuze:mogelijkeAntwoorden){
            io.print("["+(gekozen.contains(i)?"X":"O")+"] : "+keuze+"\n");
            i++;
        }
    }
}
