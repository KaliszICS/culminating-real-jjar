import java.util.ArrayList;

public class SoccerBallLeague extends League {
    public SoccerBallLeague() {
        super("SoccerBall");
    }

    @Override
    public void calculateStandings() {
        Standings standings = new Standings(getTeams(), getSchedule().getGames());
        standings.calculateStandings();
        teamStandings = standings.getStandings();
    }

    @Override 
    public void generateSchedule() {
        if (teams.size() < 2) {
            System.out.println("Not enough teams to generate a schedule.");
            return;
        }

        for(int i = 0; i < teams.size(); i++) {
            for(int j = i + 1; j < teams.size(); j++) {
                Team team1 = new Team(new ArrayList<>(), "Bench", teams.get(i));
                Team team2 = new Team(new ArrayList<>(), "Bench", teams.get(j));
                Game game = new Game(team1, team2, 0, 0, false);
                schedule.addGame(game);
            }
        }
    }

    @Override
    public void updateTeamStats(Team team) {
        ArrayList<Game> games = schedule.getGames();
        int wins = 0;
        int losses = 0;
        int draws = 0;
        int goalsScored = 0;
        int goalsAgainst = 0;
        
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if(game.getTeam1().getTeamName().equals(team.getTeamName())) {
                goalsScored += game.getTeam1Score();
                goalsAgainst += game.getTeam2Score();
                if (game.getTeam1Score() > game.getTeam2Score()) {
                    wins++;
                } else if (game.getTeam1Score() < game.getTeam2Score()) {
                    losses++;
                } else {
                    draws++;
                }
            } else if(game.getTeam2().getTeamName().equals(team.getTeamName())) { // Counts up all the stats if the team is listsed as team2 instead of team1
                goalsScored += game.getTeam2Score();
                goalsAgainst += game.getTeam1Score();
                if (game.getTeam2Score() > game.getTeam1Score()) {
                    wins++;
                } else if (game.getTeam2Score() < game.getTeam1Score()) {
                    losses++;
                } else {
                    draws++;
                }
            }
        }
        System.out.println("\nTeam Statistics for " + team.getTeamName() + ":");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Goals Scored: " + goalsScored);
        System.out.println("Goals Against: " + goalsAgainst);
        System.out.println("Score Difference: " + (goalsScored - goalsAgainst));
    }
}
