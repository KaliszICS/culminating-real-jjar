import java.util.ArrayList;
/**
 * Represents a special class for a volleyball league, inheriting from the league class
 * This class can calculate standings, generate schedules, and update team statistics based on game results
 */

public class VolleyballLeague extends League {
    /**
     * Construct a Volleyballeague object with the sport name set to "Volleyball"
     */
    public VolleyballLeague() {
        super("Volleyball");
    }

    /**
     * Calculates the standings for the volleyball league based on game results
     * Uses the Standings class to process the list of games and teams
     */
    @Override
    public void calculateStandings() {
        standings = new Standings(getTeams(), getSchedule().getGames());
        standings.calculateStandings();
        teamStandings = standings.getStandings();
    }
    /**
     * Generates a round-robin schedule where every team plays each other once
     * Only generates a schedule if there are at least 2 teams 
     */
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
    /**
     * Updates and displays team statistics for a specified team
     * Includes wins, losses, setsWon, setsLost and set differential
     */
    @Override
    public void updateTeamStats(Team team) {
        int wins = 0;
        int losses = 0;
        int setsWon = 0;
        int setsLost = 0;

        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.getTeam1().getTeamName().equals(team.getTeamName())) {
                setsWon += game.getTeam1Score();
                setsLost += game.getTeam2Score();
                if (game.getTeam1Score() > game.getTeam2Score()) {
                    wins++;
                } 
                
                else if (game.getTeam1Score() < game.getTeam2Score()) {
                    losses++;
                }
            } 
            
            else if (game.getTeam2().getTeamName().equals(team.getTeamName())) {
                setsWon += game.getTeam2Score();
                setsLost += game.getTeam1Score();
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
        System.out.println("Sets Won: " + setsWon);
        System.out.println("Sets Lost: " + setsLost);
        System.out.println("Set Differential: " + (setsWon - setsLost));
    }
}
