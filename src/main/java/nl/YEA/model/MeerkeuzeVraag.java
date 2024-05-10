package nl.YEA.model;

import java.util.List;

public class MeerkeuzeVraag extends Vraag {
    private int minAantalKeuzes;
    private int maxAantalKeuzes;
    private List<String> keuzemogelijkheden;

    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden, int minAantalKeuzes, int maxAantalKeuzes) {
        super(beschrijving);
        this.keuzemogelijkheden = keuzemogelijkheden;
        this.minAantalKeuzes = minAantalKeuzes;
        this.maxAantalKeuzes = maxAantalKeuzes;
    }

    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden) {
        this(beschrijving, keuzemogelijkheden, 1, 1);
    }

}
