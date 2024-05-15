package nl.YEA.model;

import java.util.List;

public abstract class Vraag extends FormulierObject{
    private int vraagnummer;
    private FormulierObject anyAwnserLink = null;

    public abstract List<FormulierObject> getLinksByAntwoord(Antwoord antwoord);
    public Vraag(String beschrijving) {
        super(beschrijving);
    }

    public FormulierObject getAnyAwnserLink() {
        return anyAwnserLink;
    }

    public void setAnyAwnserLink(FormulierObject anyAwnserLink) {
        this.anyAwnserLink = anyAwnserLink;
    }

    public abstract List<FormulierObject> getAllAntwoordLinks();

    public void setVraagnummer(int vraagnummer) {
        this.vraagnummer = vraagnummer;
    }

    public int getVraagnummer() {
        return vraagnummer;
    }
}
