package nl.YEA.view;

import nl.YEA.model.MeerkeuzeVraag;
import nl.YEA.model.NumeriekeVraag;
import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;

import java.util.Scanner;

public class InOutputController {
    private Scanner scanner;
    private Scherm hoofdScherm;
    private Scherm invulScherm;
    private Scherm inzienScherm;
    private Scherm overzichtScherm;
    private static InOutputController inOutputController;

    public InOutputController(Scanner scanner, Scherm hoofdScherm, Scherm invulScherm,  Scherm inzienScherm,
                              Scherm overzichtScherm) {
        this.scanner = scanner;
        this.hoofdScherm = hoofdScherm;
        this.invulScherm = invulScherm;
        this.inzienScherm = inzienScherm;
        this.overzichtScherm = overzichtScherm;
        inOutputController = this;
    }


    public static InOutputController getInstance(){
        if (inOutputController == null){
            inOutputController = new InOutputController(new Scanner(System.in), new HoofdScherm(), new InvulScherm(),
                    new InzienScherm(), new OverzichtScherm());
        }
        return inOutputController;
    }
    public String getNextLine() {
        return scanner.nextLine();
    }

    public void printNl(String output){
        print(output+"\n");
    }
    public void print(String output){
        System.out.print(output);
    }

    public Scherm getHoofdScherm() {
        return hoofdScherm;
    }

    public Scherm getInvulScherm() {
        return invulScherm;
    }

    public Scherm getInzienScherm() {
        return inzienScherm;
    }

    public Scherm getOverzichtScherm() {
        return overzichtScherm;
    }

    public static void setInOutputController(InOutputController inOutputController) {
        InOutputController.inOutputController = inOutputController;
    }

    public VraagInvulScherm getVraagInvulScherm(Vraag vraag){
        VraagInvulScherm invulScherm;
        if (vraag instanceof MeerkeuzeVraag){
            invulScherm = new MeerkeuzeVraagInvulScherm((MeerkeuzeVraag) vraag);
        }else if (vraag instanceof NumeriekeVraag){
            invulScherm = new  NumeriekeVraagInvulScherm((NumeriekeVraag) vraag);
        }else if (vraag instanceof OpenVraag){
            invulScherm = new OpenVraagInvulScherm((OpenVraag) vraag);
        }else{
            throw new RuntimeException("vraag type not handeled by in out Controller");
        }
        return invulScherm;
    }
}
