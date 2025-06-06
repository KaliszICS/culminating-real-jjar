public class Player {
    private String name;
    private int goals;
    private int assists;
    private String position;
    private int saves;

    public Player(String name, String goals, String assists, String position, String saves) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.position = position;
        this.saves = saves;
        
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
}
