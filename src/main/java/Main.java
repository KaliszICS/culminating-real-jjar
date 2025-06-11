// main class for the program, run this to start!!!

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		// make a filemanager instance
		FileManager fileManager = new FileManager();
		
		// clear any existing data to avoid duplicates
		fileManager.clearAllData();
		
		// create the leagues
		BasketballLeague nba = new BasketballLeague();
		SoccerLeague premiere = new SoccerLeague();
		VolleyballLeague fivb = new VolleyballLeague();
		
		// save the leagues
		fileManager.saveLeague(nba);
		fileManager.saveLeague(premiere);
		fileManager.saveLeague(fivb);
		
		// making the basketball team and players
		ArrayList<Player> lakersPlayers = new ArrayList<>();
		Team lakers = new Team(lakersPlayers, "Los Angeles Lakers");
		Player raymond = new BasketballPlayer("Raymond Zeng", 23, 38, 206, 113);
		Player jonathan = new BasketballPlayer("Jonathan Zhao", 3, 30, 208, 115);
		lakersPlayers.add(raymond);
		lakersPlayers.add(jonathan);
		
		// making the soccer team and players
		ArrayList<Player> manCityPlayers = new ArrayList<>();
		Team manCity = new Team(manCityPlayers, "Manchester City");
		Player arvin = new SoccerPlayer("Arvin Deng", 9, 23, 194, 88);
		Player justin = new SoccerPlayer("Justin Chu", 17, 32, 181, 70);
		manCityPlayers.add(arvin);
		manCityPlayers.add(justin);
		
		// making the volleyball team and players
		ArrayList<Player> canadaPlayers = new ArrayList<>();
		Team canada = new Team(canadaPlayers, "Canada National Team");
		Player jackie = new VolleyballPlayer("Jackie Weng", 8, 35, 198, 97);
		Player liko = new VolleyballPlayer("Liko Lin", 1, 30, 198, 89);
		canadaPlayers.add(jackie);
		canadaPlayers.add(liko);
		
		// updating the players stats before saving
		int[] basketballStats = {35, 10, 8, 2, 1, 12, 20, 4, 6, 7, 8}; // points, rebounds, assists, steals, blocks, turnovers, fouls, field goals made, field goals attempted, three pointers made, three pointers attempted
		raymond.updateStats(basketballStats);
		
		int[] soccerStats = {2, 1, 0}; // goals, assists, saves
		arvin.updateStats(soccerStats);
		
		int[] volleyballStats = {15, 3, 5, 2, 8, 1, 2, 12, 15}; // kills, blocks, digs, aces, assists, serviceErrors, attackErrors, successfulAttacks, totalAttacks
		jackie.updateStats(volleyballStats);
		
		// saving the teams with updated statistics
		fileManager.saveTeam(lakers, "Basketball");
		fileManager.saveTeam(manCity, "Soccer");
		fileManager.saveTeam(canada, "Volleyball");
		
		// making and playing some games
		ArrayList<Player> celticsPlayers = new ArrayList<>();
		Team celtics = new Team(celticsPlayers, "Boston Celtics");
		Game basketballGame = new Game(lakers, celtics, 120, 115, true);
		
		ArrayList<Player> arsenalPlayers = new ArrayList<>();
		Team arsenal = new Team(arsenalPlayers, "Arsenal");
		Game soccerGame = new Game(manCity, arsenal, 3, 1, true);
		
		// saving the games
		fileManager.saveGame(basketballGame);
		fileManager.saveGame(soccerGame);
		
		// loading and displaying data
		System.out.println("LOADING THEM LEAGUES...");
		ArrayList<String> leagues = fileManager.loadLeagues();
		for (int i = 0; i < leagues.size(); i++) {
			System.out.println(leagues.get(i));
		}
		
		System.out.println("\nLOADING THE TEAMS...");
		ArrayList<Team> teams = fileManager.loadTeams();
		for (int i = 0; i < teams.size(); i++) {
			Team team = teams.get(i);
			System.out.println("\nTeam: " + team.getTeamName());
			ArrayList<Player> players = team.getPlayers();
			for (int j = 0; j < players.size(); j++) {
				Player player = players.get(j);
				System.out.println("Player: " + player.getName());
				System.out.println("Stats: " + player.getStats());
			}
		}
		
		System.out.println("\nLOADING THE GAMES...");
		ArrayList<Game> games = fileManager.loadGames();
		for (int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			System.out.println(game.getTeam1().getTeamName() + " vs " + 
							 game.getTeam2().getTeamName() + ": " +
							 game.getTeam1Score() + " - " + game.getTeam2Score());
		}

		// calculate and display standings for each league
		System.out.println("\nCALCULATING STANDINGS...");
		
		// basketball standings
		ArrayList<String> basketballTeams = new ArrayList<>();
		basketballTeams.add("Los Angeles Lakers");
		basketballTeams.add("Boston Celtics");
		Standings basketballStandings = new Standings(basketballTeams, games);
		basketballStandings.calculateStandings();
		System.out.println("\nBasketball League Standings:");
		System.out.println(basketballStandings.getStandings());
		
		// soccer standings
		ArrayList<String> soccerTeams = new ArrayList<>();
		soccerTeams.add("Manchester City");
		soccerTeams.add("Arsenal");
		Standings soccerStandings = new Standings(soccerTeams, games);
		soccerStandings.calculateStandings();
		System.out.println("\nSoccer League Standings:");
		System.out.println(soccerStandings.getStandings());
	}

}
