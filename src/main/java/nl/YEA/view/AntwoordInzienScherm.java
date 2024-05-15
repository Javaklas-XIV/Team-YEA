package nl.YEA.view;

public abstract class AntwoordInzienScherm implements Scherm{
    protected int vraagNr;
    private boolean heeftAntwoord = false;

    public AntwoordInzienScherm(int vraagNr){
        this.vraagNr = vraagNr;
    }
    public void setHeeftAntwoord(boolean heeftAntwoord) {
        this.heeftAntwoord = heeftAntwoord;
    }

    public boolean isHeeftAntwoord() {
        return heeftAntwoord;
    }

    public int getVraagNr(){
        return vraagNr;
    }
}
