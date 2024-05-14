package nl.YEA.model;

import jakarta.persistence.Entity;


@Entity
public class NumeriekAntwoord extends Antwoord {
    private int antwoord;

    public NumeriekAntwoord(int vraagID, int nummer){
        super(vraagID);
        this.antwoord = nummer;
    }

    public NumeriekAntwoord() {

    }
}
