package nl.YEA.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenVraag extends Vraag {
    private int maxAantalTekens;
    private Map<String, FormulierObject> antwoordNaarVervolgvraag = new HashMap<>();

    public OpenVraag(String beschrijving, int maxAantalTekens) {
        super(beschrijving);
        this.maxAantalTekens = maxAantalTekens;
    }

    @Override
    public List<FormulierObject> getVervolgvraagVoorAntwoord(Antwoord antwoord) {
        List<FormulierObject> result = new ArrayList<>();
        if (getAnyAwnserLink()!=null) {
            result.add(getAnyAwnserLink());
        }
        String antwoordString=((OpenAntwoord)antwoord).getAntwoord();
        if (antwoordNaarVervolgvraag.containsKey(antwoordString)){
            result.add(antwoordNaarVervolgvraag.get(antwoordString));
        }
        return result;
    }

    public OpenVraag(String beschrijving) {
        this(beschrijving, 256);
    }

    @Override
    public List<FormulierObject> getAlleVervolgvragen() {
        List<FormulierObject> result = new ArrayList<>(antwoordNaarVervolgvraag.values());
        if (getAnyAwnserLink()!=null) {
            result.add(getAnyAwnserLink());
        }
        return result;
    }

    public int getMaxAantalTekens() {
        return maxAantalTekens;
    }

    public void setMaxAantalTekens(int maxAantalTekens) {
        this.maxAantalTekens = maxAantalTekens;
    }

    public void addVervolgvraag(String antwoord, FormulierObject vervolg){
        antwoordNaarVervolgvraag.put(antwoord,vervolg);
    }
}
