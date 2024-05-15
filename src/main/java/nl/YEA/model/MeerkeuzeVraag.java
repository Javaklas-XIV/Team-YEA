package nl.YEA.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeerkeuzeVraag extends Vraag {
    private int minAantalKeuzes;
    private int maxAantalKeuzes;
    private List<String> keuzemogelijkheden;

    private Map<Integer, FormulierObject> antwoordToLinkMap = new HashMap<>();

    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden, int minAantalKeuzes, int maxAantalKeuzes) {
        this(beschrijving, keuzemogelijkheden, minAantalKeuzes, maxAantalKeuzes, new HashMap<>(), null);
    }
    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden, int minAantalKeuzes, int maxAantalKeuzes, FormulierObject any) {
        this(beschrijving, keuzemogelijkheden, 1, maxAantalKeuzes, new HashMap<>(), any);
    }
    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden, int minAantalKeuzes, int maxAantalKeuzes, Map<Integer,FormulierObject> links) {
        this(beschrijving, keuzemogelijkheden, minAantalKeuzes, maxAantalKeuzes, links, null);
    }

    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden, int minAantalKeuzes, int maxAantalKeuzes, Map<Integer,FormulierObject> links, FormulierObject any) {
        super(beschrijving);
        this.keuzemogelijkheden = keuzemogelijkheden;
        this.minAantalKeuzes = minAantalKeuzes;
        this.maxAantalKeuzes = maxAantalKeuzes;
        this.antwoordToLinkMap = links;
        this.setAnyAwnserLink(any);
    }

    public MeerkeuzeVraag(String beschrijving, List<String> keuzemogelijkheden) {
        this(beschrijving, keuzemogelijkheden, 1, 1);
    }

    public List<String> getKeuzemogelijkheden() {
        return keuzemogelijkheden;
    }

    public int getMinAantalKeuzes() {
        return minAantalKeuzes;
    }

    public int getMaxAantalKeuzes() {
        return maxAantalKeuzes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.getBeschrijving());
        for (String k : keuzemogelijkheden) {
            sb.append("\n o ").append(k);
        }
        return sb.toString();
    }

    @Override
    public List<FormulierObject> getLinksByAntwoord(Antwoord antwoord) {
        List<FormulierObject> result = new ArrayList<>();
        if (getAnyAwnserLink()!=null){
            result.add(getAnyAwnserLink());
        }
        for (int i:((MeerkeuzeAntwoord)antwoord).getAntwoord()){
            if (antwoordToLinkMap.containsKey(i)){
                result.add(antwoordToLinkMap.get(i));
            }
        }
        return result;
    }

    public void addAwnserLinks(int awnser, FormulierObject link){
        antwoordToLinkMap.put(awnser,link);
    }
    @Override
    public List<FormulierObject> getAllAntwoordLinks() {
        List<FormulierObject> result = new ArrayList<>(antwoordToLinkMap.values());
        if (getAnyAwnserLink()!=null) {
            result.add(getAnyAwnserLink());
        }
        return result;
    }
}
