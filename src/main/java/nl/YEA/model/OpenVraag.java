package nl.YEA.model;

public class OpenVraag extends Vraag {
    private int maxAantalTekens;

    public OpenVraag(String beschrijving, int maxAantalTekens) {
        super(beschrijving);
        this.maxAantalTekens = maxAantalTekens;
    }

    public OpenVraag(String beschrijving) {
        this(beschrijving, Integer.MAX_VALUE);
    }

}
