package nl.YEA.view;

import nl.YEA.controller.VraagController;
import nl.YEA.model.MeerkeuzeVraag;
import nl.YEA.model.NumeriekeVraag;
import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;

import java.util.Scanner;

public class InOutputUtil {
    private Scanner scanner;
    private Scherm hoofdScherm;
    private Scherm invulScherm;
    private Scherm inzienScherm;
    private Scherm overzichtScherm;
    private VraagController vraagController;
    private static InOutputUtil inOutputUtil;

    public InOutputUtil(Scanner scanner, Scherm hoofdScherm, Scherm invulScherm, Scherm inzienScherm,
                        Scherm overzichtScherm, VraagController vraagController) {
        this.scanner = scanner;
        this.hoofdScherm = hoofdScherm;
        this.invulScherm = invulScherm;
        this.inzienScherm = inzienScherm;
        this.overzichtScherm = overzichtScherm;
        this.vraagController = vraagController;
        inOutputUtil = this;
    }


    public static InOutputUtil getInstance(){
        if (inOutputUtil == null){
            inOutputUtil = new InOutputUtil(new Scanner(System.in), new HoofdScherm(), new InvulScherm(),
                    new InzienScherm(), new OverzichtScherm(), new VraagController());
        }
        return inOutputUtil;
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

    public static void setInOutputController(InOutputUtil inOutputUtil) {
        InOutputUtil.inOutputUtil = inOutputUtil;
    }

    public VraagInvulScherm getVraagInvulScherm(int vraagNr){
        VraagInvulScherm invulScherm;
        Vraag vraag = vraagController.getVraag(vraagNr);
        if (vraag instanceof MeerkeuzeVraag){
            invulScherm = new MeerkeuzeVraagInvulScherm(vraagNr);
        }else if (vraag instanceof NumeriekeVraag){
            invulScherm = new  NumeriekeVraagInvulScherm(vraagNr);
        }else if (vraag instanceof OpenVraag){
            invulScherm = new OpenVraagInvulScherm(vraagNr);
        }else{
            throw new RuntimeException("vraag type not handeled by in out Controller");
        }
        return invulScherm;
    }
    public AntwoordInzienScherm getAntwoordInzienScherm(int vraagNr){
        AntwoordInzienScherm inzienScherm;
        Vraag vraag = vraagController.getVraag(vraagNr);
        if (vraag instanceof MeerkeuzeVraag){
            inzienScherm = new MeerkeuzeAntwoordInzienScherm(vraagNr);
        }else if (vraag instanceof NumeriekeVraag){
            inzienScherm = new NumeriekAntwoordInzienScherm(vraagNr);
        }else if (vraag instanceof OpenVraag){
            inzienScherm = new OpenAntwoordInzienScherm(vraagNr);
        }else{
            throw new RuntimeException("vraag type not handeled by in out Controller");
        }
        return inzienScherm;
    }
}
