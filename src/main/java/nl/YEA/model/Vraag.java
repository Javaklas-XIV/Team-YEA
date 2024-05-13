package nl.YEA.model;

public abstract class Vraag {
    private int vraagnummer;
    private String beschrijving;
    private boolean optioneel;

    public Vraag(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    @Override
    public String toString() {
        return beschrijving;
    }
}
