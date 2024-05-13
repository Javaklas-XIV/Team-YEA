package nl.YEA.view;

import nl.YEA.model.Vraag;

public abstract class VraagInvulScherm implements Scherm {
    private Vraag vraag;
    private int navigationInput = 1;
    public VraagInvulScherm (Vraag vraag){
        this.vraag = vraag;
    }

    public int getNavigationInput() {
        return navigationInput;
    }

    protected void setNavigationInput(int navigationInput) {
        this.navigationInput = navigationInput;
    }
}
