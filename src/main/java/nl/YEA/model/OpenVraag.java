package nl.YEA.model;

public class OpenVraag extends Vraag {
    private int maxAantalLetters;

    public OpenVraag(String beschrijving) {
        super(beschrijving);
    }

    public OpenVraag(String beschrijving, int maxAantalLetters) {
        super(beschrijving);
        this.maxAantalLetters = maxAantalLetters;
    }
}
