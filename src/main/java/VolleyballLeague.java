import java.util.ArrayList;

public class VolleyballLeague extends League {
    private Standings standings;

    public VolleyballLeague() {
        super("Volleyball");
        this.standings = new Standings(teams, games);
    }

    /**
     * Calculates the standings for the volleyball league.
     */
    @Override
    public void calculateStandings() {
        standings.calculateStandings();
        teamStandings = standings.getStandings();
    }

    @Override
    public void generateSchedule() {
        if (teams.size() < 2) {
            System.out.println("Need at least 2 teams to generate a schedule");
            return;
        }
 
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = new Team(new ArrayList<>(), teams.get(i));
                Team team2 = new Team(new ArrayList<>(), teams.get(j));
                Game game = new Game(team1, team2, 0, 0, false);
                schedule.addGame(game);
            }
        }
    }

    @Override
    public void updateTeamStats(Team team) {
        int wins = 0;
        int losses = 0;
        int pointsScored = 0;
        int pointsAgainst = 0;

        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.getTeam1().getTeamName().equals(team.getTeamName())) {
                pointsScored += game.getTeam1Score();
                pointsAgainst += game.getTeam2Score();
                if (game.getTeam1Score() > game.getTeam2Score()) {
                    wins++;
                } 
                
                else if (game.getTeam1Score() < game.getTeam2Score()) {
                    losses++;
                }
            } 
            
            else if (game.getTeam2().getTeamName().equals(team.getTeamName())) {
                pointsScored += game.getTeam2Score();
                pointsAgainst += game.getTeam1Score();
                if (game.getTeam2Score() > game.getTeam1Score()) {
                    wins++;
                } 
                
                else if (game.getTeam2Score() < game.getTeam1Score()) {
                    losses++;
                }
            }
        }

        System.out.println("\nTeam Statistics for " + team.getTeamName() + ":");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Points Scored: " + pointsScored);
        System.out.println("Points Against: " + pointsAgainst);
        System.out.println("Point Differential: " + (pointsScored - pointsAgainst));
    }
}
