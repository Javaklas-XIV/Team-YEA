package nl.YEA.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Entity
public class IngevuldeVragenlijst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "lijst", fetch = EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Antwoord> antwoorden = new ArrayList<>();

    public IngevuldeVragenlijst(){};


    public List<Antwoord> getAntwoorden() {
        return antwoorden;
    }

    public int getId() {
        return id;
    }
}
