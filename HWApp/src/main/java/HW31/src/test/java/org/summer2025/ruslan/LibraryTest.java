package org.summer2025.ruslan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Title One", "Author One", 111);
        book2 = new Book("Title Two", "Author Two", 222);
    }

    @Test
    void testAddValidBook() {
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    void testAddDuplicateBook() {
        library.addBook(book1);
        library.addBook(book1); // попытка добавить повторно
        assertEquals(1, library.getBookCount());
    }

    @Test
    void testAddInvalidBook() {
        Book invalidBook = new Book(null, null, 0);
        library.addBook(invalidBook);
        assertEquals(0, library.getBookCount());
        assertFalse(library.getBooks().contains(invalidBook));
    }

    @Test
    void testRemoveExistingBook() {
        library.addBook(book1);
        boolean removed = library.removeBook(book1);
        assertTrue(removed);
        assertEquals(0, library.getBookCount());
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    void testRemoveNonExistingBook() {
        boolean removed = library.removeBook(book2);
        assertFalse(removed);
        assertEquals(0, library.getBookCount());
    }

    @Test
    void testGetBooksReturnsCorrectList() {
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }
}