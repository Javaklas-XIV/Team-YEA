package nl.YEA.repos;

import com.mysql.cj.log.Slf4JLogger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import nl.YEA.model.Antwoord;
import nl.YEA.model.IngevuldeVragenlijst;
import org.slf4j.LoggerFactory;
import org.slf4j.*;


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

    //Klopt voor nu even niet

    /*public List<Antwoord> retrieve() {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            test = em.createQuery("select e from Antwoord e", Antwoord.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            logger.error(e.getMessage(), e);
        }
        return test;
    }*/
}
