import java.util.*;

public class LibraryUI {
    private Library library;
    private Scanner scanner;

    public LibraryUI() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public LibraryUI(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Добро пожаловать в библиотеку!");
        while (true) {
            System.out.println("\nВыберите действие:\n" +
                    "get <имя книги>\n" +
                    "put <книга>\n" +
                    "list\n" +
                    "all\n" +
                    "0 - выйти");
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            if (commands.length > 2) {
                StringBuilder res = new StringBuilder();
                String query = commands[0];
                for (int i = 1; i < commands.length; i++) {
                    if (i == 1) {
                        res.append(commands[i]);
                    } else {
                        res.append(" ").append(commands[i]);
                    }
                }
                commands = new String[]{query, res.toString()};
            }

            switch (commands[0]) {
                case "get":
                    findBook(commands[1]);
                    break;
                case "put":
                    returnBook(commands[1]);
                    break;
                case "list":
                    listTakenBooks();
                    break;
                case "all":
                    listAllBooks();
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        }
    }

    private void listTakenBooks() {
        System.out.println(library.listTakenBooks());
    }

    private void listAllBooks() {
        System.out.println(library.listAllBooks());
    }

    public void findBook(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : library.keySet()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("Книга \"" + title + "\" не найдена.");
            return;
        }

        if (foundBooks.size() == 1) {
            takeBook(foundBooks.get(0));
        } else {
            System.out.println("Найдено несколько книг:");
            for (int i = 0; i < foundBooks.size(); i++) {
                System.out.println((i + 1) + ". " + foundBooks.get(i));
            }
            System.out.println("Введите номер книги, которую хотите взять: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очищаем буфер
            if (choice < 1 || choice > foundBooks.size()) {
                System.out.println("Некорректный выбор.");
                return;
            }
            takeBook(foundBooks.get(choice - 1));
        }
    }

    public void takeBook(Book book) {
        Optional<Book> takenBook = library.takeBook(book.getTitle());
        if (takenBook.isPresent()) {
            System.out.println("Книга \"" + takenBook.get().getTitle() + "\" взята вами.");
        }
    }

    public void returnBook(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : library.keySet()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("Книга \"" + title + "\" не найдена.");
            return;
        }

        if (foundBooks.size() == 1) {
            if (!library.returnBook(foundBooks.get(0))) {
                System.out.println("Вы не брали такую книгу");
            } else {
                System.out.println("Книга успешно возвращена");
            }
        } else {
            System.out.println("Найдено несколько книг:");
            for (int i = 0; i < foundBooks.size(); i++) {
                System.out.println((i + 1) + ". " + foundBooks.get(i));
            }
            System.out.println("Введите номер книги, которую хотите вернуть: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очищаем буфер
            if (choice < 1 || choice > foundBooks.size()) {
                System.out.println("Некорректный выбор.");
                return;
            }
            if (!library.returnBook(foundBooks.get(choice - 1))) {
                System.out.println("Вы не брали такую книгу");
            } else {
                System.out.println("Книга успешно возвращена");
            }
        }
    }
}