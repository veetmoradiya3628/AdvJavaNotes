package com.example.spring_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring_jpa_demo.entity.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // JPQL query
    @Query("SELECT b FROM Book b WHERE b.publishedYear > :year")
    List<Book> findBooksPublishedAfter(@Param("year") int year);

    // Native query example
    @Query(value = "SELECT * FROM books WHERE title LIKE %:keyword%", nativeQuery = true)
    List<Book> searchBooksByTitle(@Param("keyword") String keyword);
}
