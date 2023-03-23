import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        Book book1 = new Book("Java Patterns", List.of(new String[]{"Vaskaran Sarcar"}), 2018);
        Book book2 = new Book("Java Patterns", List.of(new String[]{"Vaskaran Sarcar"}), 2019);
        Book book3 = new Book("DE KOONING: AN AMERICAN MASTER", List.of(new String[]{"Mark Stevens", "Annalyn Swan"}), 2019);
        Book book4 = new Book("Good Omens", List.of(new String[]{"Neil Gaiman", "Terry Pratchett"}), 2019);
        lib.put(book1, 1);
        lib.put(book2, 2);
        lib.put(book3, 3);
        lib.put(book4, 2);
        LibraryUI libraryUI = new LibraryUI(lib);
        libraryUI.run();
    }
}
