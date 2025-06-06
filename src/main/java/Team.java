import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;
    private String substitutes;
    private String teamName;

    public Team(ArrayList<Player> players, String substitutes, String teamName) {
        this.players = players;
        this.substitutes = substitutes;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getSubtitutes() {
        return substitutes;
    }
}
