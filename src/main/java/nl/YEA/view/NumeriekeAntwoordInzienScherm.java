package nl.YEA.view;

import nl.YEA.Singleton;

public class NumeriekeAntwoordInzienScherm extends AntwoordInzienScherm{
    public NumeriekeAntwoordInzienScherm(int vraagNr) {
        super(vraagNr);
    }

    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        io.printNl("num");
    }
}
