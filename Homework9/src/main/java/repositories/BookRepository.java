package repositories;
import entities.Book;
import jakarta.persistence.EntityManager;

public class BookRepository extends DataRepository<Book, Long> {

    public BookRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }
}


