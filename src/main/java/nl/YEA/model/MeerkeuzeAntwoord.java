package nl.YEA.model;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MeerkeuzeAntwoord extends Antwoord {

    @Convert(converter = ObjectArrayConverter.class)
    private List<Integer> antwoord = new ArrayList<>();

    public MeerkeuzeAntwoord(int vraagid, int ...meerkeuze) {
        super(vraagid);
        for(int keuze : meerkeuze) {
            this.antwoord.add(keuze);
        }
    }

    public MeerkeuzeAntwoord(){}

    public List<Integer> getAntwoord() {
        return antwoord;
    }
}

