package integrationtests;


public interface BookRepository {
    Book findById(int id);
    void save(Book book);
}