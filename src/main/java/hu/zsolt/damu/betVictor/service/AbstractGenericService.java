package hu.zsolt.damu.betVictor.service;

import hu.zsolt.damu.betVictor.domains.GenericDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by TamasZsolt on 30/06/2015.
 */
public abstract class AbstractGenericService<E extends GenericDomain> {

    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractGenericService.class);

    @Autowired
    protected EntityManager em;

    abstract public E findById(Long id);

    public void persist(final E entity) {
        doInTransaction(new Action() {
            @Override
            public void doIt() {
                if (entity.getId() == null) {
                    em.persist(entity);
                } else {
                    em.merge(entity);
                }
            }
        });
    }

    public void remove(final E entity) {
        doInTransaction(new Action() {
            @Override
            public void doIt() {
                em.remove(entity);
            }
        });
    }

    private void doInTransaction(Action action) {
        synchronized (LOGGER) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                action.doIt();

                em.flush();

                tx.commit();
            } catch (Exception e) {
                tx.setRollbackOnly();
                tx.rollback();

                LOGGER.error("Something really strange", e);
                throw e;
            }
        }
    }

    private static interface Action {
        public void doIt();
    }
}
