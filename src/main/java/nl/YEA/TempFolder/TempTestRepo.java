package nl.YEA.TempFolder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TempTestRepo {
    private final EntityManager em;

    public TempTestRepo(EntityManager em) {
        this.em = em;
    }

    public void save(TempTest account) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(account);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}