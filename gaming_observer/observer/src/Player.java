class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void update(Game game) {
        System.out.println("Player " + name + " has received the game " + game.getName() + " with achievements:");
        for (String achievement : game.getAchievements()) {
            System.out.println("- " + achievement);
        }
    }
}