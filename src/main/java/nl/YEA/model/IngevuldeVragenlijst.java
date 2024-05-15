package nl.YEA.model;

import jakarta.persistence.*;
import nl.YEA.exceptions.AntwoordenNotLoadedException;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@NamedQueries({
        @NamedQuery(name = "getIngevuldeVragenlijsten", query = "SELECT i FROM IngevuldeVragenlijst i"),
        @NamedQuery(name = "getIngevuldeVragenlijst", query = "SELECT i FROM IngevuldeVragenlijst i join fetch i.antwoorden WHERE i.id =:id")
})
public class IngevuldeVragenlijst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "lijst", fetch = LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Antwoord> antwoorden = new ArrayList<>();

    public IngevuldeVragenlijst(){};


    public List<Antwoord> getAntwoorden() {
        return antwoorden;
    }

    public int getId() {
        return id;
    }

    public boolean containsAntwoord(int vraagNr){
        if (antwoorden == null){
            throw new AntwoordenNotLoadedException();
        }
        for (Antwoord antwoord:antwoorden){
            if (antwoord.getVraagID()==vraagNr){
                return true;
            }
        }
        return false;
    }

    public Antwoord getAntwoord(int vraagNr){
        if (antwoorden == null){
            throw new AntwoordenNotLoadedException();
        }
        for (Antwoord antwoord:antwoorden){
            if (antwoord.getVraagID()==vraagNr){
                return antwoord;
            }
        }
        return null;
    }
}
