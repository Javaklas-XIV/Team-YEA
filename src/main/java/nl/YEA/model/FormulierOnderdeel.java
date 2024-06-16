package nl.YEA.model;

import java.util.ArrayList;
import java.util.List;

public class FormulierOnderdeel extends FormulierObject{
    private List<FormulierObject> onderdelen;

    public FormulierOnderdeel(String beschrijving) {
        super(beschrijving);
        onderdelen = new ArrayList<>();
    }

    public FormulierOnderdeel(String beschrijving, List<FormulierObject> onderdelen) {
        super(beschrijving);
        this.onderdelen = onderdelen;
    }

    public List<FormulierObject> getOnderdelen() {
        return onderdelen;
    }
}
