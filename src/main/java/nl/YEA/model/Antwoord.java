package nl.YEA.model;

import jakarta.persistence.*;

import java.util.Objects;

@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@IdClass(AntwoordPK.class)
public abstract class Antwoord {

    @Id
    private int vraagID;

    @Id
    @ManyToOne
    private IngevuldeVragenlijst lijst;

    public Antwoord(int vraagid) {
        this.vraagID = vraagid;
    }
    public void setLijst(IngevuldeVragenlijst lijst) {
        this.lijst = lijst;
    }
    public Antwoord() {
    }

    public int getVraagID() {
        return vraagID;
    }

}
