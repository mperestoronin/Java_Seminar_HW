import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> achievements = Arrays.asList("Crash into D corpus", "First place", "DeadLine", "last place");
        Game hse_drive = new Game("HSE Drive", "a fast pace racing simulator ", achievements, "Racing", "Windows", "unity");

        // Создаем разработчиков, журналистов и игроков
        Journalist journalist1 = new Journalist("Иван Журналов");
        Journalist journalist2 = new Journalist("Алексей Письменный");
        Developer developer1 = new Developer("Nintendo");
        Developer developer2 = new Developer("Sega");
        Player player1 = new Player("Сергей Игрун");
        Player player2 = new Player("Валерий Игроков");

        // Создание экземпляра игровой консоли и добавление игроков, журналистов и разработчиков в качестве наблюдателей
        GameConsole gameConsole = new GameConsole();
        gameConsole.addObserver(journalist1);
        gameConsole.addObserver(journalist2);
        gameConsole.addObserver(developer1);
        gameConsole.addObserver(developer2);
        gameConsole.addObserver(player1);
        gameConsole.addObserver(player2);

        // Выпуск новой игры
        gameConsole.releaseGame(hse_drive);
    }
}