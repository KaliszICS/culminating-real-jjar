import java.util.ArrayList;

public class League {
    private String sport;
    private String results;
    private Schedule schedule;
    private String teamStandings;
    private ArrayList<String> teams;

    public League(String sport, String results, Schedule schedule, String teamStandings, ArrayList<String> teams) {
        this.sport = sport;
        this.results = results;
        this.schedule = schedule;
        this.teamStandings = teamStandings;
        this.teams = teams;
    }
    public String getSport() {
        return sport;
    }

    public void calculateStandings() {
        if(teamStandings != null) {
            teamStandings.compareTo(teamStandings);

        }
    }

    public void generateSchedule() {
        
    }

    public void addTeam(Team team) {
        ArrayList<Player> players = team.getPlayers();
        if (players != null && !players.isEmpty()) {
            teams.add(team.getTeamName());
        } else {
            System.out.println("Team must have players to be added to the league.");
        }
    }

    public void removeTeam(Team team) {
        if(teams.contains(team.getTeamName())) {
            teams.remove(team.getTeamName());
            
        } else {
            System.out.println("Team does not exist in the league.");
        }
    }
}
