import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;
    private String teamName;

    public Team(ArrayList<Player> players, String teamName) {
        this.players = players;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
