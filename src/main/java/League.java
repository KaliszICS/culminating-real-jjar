import java.util.ArrayList;

/**
 * Abstract class representing a generic sports league.
 * It provides basic functionality for managing teams, games, and standings.
 */
public abstract class League implements SportsLeague {
    protected String sport;
    protected String results;
    protected Schedule schedule;
    protected String teamStandings;
    protected ArrayList<String> teams;
    protected ArrayList<Game> games;

    /**
     * Constructs a new League. 
     * @param sport The type of sport for the league (e.g., "Soccer", "Basketball").
     */
    public League(String sport) {
        this.sport = sport;
        this.teams = new ArrayList<>();
        this.games = new ArrayList<>();
        this.schedule = new Schedule();
    }

    /**
     * Getter for the sport type of the league.
     * @return The sport type of the league.
     */
    @Override
    public String getSport() {
        return sport;
    }

    /**
     * Getter for the teams in the league.
     * @return An ArrayList of team names in the league.
     */
    @Override
    public ArrayList<String> getTeams() {
        return teams;
    }

    /**
     * Getter for the schedule of the league.
     * @return The schedule of the league.
     */
    @Override
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Getter for the standings of the league.
     * @return A string representation of the standings of the league.
     */
    @Override
    public String getStandings() {
        return teamStandings;
    }

    /**
     * Adds a team to the league if it has players.
     * @param team The team to be added to the league.
     */
    @Override
    public void addTeam(Team team) {
        ArrayList<Player> players = team.getPlayers();
        if (players != null && !players.isEmpty()) {
            teams.add(team.getTeamName());
        } else {
            System.out.println("Team must have players to be added to the league.");
        }
    }

    /**
     * Removes a team from the league if it exists.
     * @param team The team to be removed from the league.
     */
    @Override
    public void removeTeam(Team team) {
        if(teams.contains(team.getTeamName())) {
            teams.remove(team.getTeamName());
        } else {
            System.out.println("Team does not exist in the league.");
        }
    }

    /**
     * Records the result of a game and updates team statistics and standings.
     * @param game The game whose result is to be recorded.
     */
    @Override
    public void recordGameResult(Game game) {
        games.add(game);
        updateTeamStats(game.getTeam1());
        updateTeamStats(game.getTeam2());
        calculateStandings();
    }

    //abstract methods to be implemented in specific sport leagues

    /**
     * Calculates the standings of the league based on the results of the games played.
     */
    @Override
    public abstract void calculateStandings();
    
    /**
     * Generates the schedule for the league, including matchups and timings.
     */
    @Override
    public abstract void generateSchedule();
    
    /**
     * Updates the statistics of a team based on the results of the games played.
     * @param team The team whose statistics are to be updated.
     */
    @Override
    public abstract void updateTeamStats(Team team);
}
