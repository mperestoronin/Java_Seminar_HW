import java.util.*;

public class Library implements Map<Book, Integer> {

    private Map<Book, Integer> bookMap;

    private final List<Book> takenBooks = new ArrayList<>();

    public String listTakenBooks() {
        StringBuilder res = new StringBuilder();
        for (Book book : takenBooks) {
            res.append(" ").append(book.toString());
        }
        return res.toString();
    }

    public String listAllBooks() {
        StringBuilder res = new StringBuilder();
        for (Book book : bookMap.keySet()) {
            res.append(" ").append(book.toString());
        }
        return res.toString();
    }

    public Library() {
        this.bookMap = new HashMap<>();
    }

    @Override
    public int size() {
        return bookMap.size();
    }

    @Override
    public boolean isEmpty() {
        return bookMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return bookMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return bookMap.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return bookMap.get(key);
    }

    @Override
    public Integer put(Book key, Integer value) {
        return bookMap.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return bookMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends Book, ? extends Integer> m) {
        bookMap.putAll(m);
    }

    @Override
    public void clear() {
        bookMap.clear();
    }

    @Override
    public Set<Book> keySet() {
        return bookMap.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return bookMap.values();
    }

    @Override
    public Set<Entry<Book, Integer>> entrySet() {
        return bookMap.entrySet();
    }

    public Optional<Book> takeBook(String title) {
        for (Book book : keySet()) {
            if (book.getTitle().equals(title)) {
                if (get(book) > 0) {
                    put(book, get(book) - 1);
                    takenBooks.add(book);
                    return Optional.of(book);
                } else {
                    System.out.println("Книга \"" + title + "\" недоступна в данный момент.");
                    return Optional.empty();
                }
            }
        }
        System.out.println("Книга \"" + title + "\" не найдена.");
        return Optional.empty();
    }

    public boolean returnBook(Book book) {
        for (int i = 0; i < takenBooks.size(); i++) {
            if (Objects.equals(takenBooks.get(i).getTitle(), book.getTitle())
                    && Objects.equals(takenBooks.get(i).getAuthors(), book.getAuthors())
                    && Objects.equals(takenBooks.get(i).getYearPublished(), book.getYearPublished())) {
                takenBooks.remove(i);
                put(book, getOrDefault(book, 0) + 1);
                return true;
            }
        }
        return false;
    }

    public boolean containsTitle(String title) {
        for (Book book : keySet()) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

}
