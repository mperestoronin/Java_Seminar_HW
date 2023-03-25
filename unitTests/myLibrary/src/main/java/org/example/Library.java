package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public List<Book> getBooksPublishedAfterYear(int year) {
        List<Book> booksPublishedAfterYear = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getYearPublished() > year) {
                booksPublishedAfterYear.add(book);
            }
        }
        return booksPublishedAfterYear;
    }
}
