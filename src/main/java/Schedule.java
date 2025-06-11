import java.util.ArrayList;

/**
 * schedule class manages a collection of games for a sports league.
 * provides functionality to add games and retrieve the list of scheduled games.
 */
public class Schedule {
    private ArrayList<Game> games;
    
    /**
     * constructor for schedule.
     * creates a new empty list of games.
     */
    public Schedule() {
        games = new ArrayList<>();
    }
    
    /**
     * adds a game to the schedule.
     * 
     * @param game the game object to be added to the schedule
     */
    public void addGame(Game game) {
        games.add(game);
    }

    /**
     * gets all games in the schedule.
     * 
     * @return arraylist of game objects containing all scheduled games
     */
    public ArrayList<Game> getGames() {
        return games;
    }
}
