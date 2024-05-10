package nl.YEA.view;

public class HoofdScherm implements Scherm{
    private InOutputController inOutputController;

    public HoofdScherm(){}
    private HoofdScherm(InOutputController inOutputController) {
        this.inOutputController = inOutputController;
    }

    @Override
    public void show() {
        while (true) {
            inOutputController= InOutputController.getInstance();
            inOutputController.print("maak je keuze:\n"+
                    "[1]: vragenlijst invullen.\n"+
                    "[2]: overzicht ingevulde forms.\n"+
                    "[x]: programma afsluiten.\n");
            switch (inOutputController.getNextLine()){
                case "1":
                    inOutputController.getInvulScherm().show();
                    break;
                case "2":
                    inOutputController.getOverzichtScherm().show();
                    break;
                case "x":
                    inOutputController.printNl("afsluiten");
                    return;
                default:
                    inOutputController.printNl("ongeldige input");
            }

        }
    }
}
