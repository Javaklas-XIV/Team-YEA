package nl.YEA.view;

public class MeerkeuzeVraagInvulScherm extends VraagInvulScherm{

    public MeerkeuzeVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputUtil.getInstance().printNl("meerkeuze");
    }
}
