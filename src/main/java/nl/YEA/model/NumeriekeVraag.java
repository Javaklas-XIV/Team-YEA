package nl.YEA.model;

public class NumeriekeVraag extends Vraag {
    private int minimum;
    private int maximum;

    public NumeriekeVraag(String beschrijving, int minimum, int maximum) {
        super(beschrijving);
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
