package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.exceptions.VraagDoesNotExistException;
import nl.YEA.model.*;

import java.util.List;

public class VraagController {
    public String getVraagBeschrijving(int vraagNr) {
        return getVraag(vraagNr).getBeschrijving();
    }

    public Vraag getVraag(int vraagNr) {
        Vraag result = null;
        for (FormulierObject formObject: Singleton.getInstance().getVragenlijst()){
            result = searchFormulierObject(vraagNr, formObject);
            if (result!=null){
                return result;
            }
        }
        if (result == null){
            throw new VraagDoesNotExistException();
        }else {
            return result;
        }
    }
    private Vraag searchFormulierObject(int vraagNr, FormulierObject object){
        Vraag result = null;
        if (object instanceof Vraag){
            result = searchVraag(vraagNr, (Vraag)object);
            if (result!=null){
                return result;
            }
        }else if (object instanceof FormulierOnderdeel){
            result = searchFormulierOnderdeel(vraagNr, (FormulierOnderdeel) object);
            if (result!=null){
                return result;
            }
        }
        return result;
    }
    private Vraag searchFormulierOnderdeel(int vraagNr, FormulierOnderdeel onderdeel){
        Vraag result = null;
        for (FormulierObject object:onderdeel.getOnderdeelen()){
            result=searchFormulierObject(vraagNr,onderdeel);
            if (result!=null){
                return result;
            }
        }
        return result;
    }
    private Vraag searchVraag(int vraagNr, Vraag vraag){
        if (vraag.getVraagnummer()==vraagNr){
            return vraag;
        }else{
            Vraag result = null;
            for (FormulierObject object:vraag.getAllAntwoordLinks()){
                result = searchFormulierObject(vraagNr,object);
                if (result!=null){
                    return result;
                }
            }
            return result;
        }
    }


    public List<FormulierObject> getVragenLijst(){
        return Singleton.getInstance().getVragenlijst();
    }

    public boolean vraagExists(int vraagNr) {
        try{
            getVraag(vraagNr);
        }catch (VraagDoesNotExistException e){
            return false;
        }
        return true;
    }
}
