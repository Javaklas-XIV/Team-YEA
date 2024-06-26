package nl.YEA.repos;

import com.mysql.cj.log.Slf4JLogger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NamedQuery;
import nl.YEA.model.Antwoord;
import nl.YEA.model.IngevuldeVragenlijst;
import org.slf4j.LoggerFactory;
import org.slf4j.*;

import java.util.ArrayList;
import java.util.List;


public class IngevuldeVragenlijstRepo {

    private static Logger logger = LoggerFactory.getLogger(Slf4JLogger.class);
    private IngevuldeVragenlijst ingevuldeVragenlijst = new IngevuldeVragenlijst();
    private EntityManager em;
    public IngevuldeVragenlijstRepo(EntityManager em){
        this.em = em;
    }
    public void addAntwoord( Antwoord antwoord) {
        ingevuldeVragenlijst.getAntwoorden().add(antwoord);
        antwoord.setLijst(ingevuldeVragenlijst);
    }

    public boolean ingevuldeVragenlijstContains(int vraagNr){
        return ingevuldeVragenlijst.containsAntwoord(vraagNr);
    }
    public Antwoord ingevuldeVragenlijstGetAntwoord(int vraagNr){
        return ingevuldeVragenlijst.getAntwoord(vraagNr);
    }

    public void clearIngevuldeVragenLijst(){
        ingevuldeVragenlijst = new IngevuldeVragenlijst();
    }

    public void saveIngevuldeVragenlijst() {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(ingevuldeVragenlijst);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            logger.error(e.getMessage(), e);
        }
    }



    public void save(IngevuldeVragenlijst ingevuldeVragenlijst) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(ingevuldeVragenlijst);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            logger.error(e.getMessage(), e);
        }
    }

    public void loadIngevuldeVragenlijst(IngevuldeVragenlijst ingevuldeVragenlijst){
        IngevuldeVragenlijst result = null;
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            result = em.createNamedQuery("getIngevuldeVragenlijst", IngevuldeVragenlijst.class ).setParameter("id",ingevuldeVragenlijst.getId() ).getSingleResult();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            logger.error(e.getMessage(), e);
        }
        this.ingevuldeVragenlijst = result;
    }

    public List<IngevuldeVragenlijst> getNonLoadedIngevuldeVragenlijsten(){
        List<IngevuldeVragenlijst> result = null;
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            result = em.createNamedQuery("getIngevuldeVragenlijsten", IngevuldeVragenlijst.class ).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
