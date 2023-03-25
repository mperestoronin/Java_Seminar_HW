package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("100 способов приготовить лазанью", "Пересторонин Максим", 2023);
        library.addBook(book);
        List<Book> books = library.getBooks();
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

    @Test
    public void testGetBooks() {
        Library library = new Library();
        Book book1 = new Book("100 способов приготовить лазанью", "Пересторонин Максим", 2023);
        Book book2 = new Book("Обломов", "Иван Гончаров", 1859);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void testGetBooksByAuthor() {
        Library library = new Library();
        Book book1 = new Book("Тарас Бульба", "Николай Гоголь", 1835);
        Book book2 = new Book("Мертвые души", "Николай Гоголь", 1842);
        Book book3 = new Book("Обломов", "Иван Гончаров", 1859);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        List<Book> books = library.getBooksByAuthor("Николай Гоголь");
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
        assertFalse(books.contains(book3));
    }

    @Test
    public void testGetBooksPublishedAfterYear() {
        Library library = new Library();
        Book book1 = new Book("Обломов", "Иван Гончаров", 1859);
        Book book2 = new Book("Мертвые души", "Николай Гоголь", 1842);
        Book book3 = new Book("Тарас Бульба", "Николай Гоголь", 1835);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        List<Book> books = library.getBooksPublishedAfterYear(1840);
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
        assertFalse(books.contains(book3));
    }
}
