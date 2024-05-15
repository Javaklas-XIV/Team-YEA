package nl.YEA.model;

public class OpenVraag extends Vraag {
    private int maxAantalTekens;

    public OpenVraag(String beschrijving, int maxAantalTekens) {
        super(beschrijving);
        this.maxAantalTekens = maxAantalTekens;
    }

    public OpenVraag(String beschrijving) {
        this(beschrijving, 256);
    }

    public int getMaxAantalTekens() {
        return maxAantalTekens;
    }

    public void setMaxAantalTekens(int maxAantalTekens) {
        this.maxAantalTekens = maxAantalTekens;
    }

}
