import java.util.ArrayList;

public class Schedule {
    private ArrayList<Game> games;
    
    public Schedule() {
        games = new ArrayList<>();
    }
    
    public void addGame(Game game) {
        games.add(game);
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
