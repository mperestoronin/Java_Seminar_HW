import java.util.List;

public class Book {
    private String title; // Название книги
    private List<String> authors; // Список авторов книги
    private int yearPublished; // Год издания книги

    public Book(String title, List<String> authors, int yearPublished) {
        this.title = title;
        this.authors = authors;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return title + " (" + authors + ", " + yearPublished + ")";
    }
}
