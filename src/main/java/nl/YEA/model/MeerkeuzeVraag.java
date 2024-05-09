package nl.YEA.model;

import java.util.List;

public class MeerkeuzeVraag extends Vraag {
    private int maxAantalKeuzes;
    private int minAantalKeuzes;
    private List<String> keuzemogelijkheden;

    public MeerkeuzeVraag(String beschrijving, int maxAantalKeuzes, int minAantalKeuzes, List<String> keuzemogelijkheden) {
        super(beschrijving);
        this.maxAantalKeuzes = maxAantalKeuzes;
        this.minAantalKeuzes = minAantalKeuzes;
        this.keuzemogelijkheden = keuzemogelijkheden;
    }
}
