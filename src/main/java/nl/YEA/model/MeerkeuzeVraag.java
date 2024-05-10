package nl.YEA.model;

import java.util.List;

public class MeerkeuzeVraag extends Vraag {
    private int maxAantalKeuzes;
    private int minAantalKeuzes;
    private List<String> keuzemogelijkheden;

    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden) {
        super(beschrijving);
        this.maxAantalKeuzes = 1;
        this.minAantalKeuzes = 1;
        this.keuzemogelijkheden = keuzemogelijkheden;
    }

    public MeerkeuzeVraag(String beschrijving, int maxAantalKeuzes, int minAantalKeuzes, List<String> keuzemogelijkheden) {
        this(beschrijving, keuzemogelijkheden);
        this.maxAantalKeuzes = maxAantalKeuzes;
        this.minAantalKeuzes = minAantalKeuzes;
    }
}
