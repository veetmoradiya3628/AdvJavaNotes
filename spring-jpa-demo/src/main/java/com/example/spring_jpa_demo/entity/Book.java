package com.example.spring_jpa_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Book.findByPublishedYear",
        query = "SELECT * FROM books WHERE published_year = :year",
        resultClass = Book.class
    )
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;

    @Column(name = "published_year")
    private int publishedYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Constructors
    public Book() {}
    public Book(String title, String isbn, int publishedYear, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.author = author;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
