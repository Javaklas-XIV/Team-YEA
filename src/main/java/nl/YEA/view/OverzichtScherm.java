package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.model.IngevuldeVragenlijst;

import java.util.List;

public class OverzichtScherm implements Scherm{
    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        boolean running = true;
        while (running){
            io.print("maak u keuzen: \n");
            int i =1;
            List<IngevuldeVragenlijst> ingevuldeVragenlijsten = singleton.getRepo().getNonLoadedIngevuldeVragenlijsten();
            for (IngevuldeVragenlijst ingevuldeVragenlijst:ingevuldeVragenlijsten){
                io.print("["+i+"] ingevulde vragenlijst: "+ingevuldeVragenlijst.getId()+"\n");
                i++;
            }
            io.print("[b] terug.\n");
            running=listenForInput(io, singleton, ingevuldeVragenlijsten);
        }
    }

    private boolean listenForInput(InOutputUtil io, Singleton singleton, List<IngevuldeVragenlijst> ingevuldeVragenlijsten){
        String input = io.getNextLine();
        int keuze;
        try{
            keuze = Integer.parseInt(input);
        }catch (NumberFormatException e){
            if (input.equals("b")){
                return false;
            }
            keuze = -1;
        }
        if (keuze<=ingevuldeVragenlijsten.size()&&keuze>0){
            singleton.getRepo().loadIngevuldeVragenlijst(ingevuldeVragenlijsten.get(keuze-1));
            io.getInzienScherm().show();
            return true;
        }
        else{
            io.print("niet geldige invoer.\n");
            return true;
        }
    }
}
