import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;
    private String teamName;
/**
 * Construct a team with an arraylist of players and a team name
 */
    public Team(ArrayList<Player> players, String teamName) {
        this.players = players;
        this.teamName = teamName;
    }
/**
 * @return
 * returns the team name or the list of players on the team
 */
    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
