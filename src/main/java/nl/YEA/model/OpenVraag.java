package nl.YEA.model;

public class OpenVraag extends Vraag {
    private int maxAantalTekens;

    public OpenVraag(String beschrijving, int maxAantalLetters) {
        super(beschrijving);
        this.maxAantalTekens = maxAantalLetters;
    }

    public OpenVraag(String beschrijving) {
        this(beschrijving, Integer.MAX_VALUE);
    }

}
