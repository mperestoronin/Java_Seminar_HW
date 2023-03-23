import java.util.ArrayList;
import java.util.List;
// Класс игровой консоли, который реализует интерфейс Observable
class GameConsole implements Observable {
    private List<Observer> observers;
    private Game currentGame;

    public GameConsole() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Game game) {
        for (Observer observer : observers) {
            observer.update(game);
        }
    }

    public void releaseGame(Game game) {
        currentGame = game;
        notifyObservers(game);
    }

    public Game getCurrentGame() {
        return currentGame;
    }
}