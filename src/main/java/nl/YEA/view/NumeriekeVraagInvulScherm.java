package nl.YEA.view;

public class NumeriekeVraagInvulScherm extends VraagInvulScherm {

    public NumeriekeVraagInvulScherm(int vraag) {
        super(vraag);
    }

    @Override
    public void show() {
        InOutputUtil.getInstance().printNl("num");
    }
}
