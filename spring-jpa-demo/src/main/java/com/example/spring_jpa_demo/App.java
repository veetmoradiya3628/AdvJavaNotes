package com.example.spring_jpa_demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.spring_jpa_demo.config.AppConfig;
import com.example.spring_jpa_demo.entity.Author;
import com.example.spring_jpa_demo.entity.Book;
import com.example.spring_jpa_demo.repository.AuthorRepository;
import com.example.spring_jpa_demo.repository.BookRepository;

import java.util.List;

public class App {

    private static AuthorRepository authorRepo;
    private static BookRepository bookRepo;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        authorRepo = context.getBean(AuthorRepository.class);
        bookRepo = context.getBean(BookRepository.class);

        insertAuthorsAndBooks();
        fetchBooksByAuthor("J.K. Rowling");
        fetchAuthorsWithMultipleBooks(2);
        searchBooksByTitle("Harry");
        findAuthorByName("George R.R. Martin");
        updateBookYear(1L, 2025);
        deleteAuthor(2L);

        context.close();
    }

    private static void insertAuthorsAndBooks() {
        Author author1 = new Author("J.K. Rowling", "jk@hogwarts.com");
        Author author2 = new Author("George R.R. Martin", "george@westeros.com");

        Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "HP001", 1997, author1);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "HP002", 1998, author1);
        Book book3 = new Book("A Game of Thrones", "GOT001", 1996, author2);
        Book book4 = new Book("A Clash of Kings", "GOT002", 1998, author2);

        author1.setBooks(List.of(book1, book2));
        author2.setBooks(List.of(book3, book4));

        authorRepo.save(author1);
        authorRepo.save(author2);

        System.out.println("✅ Authors and books inserted successfully!");
    }

    private static void fetchBooksByAuthor(String authorName) {
        Author author = authorRepo.findByNameWithBooks(authorName).stream().findFirst().orElse(null);
        if (author != null) {
            System.out.println("\nBooks by " + authorName + ":");
            author.getBooks().forEach(b ->
                    System.out.println(b.getTitle() + " (" + b.getPublishedYear() + ")"));
        } else {
            System.out.println("\nNo author found with name: " + authorName);
        }
    }

    private static void fetchAuthorsWithMultipleBooks(int minBooks) {
        System.out.println("\nAuthors with more than " + minBooks + " books:");
        List<Author> authors = authorRepo.findAllWithBooks();
        authors.stream()
                .filter(a -> a.getBooks().size() > minBooks)
                .forEach(a -> System.out.println(a.getName() + " -> " + a.getBooks().size() + " books"));
    }

    private static void searchBooksByTitle(String keyword) {
        System.out.println("\nBooks containing '" + keyword + "' in title:");
        List<Book> books = bookRepo.searchBooksByTitle(keyword);
        books.forEach(b -> System.out.println(b.getTitle() + " (" + b.getPublishedYear() + ")"));
    }

    private static void findAuthorByName(String name) {
        System.out.println("\nFinding author by exact name: " + name);
        List<Author> authors = authorRepo.findByName(name);
        authors.forEach(a -> System.out.println(a.getName() + " - " + a.getEmail()));
    }

    private static void updateBookYear(Long bookId, int newYear) {
        Book book = bookRepo.findById(bookId).orElse(null);
        if (book != null) {
            book.setPublishedYear(newYear);
            bookRepo.save(book);

            System.out.println("\nUpdated Book: " + book.getTitle() + " -> " + book.getPublishedYear());

            List<Book> recentBooks = bookRepo.findBooksPublishedAfter(newYear - 1);
            System.out.println("Books published after " + (newYear - 1) + ":");
            recentBooks.forEach(b -> System.out.println(b.getTitle() + " -> " + b.getPublishedYear()));
        }
    }

    private static void deleteAuthor(Long authorId) {
        Author author = authorRepo.findById(authorId).orElse(null);
        if (author != null) {
            authorRepo.delete(author);
            System.out.println("\nDeleted author: " + author.getName());

            List<Book> books = bookRepo.findAll();
            System.out.println("Remaining books after deletion:");
            books.forEach(b -> System.out.println(b.getTitle() + " -> " + b.getAuthor().getName()));
        }
    }
}
