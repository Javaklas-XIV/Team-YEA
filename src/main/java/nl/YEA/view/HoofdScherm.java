package nl.YEA.view;

public class HoofdScherm implements Scherm{
    private InOutputUtil inOutputUtil;

    public HoofdScherm(){}
    private HoofdScherm(InOutputUtil inOutputUtil) {
        this.inOutputUtil = inOutputUtil;
    }

    @Override
    public void show() {
        while (true) {
            inOutputUtil = InOutputUtil.getInstance();
            inOutputUtil.print("Maak een keuze:\n"+
                    "[1]: Vragenlijst invullen.\n"+
                    "[2]: Overzicht ingevulde vragenlijsten.\n"+
                    "[x]: Programma afsluiten.\n");
            switch (inOutputUtil.getNextLine()){
                case "1":
                    inOutputUtil.getInvulScherm().show();
                    inOutputUtil.printNl("");
                    break;
                case "2":
                    inOutputUtil.getOverzichtScherm().show();
                    inOutputUtil.printNl("");
                    break;
                case "x":
                    inOutputUtil.printNl("Afsluiten");
                    return;
                default:
                    inOutputUtil.printNl("Ongeldige input, probeer opnieuw:");
            }

        }
    }
}
