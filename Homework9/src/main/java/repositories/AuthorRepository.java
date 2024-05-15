package repositories;

import entities.Author;
import jakarta.persistence.EntityManager;

public class AuthorRepository extends DataRepository <Author, Long>{
    public AuthorRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    protected Class<Author> getEntityClass() {
        return Author.class;
    }
}
