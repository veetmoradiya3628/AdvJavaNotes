package test.integration;

import integrationtests.Book;
import integrationtests.BookRepository;
import integrationtests.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookIntegrationTest {
    @Test
    void testGetBook_Success(){
        // Mock the repo
        BookRepository mockRepo = Mockito.mock(BookRepository.class);
        // Stub case : book exists
        when(mockRepo.findById(1)).thenReturn(new Book(1, "Mockito Book"));

        BookService service = new BookService(mockRepo);
        Book result = service.getBook(1);

        assertNotNull(result);
        assertEquals("Mockito Book", result.getTitle());
        verify(mockRepo, times(1)).findById(1);
    }

    @Test
    void testGetBook_NotFound(){
        //        Mock Repo
        BookRepository mockRepo = Mockito.mock(BookRepository.class);

        when(mockRepo.findById(2)).thenReturn(null);

        BookService service = new BookService(mockRepo);
        Exception ex = assertThrows(RuntimeException.class, () -> service.getBook(2));
        assertEquals("Book not found", ex.getMessage());
        verify(mockRepo, times(1)).findById(2);
    }

    @Test
    void testGetBook_MultipleCalls(){
        //      Mock repo
        BookRepository mockRepo = Mockito.mock(BookRepository.class);

        when(mockRepo.findById(anyInt())).thenReturn(new Book(1, "First Call")).thenReturn(new Book(2, "Second Call"));

        BookService service = new BookService(mockRepo);

        // First call
        Book first = service.getBook(1);
        assertEquals("First Call", first.getTitle());

        // Second call
        Book second = service.getBook(2);
        assertEquals("Second Call", second.getTitle());

        verify(mockRepo, times(2)).findById(anyInt());
    }

    @Test
    void testGetBook_ExceptionFromRepo() {
        // Mock repo
        BookRepository mockRepo = Mockito.mock(BookRepository.class);

        // Stub: repository throws exception
        when(mockRepo.findById(3)).thenThrow(new IllegalStateException("DB error"));

        BookService service = new BookService(mockRepo);

        Exception ex = assertThrows(IllegalStateException.class, () -> service.getBook(3));
        assertEquals("DB error", ex.getMessage());
        verify(mockRepo).findById(3);
    }
}
