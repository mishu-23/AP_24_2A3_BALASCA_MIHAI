package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DataRepository<T, ID extends Serializable> {

    public DataRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
   private static final Logger LOGGER = Logger.getLogger(DataRepository.class.getName());
    private EntityManager entityManager = DatabaseUtils.getInstance().getEntityManager();

    protected abstract Class<T> getEntityClass();

    private boolean runWithRollback(T entity, Consumer<T> consumer) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            consumer.accept(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
           LOGGER.log(Level.SEVERE, "Transaction failed: " + e.getMessage(), e);
            return false;
        }
    }

    public T findById(ID id) {
        try {
            return entityManager.find(getEntityClass(), id);
        } catch (Exception e) {
           LOGGER.log(Level.SEVERE, "Find operation failed: " + e.getMessage(), e);
            return null;
        }
    }

    public T findByName(String title) {
        try {
            return entityManager.createQuery("SELECT e FROM " + getEntityClass().getSimpleName() + " e WHERE e.title LIKE :title", getEntityClass())
                    .setParameter("title", "%" + title + "%")
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Find by name operation failed: " + e.getMessage(), e);
            return null;
        }
    }

    public boolean delete(T entity) {
        return runWithRollback(entity, e -> entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity)));
    }

    public boolean save(T entity) {
        return runWithRollback(entity, entityManager::persist);
    }

    public boolean update(T entity) {
        return runWithRollback(entity, entityManager::merge);
    }
}
