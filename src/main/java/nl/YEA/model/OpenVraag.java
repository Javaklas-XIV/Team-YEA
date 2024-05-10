package nl.YEA.model;

public class OpenVraag extends Vraag {
    private int maxAantalLetters;

    public OpenVraag(String beschrijving, int maxAantalLetters) {
        super(beschrijving);
        this.maxAantalLetters = maxAantalLetters;
    }

    public OpenVraag(String beschrijving) {
        this(beschrijving, Integer.MAX_VALUE);
    }

}
