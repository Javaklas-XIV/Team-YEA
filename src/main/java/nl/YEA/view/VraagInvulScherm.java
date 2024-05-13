package nl.YEA.view;

public abstract class VraagInvulScherm implements Scherm {
    private int vraagNr;
    private int navigationInput = 1;
    public VraagInvulScherm (int vraagNr){
        this.vraagNr = vraagNr;
    }

    public int getNavigationInput() {
        return navigationInput;
    }

    protected void setNavigationInput(int navigationInput) {
        this.navigationInput = navigationInput;
    }
}
