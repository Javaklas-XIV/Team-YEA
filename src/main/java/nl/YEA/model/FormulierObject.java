package nl.YEA.model;



public abstract class FormulierObject {
    private String beschrijving;
    private boolean optioneel = false;

    public FormulierObject(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    @Override
    public String toString() {
        return beschrijving;
    }


    public boolean isOptioneel() {
        return optioneel;
    }

    public void setOptioneel(boolean optioneel) {
        this.optioneel = optioneel;
    }
}
