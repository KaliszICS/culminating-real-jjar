import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * FileManager class deals with the file i/o for our epic sports league management system.
 * provides functionality to save and load leagues, teams, players, and games to/from text files.
 * uses a simple text-based file format for data persistence.
 * 
 * The data is stored in a "data" directory with the following files:
 * - leagues.txt: league information
 * - teams.txt: team and player information
 * - games.txt: game results
 */
public class FileManager {
    private static final String DATA_DIR = "data";
    private static final String LEAGUE_FILE = "leagues.txt";
    private static final String TEAMS_FILE = "teams.txt";
    private static final String GAMES_FILE = "games.txt";

    /**
     * constructor for FileManager.
     * creates the data directory if it is not already there..
     */
    public FileManager() {
        new File(DATA_DIR).mkdirs();
    }

    /**
     * saves a league to the leagues file.
     * the league's sport type is appended to the leagues.txt file.
     * 
     * @param league the league object to be saved
     */
    public void saveLeague(League league) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_DIR + "/" + LEAGUE_FILE, true))) {
            writer.println(league.getSport());
        } 
        
        catch (IOException e) {
            System.err.println("Error saving league: " + e.getMessage());
        }
    }

    /**
     * saves a team and its players to the teams file.
     * the team info includes the team name, league type, and all player stats.
     * players are saved with their basic info followed by their stats in their spor.
     * 
     * @param team the team object to be saved
     * @param leagueType the type of league the team belongs to (eg, basketball, soccer, volleyball)
     */
    public void saveTeam(Team team, String leagueType) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_DIR + "/" + TEAMS_FILE, true))) {
            writer.println(team.getTeamName() + "|" + leagueType);
            for (Player player : team.getPlayers()) {
                writer.println(player.getName() + "," + 
                             player.getNumber() + "," + 
                             player.getAge() + "," + 
                             player.getHeight() + "," + 
                             player.getWeight());
                
                if (player instanceof SoccerPlayer) {
                    SoccerPlayer sp = (SoccerPlayer) player;
                    writer.println("STATS:" + sp.getTotalGoals() + "," + 
                                 sp.getTotalAssists() + "," + 
                                 sp.getTotalSaves() + "," + 
                                 sp.getGamesPlayed());
                } 
                
                else if (player instanceof BasketballPlayer) {
                    BasketballPlayer bp = (BasketballPlayer) player;
                    writer.println("STATS:" + bp.getBasketballPoints() + "," + 
                                 bp.getRebounds() + "," + 
                                 bp.getBasketballAssists() + "," + 
                                 bp.getSteals() + "," + 
                                 bp.getBlocks() + "," + 
                                 bp.getFieldGoals() + "," + 
                                 bp.getFieldGoalAttempts() + "," + 
                                 bp.getThreePointers() + "," + 
                                 bp.getThreePointAttempts() + "," + 
                                 bp.getFreeThrows() + "," + 
                                 bp.getFreeThrowAttempts() + "," + 
                                 bp.getGamesPlayed());
                } 
                
                else if (player instanceof VolleyballPlayer) {
                    VolleyballPlayer vp = (VolleyballPlayer) player;
                    writer.println("STATS:" + vp.getVolleyballPoints() + "," + 
                                 vp.getKills() + "," + 
                                 vp.getVolleyballBlocks() + "," + 
                                 vp.getDigs() + "," + 
                                 vp.getAces() + "," + 
                                 vp.getVolleyballAssists() + "," + 
                                 vp.getServiceErrors() + "," + 
                                 vp.getAttackErrors() + "," + 
                                 vp.getAttackPercentage() + "," + 
                                 vp.getGamesPlayed());
                }
            }
            writer.println("---"); // team separator
        } 
        
        catch (IOException e) {
            System.err.println("Error saving team: " + e.getMessage());
        }
    }

    /**
     * saves a game result to the games file.
     * the game info includes both team names, their scores, and if the game is over.
     * 
     * @param game the game object to be saved
     */
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

    /**
     * loads all leagues from the leagues file.
     * reads the leagues.txt file and returns an arraylist containing all saved league sport types.
     * 
     * @return arraylist of string containing all league sport types, or empty list if no leagues found
     */
    public ArrayList<String> loadLeagues() {
        ArrayList<String> leagues = new ArrayList<>();
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

    /**
     * loads all teams and their players from the teams file.
     * reads the teams.txt file and reconstructs team objects with their associated players and stats.
     * players are created based on their league type and their stats are restored from the file.
     * 
     * @return arraylist of team objects with all saved teams with their players and stats
     */
    public ArrayList<Team> loadTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        
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
                    String[] teamData = line.split("\\|");
                    if (teamData.length == 2) {
                        teamName = teamData[0];
                        leagueType = teamData[1];
                    }
                } 
                
                else if (line.startsWith("STATS:")) {
                    if (currentPlayer != null) {
                        String statsData = line.substring(6);
                        updatePlayerStatsFromFile(currentPlayer, statsData);
                        players.add(currentPlayer);
                        currentPlayer = null;
                    }
                } 
                
                else {
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
            
            if (teamName != null) {
                teams.add(new Team(players, teamName));
            }
        } 
        
        catch (IOException e) {
            System.err.println("Error loading teams: " + e.getMessage());
        }
        return teams;
    }

    /**
     * updates a players stats from file data.
     * takes a player object and a comma separated string of stats and updates the players
     * sport specific stats and games played.
     * 
     * @param player the player object to update
     * @param statsData comma separated string containing the players stats
     */
    private void updatePlayerStatsFromFile(Player player, String statsData) {
        String[] stats = statsData.split(",");
        
        if (player instanceof SoccerPlayer) {
            if (stats.length >= 4) {
                SoccerPlayer sp = (SoccerPlayer) player;
                sp.setGoals(Integer.parseInt(stats[0]));
                sp.setSoccerAssists(Integer.parseInt(stats[1]));
                sp.setSaves(Integer.parseInt(stats[2]));
                for (int i = 0; i < Integer.parseInt(stats[3]); i++) {
                    sp.incrementGamesPlayed();
                }
            }
        } 
        
        else if (player instanceof BasketballPlayer) {
            if (stats.length >= 12) {
                BasketballPlayer bp = (BasketballPlayer) player;
                bp.setBasketballPoints(Integer.parseInt(stats[0]));
                bp.setRebounds(Integer.parseInt(stats[1]));
                bp.setBasketballAssists(Integer.parseInt(stats[2]));
                bp.setSteals(Integer.parseInt(stats[3]));
                bp.setBlocks(Integer.parseInt(stats[4]));
                bp.setFieldGoals(Integer.parseInt(stats[5]));
                bp.setFieldGoalAttempts(Integer.parseInt(stats[6]));
                bp.setThreePointers(Integer.parseInt(stats[7]));
                bp.setThreePointAttempts(Integer.parseInt(stats[8]));
                bp.setFreeThrows(Integer.parseInt(stats[9]));
                bp.setFreeThrowAttempts(Integer.parseInt(stats[10]));
                for (int i = 0; i < Integer.parseInt(stats[11]); i++) {
                    bp.incrementGamesPlayed();
                }
            }
        } 
        
        else if (player instanceof VolleyballPlayer) {
            if (stats.length >= 10) {
                VolleyballPlayer vp = (VolleyballPlayer) player;
                vp.setVolleyballPoints(Integer.parseInt(stats[0]));
                vp.setKills(Integer.parseInt(stats[1]));
                vp.setVolleyballBlocks(Integer.parseInt(stats[2]));
                vp.setDigs(Integer.parseInt(stats[3]));
                vp.setAces(Integer.parseInt(stats[4]));
                vp.setVolleyballAssists(Integer.parseInt(stats[5]));
                vp.setServiceErrors(Integer.parseInt(stats[6]));
                vp.setAttackErrors(Integer.parseInt(stats[7]));
                vp.setAttackPercentage(Double.parseDouble(stats[8]));
                for (int i = 0; i < Integer.parseInt(stats[9]); i++) {
                    vp.incrementGamesPlayed();
                }
            }
        }
    }

    /**
     * creates a player object of the appropriate type based on the league type.
     * based on the provided league type string.
     * 
     * @param leagueType the type of league (basketball, volleyball, soccer)
     * @param name the players name
     * @param number the players jersey number
     * @param age the players age
     * @param height the players height in centimeters
     * @param weight the players weight in kilograms
     * @return player object of the appropriate subclass, defaults to soccerplayer if type is unrecognized
     */
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

    /**
     * loads all games from the games file.
     * reads the games.txt file and reconstructs game objects with team names, scores, and completion status.
     * 
     * @return arraylist of game objects containing all saved games
     */
    public ArrayList<Game> loadGames() {
        ArrayList<Game> games = new ArrayList<>();
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

    /**
     * clears all saved data by deleting all data files.
     * removes the leagues.txt, teams.txt, and games.txt files from the data directory.
     */
    public void clearAllData() {
        new File(DATA_DIR + "/" + LEAGUE_FILE).delete();
        new File(DATA_DIR + "/" + TEAMS_FILE).delete();
        new File(DATA_DIR + "/" + GAMES_FILE).delete();
    }
} 