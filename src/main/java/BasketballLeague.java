/**
 * @author Justin, Jonathan, Arvin, Raymond
 * @version 17.0.1
 **/
import java.util.ArrayList;

/**
 * A basketball specific league, extending the League class.
 * Handles the creation of schedule, calculation of standings, and team statistics using the rules of basketball.
 */
public class BasketballLeague extends League {
    private Standings standings;

    /**
     * Constructor for the BasketballLeague class.
     * Initializes the league with the name "Basketball" and creates a new Standings object.
     */
    public BasketballLeague() {
        super("Basketball");
        this.standings = new Standings(teams, games);
    }

    /**
     * Calculates the standings for the basketball league.
     */
    @Override
    public void calculateStandings() {
        standings.calculateStandings();
        teamStandings = standings.getStandings();
    }

    /**
     * Generates the schedule for the basketball league.
     * Requires at least two teams to create a schedule.
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
     * Updates and displays statistics for a given team.
     * Calculates wins, losses, points scored, points against, and point differential based on the games played.
     * @param team The team for which to update and display statistics.
     */
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
