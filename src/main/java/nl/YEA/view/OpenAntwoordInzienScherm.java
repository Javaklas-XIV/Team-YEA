package nl.YEA.view;

import nl.YEA.Singleton;

public class OpenAntwoordInzienScherm extends AntwoordInzienScherm{
    public OpenAntwoordInzienScherm(int vraagNr) {
        super(vraagNr);
    }

    @Override
    public void show() {
        InOutputUtil io = InOutputUtil.getInstance();
        Singleton singleton = Singleton.getInstance();
        io.printNl("open");
    }
}
