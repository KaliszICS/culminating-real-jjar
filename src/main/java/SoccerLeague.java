import java.util.ArrayList;

public class SoccerLeague extends League {
    public SoccerLeague() {
        super("Soccer");
    }

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