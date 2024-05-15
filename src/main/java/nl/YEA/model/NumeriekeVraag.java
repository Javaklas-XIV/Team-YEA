package nl.YEA.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumeriekeVraag extends Vraag {
    private Map<Integer, FormulierObject> awnserToLinkMap = new HashMap<>();
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
    public List<FormulierObject> getLinksByAntwoord(Antwoord antwoord) {
        List<FormulierObject> result = new ArrayList<>();
        if (getAnyAwnserLink()!=null) {
            result.add(getAnyAwnserLink());
        }
        int antwoordInt=((NumeriekAntwoord)antwoord).getAntwoord();
        if (awnserToLinkMap.containsKey(antwoordInt)){
            result.add(awnserToLinkMap.get(antwoordInt));
        }
        return result;
    }

    public void addAwnserLinks(int awnser, FormulierObject link){
        awnserToLinkMap.put(awnser,link);
    }
    @Override
    public List<FormulierObject> getAllAntwoordLinks() {
        List<FormulierObject> result = new ArrayList<>(awnserToLinkMap.values());
        if (getAnyAwnserLink()!=null) {
            result.add(getAnyAwnserLink());
        }
        return result;
    }

}
