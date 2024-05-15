import entities.Author;
import entities.Book;
import entities.PublishingHouse;
import repositories.AuthorRepository;
import repositories.BookRepository;
import repositories.PublishingHouseRepository;
import java.util.Date;
import repositories.DatabaseUtils;


public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository(DatabaseUtils.getInstance().getEntityManager());
        AuthorRepository authorRepository = new AuthorRepository(DatabaseUtils.getInstance().getEntityManager());
        PublishingHouseRepository publishingHouseRepository = new PublishingHouseRepository(DatabaseUtils.getInstance().getEntityManager());

        PublishingHouse ph = new PublishingHouse();
        ph.setName("casa1");
        publishingHouseRepository.save(ph);

        Author author1 = new Author();
        author1.setName("autor1");
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setName("autor2");
        authorRepository.save(author2);

        Book book1 = new Book();
        book1.setTitle("carte1");
        book1.setLanguage("romana");
        book1.setPublishingHouse(ph);
        book1.addAuthor(author1);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("carte2");
        book2.setLanguage("romana");
        book2.setPublishingHouse(ph);
        book2.addAuthor(author2);
        bookRepository.save(book2);

        Book foundBook1 = bookRepository.findById(book1.getId());
        if (foundBook1 != null) {
            System.out.println("Found book by ID: " + foundBook1.getTitle() + " by " + foundBook1.getPublishingHouse().getName());
        }

        Book foundBook2 = bookRepository.findById(book2.getId());
        if (foundBook2 != null) {
            System.out.println("Found book by ID: " + foundBook2.getTitle() + " by " + foundBook2.getPublishingHouse().getName());
        }

        book1.setTitle("carte1_updated");
        bookRepository.update(book1);
        foundBook1 = bookRepository.findById(book1.getId());
        if (foundBook1 != null) {
            System.out.println("Found book by ID: " + foundBook1.getTitle() + " by " + foundBook1.getPublishingHouse().getName());
        }

        foundBook1 = bookRepository.findByName(book1.getTitle());
        if (foundBook1 != null) {
            System.out.println("Found book by name: " + foundBook1.getTitle() + " by " + foundBook1.getPublishingHouse().getName());
        }

    }
}
