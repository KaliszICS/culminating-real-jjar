public class Player {
    private String name;
    private int goals;
    private int assists;
    private String position;
    private int saves;
    private int matchesPlayed;

    public Player(String name, int goals, int assists, String position, int saves, int matchesPlayed) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.position = position;
        this.saves = saves;
        this.matchesPlayed = matchesPlayed;
        
    }

    public String getName() {
        return name;
    }
    public int getGoals() {
        return goals;
    }
    public int getAssists() {
        return goals;
    }
    public String getPosition() {
        return position;
    }
    public int getSaves() {
        return saves;
    }
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
}
