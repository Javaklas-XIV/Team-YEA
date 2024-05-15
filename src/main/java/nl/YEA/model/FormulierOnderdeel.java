package nl.YEA.model;

import jakarta.persistence.*;

import java.util.List;

public class FormulierOnderdeel extends FormulierObject{
    private List<FormulierObject> onderdeelen;

    public FormulierOnderdeel(String beschrijving) {
        super(beschrijving);
    }

    public List<FormulierObject> getOnderdeelen() {
        return onderdeelen;
    }
}
