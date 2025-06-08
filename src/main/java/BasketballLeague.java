import java.util.ArrayList;

public class BasketballLeague extends League {
    private static final int POINTS_FOR_WIN = 2;
    private static final int POINTS_FOR_LOSS = 0;

    public BasketballLeague() {
        super("Basketball");
    }

    @Override
    public void calculateStandings() {
        //buble
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = 0; j < teams.size() - i - 1; j++) {
                String team1 = teams.get(j);
                String team2 = teams.get(j + 1);
                int wins1 = getTeamWins(team1);
                int wins2 = getTeamWins(team2);
                
                if (wins1 < wins2 || (wins1 == wins2 && getTeamPointsScored(team1) < getTeamPointsScored(team2))) {
                
                    teams.set(j, team2);
                    teams.set(j + 1, team1);
                }
            }
        }
        
        String standings = "Basketball League standings:\n";
        for (int i = 0; i < teams.size(); i++) {
            String team = teams.get(i);
            standings += team + "- wins: " + getTeamWins(team) +
                    ", points scored: " + getTeamPointsScored(team) + "\n";
        }
        teamStandings = standings;
    }

    @Override
    public void generateSchedule() {
        if (teams.size() < 2) {
            System.out.println("Need at least 2 teams to generate a schedule");
            return;
        }

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Game game = new Game(teams.get(i), teams.get(j));
                schedule.addGame(game);
            }
        }
    }

    @Override
    public void updateTeamStats(Team team) {

    }

    private int getTeamWins(String teamName) {
        int wins = 0;
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.getWinner().equals(teamName)) {
                wins++;
            }
        }
        return wins;
    }

    private int getTeamPointsScored(String teamName) {
        int points = 0;
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.getHomeTeam().equals(teamName)) {
                points += game.getHomeScore();
            } 
            
            else if (game.getAwayTeam().equals(teamName)) {
                points += game.getAwayScore();
            }
        }
        return points;
    }
} 