package nl.YEA.model;

import jakarta.persistence.Entity;


@Entity
public class NumeriekAntwoord extends Antwoord {
    private int antwoord;

    public NumeriekAntwoord(IngevuldeVragenlijst IV, int vraagID, int nummer){
        super(IV, vraagID);
        this.antwoord = nummer;
    }

    public NumeriekAntwoord() {

    }

    public void setAntwoord(int antwoord) {
        this.antwoord = antwoord;
    }
}
