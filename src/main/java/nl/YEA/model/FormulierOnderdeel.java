package nl.YEA.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class FormulierOnderdeel extends FormulierObject{
    private List<FormulierObject> onderdeelen;

    public FormulierOnderdeel(String beschrijving) {
        super(beschrijving);
        onderdeelen = new ArrayList<>();
    }

    public FormulierOnderdeel(String beschrijving, List<FormulierObject> onderdeelen) {
        super(beschrijving);
        this.onderdeelen = onderdeelen;
    }

    public List<FormulierObject> getOnderdeelen() {
        return onderdeelen;
    }
}
