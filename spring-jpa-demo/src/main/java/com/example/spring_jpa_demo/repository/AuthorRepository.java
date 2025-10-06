package com.example.spring_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring_jpa_demo.entity.Author;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(@Param("name") String name); 
    
    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.name = :name")
    List<Author> findByNameWithBooks(@Param("name") String name);

    @Query("SELECT a FROM Author a JOIN FETCH a.books")
    List<Author> findAllWithBooks();

}
