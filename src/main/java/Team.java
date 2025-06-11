import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;
    private String teamName;
/**
 * Constructor for the Team class
 * @param players an arraylist of players
 * @param teamName the name of the team
 */
    public Team(ArrayList<Player> players, String teamName) {
        this.players = players;
        this.teamName = teamName;
    }
/**
 * @return the team name  
 */
    public String getTeamName() {
        return teamName;
    }
/**
 * @return a list of players on the team
 */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
