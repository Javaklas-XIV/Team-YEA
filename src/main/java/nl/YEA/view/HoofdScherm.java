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
            inOutputUtil.print("maak je keuze:\n"+
                    "[1]: vragenlijst invullen.\n"+
                    "[2]: overzicht ingevulde forms.\n"+
                    "[x]: programma afsluiten.\n");
            switch (inOutputUtil.getNextLine()){
                case "1":
                    inOutputUtil.getInvulScherm().show();
                    break;
                case "2":
                    inOutputUtil.getOverzichtScherm().show();
                    break;
                case "x":
                    inOutputUtil.printNl("afsluiten");
                    return;
                default:
                    inOutputUtil.printNl("ongeldige input");
            }

        }
    }
}
