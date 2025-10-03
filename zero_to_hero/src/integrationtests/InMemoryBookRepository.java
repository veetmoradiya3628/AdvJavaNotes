package integrationtests;

import java.util.HashMap;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository{
    private final Map<Integer, Book> db = new HashMap<>();

    @Override
    public Book findById(int id) {
        return db.get(id);
    }

    @Override
    public void save(Book book) {
        db.put(book.getId(), book);
    }
}
