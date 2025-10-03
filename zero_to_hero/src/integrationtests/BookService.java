package integrationtests;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book getBook(int id) {
        Book book = repository.findById(id);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        return book;
    }
}
