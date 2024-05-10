package nl.YEA.view;

import java.util.Scanner;

public class InOutputController {
    private Scanner scanner;
    private Scherm hoofdScherm;
    private Scherm invulScherm;
    private Scherm inzienScherm;
    private Scherm overzichtScherm;
    private static InOutputController inOutputController;

    private InOutputController(Scanner scanner, Scherm hoofdScherm, Scherm invulScherm, Scherm inzienScherm,
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
}
