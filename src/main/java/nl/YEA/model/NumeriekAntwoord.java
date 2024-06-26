package nl.YEA.model;

import jakarta.persistence.Entity;

import java.util.Objects;


@Entity
public class NumeriekAntwoord extends Antwoord {
    private int antwoord;

    public NumeriekAntwoord(int vraagID, int nummer){
        super(vraagID);
        this.antwoord = nummer;
    }

    public NumeriekAntwoord() {

    }

    public void setAntwoord(int antwoord) {
        this.antwoord = antwoord;
    }

    public int getAntwoord() {
        return antwoord;
    }
}
