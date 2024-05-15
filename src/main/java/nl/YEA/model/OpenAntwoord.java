package nl.YEA.model;

import jakarta.persistence.Entity;

@Entity
public class OpenAntwoord extends Antwoord {
    private String antwoord;

    public OpenAntwoord(int vraagID, String text) {
        super(vraagID);
        this.antwoord = text;
    }

    public OpenAntwoord() {

    }

    public String getAntwoord() {
        return antwoord;
    }
}
