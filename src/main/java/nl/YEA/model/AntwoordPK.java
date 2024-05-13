package nl.YEA.model;

import java.io.Serializable;

public class AntwoordPK implements Serializable {
    private int vraagID;
    private IngevuldeVragenlijst lijst;

    public AntwoordPK() {
    }

    public void setVraagID(int vraagID) {
        this.vraagID = vraagID;
    }

    public int getVraagID() {
        return vraagID;
    }

    public void setLijst(IngevuldeVragenlijst lijst) {
        this.lijst = lijst;
    }

    public IngevuldeVragenlijst getLijst() {
        return lijst;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AntwoordPK that = (AntwoordPK) o;
//        return vraagID == that.vraagID && Objects.equals(lijst, that.lijst);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(vraagID, lijst);
//    }
}

