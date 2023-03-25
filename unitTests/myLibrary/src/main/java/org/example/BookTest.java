package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void testGetTitle() {
        Book book = new Book("Паттерны проектирования Джава", "я (все есть в моем гитхабе)", 2023);
        assertEquals("Паттерны проектирования Джава", book.getTitle());
    }
    @Test
    public void testGetAuthor() {
        Book book = new Book("", "Пересторонин Максим", 2023);
        assertEquals("Пересторонин Максим", book.getAuthor());
    }

    @Test
    public void testGetYearPublished() {
        Book book = new Book("100 способов приготовить лазанью", "Пересторонин Максим", 2023);
        assertEquals(2023, book.getYearPublished());
    }

    @Test
    public void testSetTitle() {
        Book book = new Book("100 способов приготовить лазанью", "Пересторонин Максим", 2023);
        book.setTitle("1 способ приготовить лазанью");
        assertEquals("1 способ приготовить лазанью", book.getTitle());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book("1 способ приготовить лазанью", "Пересторонин Максим", 2023);
        book.setAuthor("Гордон Рамзи");
        assertEquals("Гордон Рамзи", book.getAuthor());
    }

    @Test
    public void testSetYearPublished() {
        Book book = new Book("1 способ приготовить лазанью", "Пересторонин Максим", 2023);
        book.setYearPublished(2077);
        assertEquals(2077, book.getYearPublished());
    }
}