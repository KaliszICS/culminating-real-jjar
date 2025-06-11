import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String DATA_DIR = "data";
    private static final String LEAGUE_FILE = "leagues.txt";
    private static final String TEAMS_FILE = "teams.txt";
    private static final String GAMES_FILE = "games.txt";

    public FileManager() {
        //make directory if not dere
        new File(DATA_DIR).mkdirs();
    }

    public void saveLeague(League league) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_DIR + "/" + LEAGUE_FILE, true))) {
            writer.println(league.getSport());
        } 
        
        catch (IOException e) {
            System.err.println("Error saving league: " + e.getMessage());
        }
    }

    public void saveTeam(Team team, String leagueType) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_DIR + "/" + TEAMS_FILE, true))) {
            // save team name and league type
            writer.println(team.getTeamName() + "|" + leagueType);
            // save players with their basic info and statistics
            for (Player player : team.getPlayers()) {
                // save basic player info
                writer.println(player.getName() + "," + 
                             player.getNumber() + "," + 
                             player.getAge() + "," + 
                             player.getHeight() + "," + 
                             player.getWeight());
                
                // save player statistics based on type
                if (player instanceof SoccerPlayer) {
                    SoccerPlayer sp = (SoccerPlayer) player;
                    writer.println("STATS:" + sp.getTotalGoals() + "," + 
                                 sp.getTotalAssists() + "," + 
                                 sp.getTotalSaves() + "," + 
                                 sp.getGamesPlayed());
                } 
                
                else if (player instanceof BasketballPlayer) {
                    BasketballPlayer bp = (BasketballPlayer) player;
                    writer.println("STATS:" + bp.points + "," + 
                                 bp.rebounds + "," + 
                                 bp.assists + "," + 
                                 bp.steals + "," + 
                                 bp.blocks + "," + 
                                 bp.fieldGoals + "," + 
                                 bp.fieldGoalAttempts + "," + 
                                 bp.threePointers + "," + 
                                 bp.threePointAttempts + "," + 
                                 bp.freeThrows + "," + 
                                 bp.freeThrowAttempts + "," + 
                                 bp.getGamesPlayed());
                } 
                
                else if (player instanceof VolleyballPlayer) {
                    VolleyballPlayer vp = (VolleyballPlayer) player;
                    writer.println("STATS:" + vp.points + "," + 
                                 vp.kills + "," + 
                                 vp.blocks + "," + 
                                 vp.digs + "," + 
                                 vp.aces + "," + 
                                 vp.assists + "," + 
                                 vp.serviceErrors + "," + 
                                 vp.attackErrors + "," + 
                                 vp.attackPercentage + "," + 
                                 vp.getGamesPlayed());
                }
            }
            writer.println("---"); // Team separator
        } 
        
        catch (IOException e) {
            System.err.println("Error saving team: " + e.getMessage());
        }
    }

    public void saveGame(Game game) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_DIR + "/" + GAMES_FILE, true))) {
            writer.println(game.getTeam1().getTeamName() + "," + 
                         game.getTeam2().getTeamName() + "," +
                         game.getTeam1Score() + "," +
                         game.getTeam2Score() + "," +
                         game.isGameOver());
        } 
        
        catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }

    public List<String> loadLeagues() {
        List<String> leagues = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_DIR + "/" + LEAGUE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                leagues.add(line);
            }
        } 
        
        catch (IOException e) {
            System.err.println("Error loading leagues: " + e.getMessage());
        }
        return leagues;
    }

    public List<Team> loadTeams() {
        List<Team> teams = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_DIR + "/" + TEAMS_FILE))) {
            String line;
            String teamName = null;
            String leagueType = null;
            ArrayList<Player> players = new ArrayList<>();
            Player currentPlayer = null;
            
            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    if (teamName != null) {
                        teams.add(new Team(players, teamName));
                        players = new ArrayList<>();
                        teamName = null;
                        leagueType = null;
                        currentPlayer = null;
                    }
                } 
                
                else if (teamName == null) {
                    // parse team name and league type
                    String[] teamData = line.split("\\|");
                    if (teamData.length == 2) {
                        teamName = teamData[0];
                        leagueType = teamData[1];
                    }
                } 
                
                else if (line.startsWith("STATS:")) {
                    // load player statistics
                    if (currentPlayer != null) {
                        String statsData = line.substring(6); // remove "STATS:" prefix
                        updatePlayerStatsFromFile(currentPlayer, statsData);
                        players.add(currentPlayer);
                        currentPlayer = null;
                    }
                } 
                
                else {
                    // load basic player info
                    String[] playerData = line.split(",");
                    if (playerData.length == 5) {
                        currentPlayer = createPlayer(leagueType,
                            playerData[0], // name
                            Integer.parseInt(playerData[1]), // number
                            Integer.parseInt(playerData[2]), // age
                            Integer.parseInt(playerData[3]), // height
                            Integer.parseInt(playerData[4])  // weight
                        );
                    }
                }
            }
            // add the last team if exists
            if (teamName != null) {
                teams.add(new Team(players, teamName));
            }
        } 
        
        catch (IOException e) {
            System.err.println("Error loading teams: " + e.getMessage());
        }
        return teams;
    }

    private void updatePlayerStatsFromFile(Player player, String statsData) {
        String[] stats = statsData.split(",");
        
        if (player instanceof SoccerPlayer) {
            if (stats.length >= 4) {
                SoccerPlayer sp = (SoccerPlayer) player;
                sp.goals = Integer.parseInt(stats[0]);
                sp.assists = Integer.parseInt(stats[1]);
                sp.saves = Integer.parseInt(stats[2]);
                // set games played in parent class
                for (int i = 0; i < Integer.parseInt(stats[3]); i++) {
                    sp.incrementGamesPlayed();
                }
            }
        } 
        
        else if (player instanceof BasketballPlayer) {
            if (stats.length >= 12) {
                BasketballPlayer bp = (BasketballPlayer) player;
                bp.points = Integer.parseInt(stats[0]);
                bp.rebounds = Integer.parseInt(stats[1]);
                bp.assists = Integer.parseInt(stats[2]);
                bp.steals = Integer.parseInt(stats[3]);
                bp.blocks = Integer.parseInt(stats[4]);
                bp.fieldGoals = Integer.parseInt(stats[5]);
                bp.fieldGoalAttempts = Integer.parseInt(stats[6]);
                bp.threePointers = Integer.parseInt(stats[7]);
                bp.threePointAttempts = Integer.parseInt(stats[8]);
                bp.freeThrows = Integer.parseInt(stats[9]);
                bp.freeThrowAttempts = Integer.parseInt(stats[10]);
                // set games played in parent class
                for (int i = 0; i < Integer.parseInt(stats[11]); i++) {
                    bp.incrementGamesPlayed();
                }
            }
        } 
        
        else if (player instanceof VolleyballPlayer) {
            if (stats.length >= 10) {
                VolleyballPlayer vp = (VolleyballPlayer) player;
                vp.points = Integer.parseInt(stats[0]);
                vp.kills = Integer.parseInt(stats[1]);
                vp.blocks = Integer.parseInt(stats[2]);
                vp.digs = Integer.parseInt(stats[3]);
                vp.aces = Integer.parseInt(stats[4]);
                vp.assists = Integer.parseInt(stats[5]);
                vp.serviceErrors = Integer.parseInt(stats[6]);
                vp.attackErrors = Integer.parseInt(stats[7]);
                vp.attackPercentage = Double.parseDouble(stats[8]);
                // Set games played in parent class
                for (int i = 0; i < Integer.parseInt(stats[9]); i++) {
                    vp.incrementGamesPlayed();
                }
            }
        }
    }

    private Player createPlayer(String leagueType, String name, int number, int age, int height, int weight) {
        switch (leagueType) {
            case "Basketball":
                return new BasketballPlayer(name, number, age, height, weight);
            case "Volleyball":
                return new VolleyballPlayer(name, number, age, height, weight);
            case "Soccer":
            default:
                return new SoccerPlayer(name, number, age, height, weight);
        }
    }

    public List<Game> loadGames() {
        List<Game> games = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_DIR + "/" + GAMES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] gameData = line.split(",");
                if (gameData.length == 5) {
                    Team team1 = new Team(new ArrayList<>(), gameData[0]);
                    Team team2 = new Team(new ArrayList<>(), gameData[1]);
                    games.add(new Game(
                        team1,
                        team2,
                        Integer.parseInt(gameData[2]),
                        Integer.parseInt(gameData[3]),
                        Boolean.parseBoolean(gameData[4])
                    ));
                }
            }
        } 
        
        catch (IOException e) {
            System.err.println("Error loading games: " + e.getMessage());
        }
        return games;
    }

    public void clearAllData() {
        new File(DATA_DIR + "/" + LEAGUE_FILE).delete();
        new File(DATA_DIR + "/" + TEAMS_FILE).delete();
        new File(DATA_DIR + "/" + GAMES_FILE).delete();
    }
} 