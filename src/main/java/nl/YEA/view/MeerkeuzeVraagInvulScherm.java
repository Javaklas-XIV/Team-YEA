package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.MeerkeuzeVraagController;
import nl.YEA.controller.VraagController;
import nl.YEA.model.Antwoord;
import nl.YEA.model.MeerkeuzeAntwoord;

import java.util.ArrayList;
import java.util.List;

public class MeerkeuzeVraagInvulScherm extends VraagInvulScherm{

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
        List<String> mogenlijkeAntwoorden = meerkeuzeVraagController.getMogenlijkeAntwoorden(vraagNr);
        int max = meerkeuzeVraagController.getMaxKeuzes(vraagNr);
        int min = meerkeuzeVraagController.getMinKeuzes(vraagNr);
        boolean running = true;
        while (running){
            io.printNl(vraagbeschrijving);
            if (gekozenAntwoorden.size()>0) {
                io.print("reeds gekozen antwoorden:\n");
                for (String keuze : gekozenAntwoorden){
                    io.print(keuze+"\n");
                }
            }
            io.print("min: "+min+"  max: "+max+"\n");
            io.print("maak u keuze:\n");
            List<String> hedenMogenlijkeAntworden = new ArrayList<>(mogenlijkeAntwoorden);
            hedenMogenlijkeAntworden.removeAll(gekozenAntwoorden);
            printAntwoordKeuzes(io, hedenMogenlijkeAntworden);
            int i = hedenMogenlijkeAntworden.size()+1;
            if (gekozenAntwoorden.size()>0) {
                io.print("[" + i + "] : wis antwoorden\n");
                i++;
            }
            if (gekozenAntwoorden.size()>=min){
                io.print("[" + i + "] : akkoord\n");
            }
            running = listenforKeuze(io,hedenMogenlijkeAntworden, gekozenAntwoorden, min,max);
        }
        int[] antwoordIndexes = new int[gekozenAntwoorden.size()];
        for (int i = 0 ;i<antwoordIndexes.length;i++){
            antwoordIndexes[i]= mogenlijkeAntwoorden.indexOf(gekozenAntwoorden.get(i));
        }
        Antwoord antwoord = new MeerkeuzeAntwoord(vraagNr, antwoordIndexes);
        singleton.getRepo().addAntwoord(antwoord);
    }

    private List<String> printAntwoordKeuzes(InOutputUtil io, List<String> hedenMogenlijkeAntworden){
        int i = 1;
        for (String keuze:hedenMogenlijkeAntworden){
            io.print("["+i+"] : "+keuze+"\n");
            i++;
        }
        return hedenMogenlijkeAntworden;
    }

    private boolean listenforKeuze(InOutputUtil io, List<String> hedenMogenlijkeKeuzes, List<String> alGekozen,
                                   int min, int max){
        String input = io.getNextLine();
        int keuze = 0;
        try {
            keuze = Integer.parseInt(input);
        }catch (NumberFormatException e){
            io.print("geen nummer probeer opniew:\n");
            return true;
        }
        int clearNr = alGekozen.size()>0?hedenMogenlijkeKeuzes.size()+1:-1;
        int accept = (alGekozen.size()>=min?hedenMogenlijkeKeuzes.size()+(clearNr!=-1?2:1):-1);
        if (keuze<=hedenMogenlijkeKeuzes.size()&&keuze>0){
            alGekozen.add(hedenMogenlijkeKeuzes.get(keuze-1));
            if (alGekozen.size()>=max){
                return false;
            }else{
                return true;
            }
        }else if (keuze == clearNr&&clearNr!=-1){
            alGekozen.clear();
            return true;
        }else if (keuze == accept&&accept!=-1){
            return false;
        }else{
            io.print("ongeldige keuze probeer opniew: \n");
            return true;
        }
    }
}
