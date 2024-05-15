package nl.YEA.model;

import jakarta.persistence.*;

import java.util.Objects;

@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@IdClass(AntwoordPK.class)
public abstract class Antwoord {

    @Id
    protected int vraagID;

    @Id
    @ManyToOne
    protected IngevuldeVragenlijst lijst;

    public Antwoord(int vraagid) {
        this.vraagID = vraagid;
    }
    public void setLijst(IngevuldeVragenlijst lijst) {
        this.lijst = lijst;
    }
    public Antwoord() {
    }
}
