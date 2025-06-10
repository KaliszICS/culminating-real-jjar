import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		// Create a basketball league
		BasketballLeague nba = new BasketballLeague();
		
		// Create player lists for each team with realistic stats
		// Eastern Conference
		ArrayList<Player> celticsPlayers = new ArrayList<>();
		celticsPlayers.add(new Player("Jayson Tatum", 30, 8, "Small Forward", 0, 72));
		celticsPlayers.add(new Player("Jaylen Brown", 26, 6, "Shooting Guard", 0, 70));
		celticsPlayers.add(new Player("Kristaps Porzingis", 20, 3, "Center", 0, 65));
		celticsPlayers.add(new Player("Derrick White", 15, 5, "Point Guard", 0, 68));
		celticsPlayers.add(new Player("Jrue Holiday", 12, 7, "Point Guard", 0, 67));

		ArrayList<Player> bucksPlayers = new ArrayList<>();
		bucksPlayers.add(new Player("Giannis Antetokounmpo", 31, 6, "Power Forward", 0, 73));
		bucksPlayers.add(new Player("Damian Lillard", 24, 7, "Point Guard", 0, 71));
		bucksPlayers.add(new Player("Khris Middleton", 15, 5, "Small Forward", 0, 62));
		bucksPlayers.add(new Player("Brook Lopez", 12, 2, "Center", 0, 78));
		bucksPlayers.add(new Player("Bobby Portis", 14, 2, "Power Forward", 0, 70));

		// Western Conference
		ArrayList<Player> lakersPlayers = new ArrayList<>();
		lakersPlayers.add(new Player("LeBron James", 25, 7, "Small Forward", 0, 71));
		lakersPlayers.add(new Player("Anthony Davis", 24, 3, "Power Forward", 0, 76));
		lakersPlayers.add(new Player("Austin Reaves", 16, 5, "Shooting Guard", 0, 68));
		lakersPlayers.add(new Player("D'Angelo Russell", 18, 6, "Point Guard", 0, 67));
		lakersPlayers.add(new Player("Rui Hachimura", 12, 2, "Power Forward", 0, 65));

		ArrayList<Player> warriorsPlayers = new ArrayList<>();
		warriorsPlayers.add(new Player("Stephen Curry", 29, 6, "Point Guard", 0, 74));
		warriorsPlayers.add(new Player("Klay Thompson", 18, 2, "Shooting Guard", 0, 69));
		warriorsPlayers.add(new Player("Draymond Green", 9, 7, "Power Forward", 0, 70));
		warriorsPlayers.add(new Player("Andrew Wiggins", 13, 2, "Small Forward", 0, 71));
		warriorsPlayers.add(new Player("Kevon Looney", 5, 3, "Center", 0, 81));

		// Create teams with players
		Team celtics = new Team(celticsPlayers, "Celtics Bench", "Boston Celtics");
		Team bucks = new Team(bucksPlayers, "Bucks Bench", "Milwaukee Bucks");
		Team lakers = new Team(lakersPlayers, "Lakers Bench", "Los Angeles Lakers");
		Team warriors = new Team(warriorsPlayers, "Warriors Bench", "Golden State Warriors");
		
		// Add teams to the league
		System.out.println("\n=== Adding Teams to NBA ===");
		nba.addTeam(celtics);
		nba.addTeam(bucks);
		nba.addTeam(lakers);
		nba.addTeam(warriors);
		
		// Generate the schedule
		System.out.println("\n=== Generating NBA Schedule ===");
		nba.generateSchedule();
		
		// Simulate regular season games
		System.out.println("\n=== Regular Season Games ===");
		
		// Celtics vs Bucks
		Game game1 = new Game(celtics, bucks, 118, 112, true);
		nba.recordGameResult(game1);
		nba.updateTeamStats(celtics);
		nba.updateTeamStats(bucks);
		
		// Lakers vs Warriors
		Game game2 = new Game(lakers, warriors, 121, 115, true);
		nba.recordGameResult(game2);
		nba.updateTeamStats(lakers);
		nba.updateTeamStats(warriors);
		
		// Celtics vs Lakers
		Game game3 = new Game(celtics, lakers, 125, 120, true);
		nba.recordGameResult(game3);
		nba.updateTeamStats(celtics);
		nba.updateTeamStats(lakers);
		
		// Bucks vs Warriors
		Game game4 = new Game(bucks, warriors, 110, 108, true);
		nba.recordGameResult(game4);
		nba.updateTeamStats(bucks);
		nba.updateTeamStats(warriors);
		
		// Warriors vs Celtics
		Game game5 = new Game(warriors, celtics, 116, 122, true);
		nba.recordGameResult(game5);
		nba.updateTeamStats(warriors);
		nba.updateTeamStats(celtics);
		
		// Lakers vs Bucks
		Game game6 = new Game(lakers, bucks, 105, 115, true);
		nba.recordGameResult(game6);
		nba.updateTeamStats(lakers);
		nba.updateTeamStats(bucks);
		
		// Calculate and display final standings
		System.out.println("\n=== Final NBA Standings ===");
		nba.calculateStandings();
		System.out.println(nba.getStandings());
		
		// Display individual player statistics
		System.out.println("\n=== Player Statistics ===");
		for (Player player : celticsPlayers) {
			player.displayProfile();
			player.matchPerformance();
		}
	}

}
