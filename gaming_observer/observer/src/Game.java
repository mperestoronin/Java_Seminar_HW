import java.util.List;
class Game {
    private final String name;
    private String description;
    private String genre;
    // технические характеристики
    private String platform;
    private String engine;
    private final List<String> achievements;

    public Game(String name, String description, List<String> achievements, String genre, String platform, String engine) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.platform = platform;
        this.engine = engine;
        this.achievements = achievements;
    }

    public String getName() {
        return name;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getPlatform() {
        return platform;
    }

    public String getEngine() {
        return engine;
    }
}