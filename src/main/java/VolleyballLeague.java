import java.util.ArrayList;


public class VolleyballLeague extends League {
 
    private Standings standings;

    public VolleyballLeague() {
        super("Volleyball");
        this.standings = new Standings(teams, games);
    }

    @Override
    public void addTeam(Team team) {
        if (team.getPlayers().size() >= 6) { // 6 players required for a volleyball team
            super.addTeam(team);
            
        } else {
            System.out.println("A volleyball team must have at least 6 players.");
        }
    }

    @Override
    public void calculateStandings() {
        standings.calculateStandings();
        teamStandings = standings.getStandings();
    }

    @Override
    public void generateSchedule() {
        if(teams.size() < 2 ) {
            System.out.println("Not enough teams to generate a schedule. At least 2 teams are required.");
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
        int wins = 0;
        int losses = 0;
        int pointsScored = 0;
        int pointsAgaintst = 0;

        for(int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if(game.getTeam1().getTeamName().equals(team.getTeamName())) {
                pointsScored += game.getTeam1Score();
                pointsAgaintst += game.getTeam2Score();
                if(game.getTeam1Score() > game.getTeam2Score()) {
                    wins++;
                } else if (game.getTeam1Score() < game.getTeam2Score()) {
                    losses++;
                }
                 
            }
        }
        System.out.println("\n Team Stats: " + team.getTeamName());
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Points Scored: " + pointsScored);
        System.out.println("Points Against: " + pointsAgaintst);
        System.out.println("Point Differential: " + (pointsScored - pointsAgaintst));
    }


}
