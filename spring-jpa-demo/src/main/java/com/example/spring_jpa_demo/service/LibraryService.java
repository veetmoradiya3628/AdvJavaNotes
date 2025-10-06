package com.example.spring_jpa_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_jpa_demo.entity.Author;
import com.example.spring_jpa_demo.entity.Book;
import com.example.spring_jpa_demo.repository.AuthorRepository;
import com.example.spring_jpa_demo.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class LibraryService {
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	List<Book> getBooksAfterYear(int year) {
		return this.bookRepository.findBooksPublishedAfter(year);
	}

	List<Book> searchBooks(String keyword) {
		return this.bookRepository.searchBooksByTitle(keyword);
	}

	List<Author> getAuthorByName(String name) {
		return this.authorRepository.findByName(name);
	}

	@Transactional
	public Book saveBook(Book book) {
		return this.bookRepository.save(book);
	}

	@Transactional
	public Author saveAuthor(Author author) {
		return this.authorRepository.save(author);
	}

}
