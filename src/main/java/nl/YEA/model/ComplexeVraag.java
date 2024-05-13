package nl.YEA.model;

import java.util.List;
import java.util.Map;

public class ComplexeVraag extends Vraag {
    private int minAantalKeuzes;
    private int maxAantalKeuzes;
    private Map<String, List<Vraag>> keuzemogelijkheden;

    public ComplexeVraag(String beschrijving, Map<String, List<Vraag>> keuzemogelijkheden, int minAantalKeuzes, int maxAantalKeuzes) {
        super(beschrijving);
        this.keuzemogelijkheden = keuzemogelijkheden;
        this.minAantalKeuzes = minAantalKeuzes;
        this.maxAantalKeuzes = maxAantalKeuzes;
    }

    public ComplexeVraag(String beschrijving, Map<String, List<Vraag>> keuzemogelijkheden) {
        this(beschrijving, keuzemogelijkheden, 1, 1);
    }

    public Map<String, List<Vraag>> getKeuzemogelijkheden() {
        return keuzemogelijkheden;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.getBeschrijving());
        for (Map.Entry<String, List<Vraag>> e : keuzemogelijkheden.entrySet()) {
            sb.append("\n o ").append(e.getKey());
        }

        return sb.toString();
    }
}
