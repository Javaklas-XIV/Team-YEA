package nl.YEA.controller;

import nl.YEA.model.MeerkeuzeVraag;

import java.util.List;

public class MeerkeuzeVraagController extends VraagController{
    public List<String> getMogelijkeAntwoorden(int vraagId){
        return ((MeerkeuzeVraag)getVraag(vraagId)).getKeuzemogelijkheden();
    }

    public int getMaxKeuzes(int vraagId){
        return ((MeerkeuzeVraag)getVraag(vraagId)).getMaxAantalKeuzes();
    }

    public int getMinKeuzes(int vraagId){
        return ((MeerkeuzeVraag)getVraag(vraagId)).getMinAantalKeuzes();
    }
}
