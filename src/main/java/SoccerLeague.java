/**
 * soccer league class extends the league class for soccer specific functionality.
 * handles soccer specific team statistics calculations including wins, losses, goals, and goal differential.
 */
public class SoccerLeague extends League {
    
    /**
     * constructor for soccer league.
     * creates a new soccer league by calling the parent constructor with "Soccer" as the sport type.
     */
    public SoccerLeague() {
        super("Soccer");
    }

    /**
     * updates and displays statistics for a soccer team.
     * calculates wins, losses, goals scored, goals against, and goal differential based on games played.
     * displays the calculated stats to the console.
     * 
     * @param team the team to update and display statistics for
     */
    @Override
    public void updateTeamStats(Team team) {
        int wins = 0;
        int losses = 0;
        int goalsScored = 0;
        int goalsAgainst = 0;

        for (Game game : games) {
            if (game.getTeam1().getTeamName().equals(team.getTeamName())) {
                goalsScored += game.getTeam1Score();
                goalsAgainst += game.getTeam2Score();
                if (game.getTeam1Score() > game.getTeam2Score()) {
                    wins++;
                } 
                
                else if (game.getTeam1Score() < game.getTeam2Score()) {
                    losses++;
                }
            } 
            
            else if (game.getTeam2().getTeamName().equals(team.getTeamName())) {
                goalsScored += game.getTeam2Score();
                goalsAgainst += game.getTeam1Score();
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
        System.out.println("Goals Scored: " + goalsScored);
        System.out.println("Goals Against: " + goalsAgainst);
        System.out.println("Goal Differential: " + (goalsScored - goalsAgainst));
    }
} 