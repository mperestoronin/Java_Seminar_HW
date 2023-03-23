// Класс разработчика, который реализует интерфейс Observer
class Developer implements Observer {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void update(Game game) {
        System.out.println("Developer " + name + " has received the game " + game.getName() + " with the following technical information:");
        System.out.println("- Platform: " + game.getPlatform());
        System.out.println("- Engine: " + game.getEngine());
    }
}