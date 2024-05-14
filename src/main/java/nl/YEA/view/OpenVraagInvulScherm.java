package nl.YEA.view;

public class OpenVraagInvulScherm extends VraagInvulScherm{

    public OpenVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputUtil.getInstance().printNl("open");
    }
}
