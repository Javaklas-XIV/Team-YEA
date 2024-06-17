package nl.YEA.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumeriekeVraag extends Vraag {
    private Map<Integer, FormulierObject> antwoordNaarVervolgvraag = new HashMap<>();
    private int minimum;
    private int maximum;

    public NumeriekeVraag(String beschrijving, int minimum, int maximum) {
        super(beschrijving);
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    @Override
    public List<FormulierObject> getVervolgvraagVoorAntwoord(Antwoord antwoord) {
        List<FormulierObject> result = new ArrayList<>();
        if (getAnyAwnserLink()!=null) {
            result.add(getAnyAwnserLink());
        }
        int antwoordInt=((NumeriekAntwoord)antwoord).getAntwoord();
        if (antwoordNaarVervolgvraag.containsKey(antwoordInt)){
            result.add(antwoordNaarVervolgvraag.get(antwoordInt));
        }
        return result;
    }

    public void addVervolgvraag(int antwoord, FormulierObject vervolg){
        antwoordNaarVervolgvraag.put(antwoord,vervolg);
    }

    @Override
    public List<FormulierObject> getAlleVervolgvragen() {
        List<FormulierObject> result = new ArrayList<>(antwoordNaarVervolgvraag.values());
        if (getAnyAwnserLink()!=null) {
            result.add(getAnyAwnserLink());
        }
        return result;
    }

}
