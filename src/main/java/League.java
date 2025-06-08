import java.util.ArrayList;

public abstract class League implements SportsLeague {
    protected String sport;
    protected String results;
    protected Schedule schedule;
    protected String teamStandings;
    protected ArrayList<String> teams;
    protected ArrayList<Game> games;

    public League(String sport) {
        this.sport = sport;
        this.teams = new ArrayList<>();
        this.games = new ArrayList<>();
        this.schedule = new Schedule();
    }

    @Override
    public String getSport() {
        return sport;
    }

    @Override
    public ArrayList<String> getTeams() {
        return teams;
    }

    @Override
    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public String getStandings() {
        return teamStandings;
    }

    @Override
    public void addTeam(Team team) {
        ArrayList<Player> players = team.getPlayers();
        if (players != null && !players.isEmpty()) {
            teams.add(team.getTeamName());
        } else {
            System.out.println("Team must have players to be added to the league.");
        }
    }

    @Override
    public void removeTeam(Team team) {
        if(teams.contains(team.getTeamName())) {
            teams.remove(team.getTeamName());
        } else {
            System.out.println("Team does not exist in the league.");
        }
    }

    @Override
    public void recordGameResult(Game game) {
        games.add(game);
        updateTeamStats(game.getHomeTeam());
        updateTeamStats(game.getAwayTeam());
        calculateStandings();
    }

    //abstract methods to be implemented in specific sport leagues
    @Override
    public abstract void calculateStandings();
    
    @Override
    public abstract void generateSchedule();
    
    @Override
    public abstract void updateTeamStats(Team team);
}
