// Класс журналиста, который реализует интерфейс Observer
class Journalist implements Observer {
    private String name;

    public Journalist(String name) {
        this.name = name;
    }
    @Override
    public void update(Game game) {
        System.out.println("Journalist " + name + " has received the game " + game.getName() + " with the following information:");
        System.out.println("- Genre: " + game.getGenre());
        System.out.println("- Description: " + game.getDescription());
    }
}