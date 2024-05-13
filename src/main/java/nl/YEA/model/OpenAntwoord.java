package nl.YEA.model;

import jakarta.persistence.Entity;

@Entity
public class OpenAntwoord extends Antwoord {
    private String antwoord;

    public OpenAntwoord (IngevuldeVragenlijst IV, int vraagID, String text) {
        super(IV, vraagID);
        this.antwoord = text;
    }

    public OpenAntwoord() {

    }
}
