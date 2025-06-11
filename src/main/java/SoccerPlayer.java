/**
 * soccer player class extends the player class for soccer specific functionality.
 * tracks soccer specific statistics like goals, assists, saves, and calculates averages.
 */
public class SoccerPlayer extends Player{
    protected int goals;
    protected int assists;
    protected int saves;
    protected int gamesPlayed;

    /**
     * constructor for soccer player.
     * creates a new soccer player with the given info and initially sets all stats to 0.
     * 
     * @param name the players name
     * @param number the players jersey number
     * @param age the players age
     * @param height the players height in centimeters
     * @param weight the players weight in kilograms
     */
    public SoccerPlayer(String name, int number, int age, int height, int weight){
        super(name, number, age, height, weight);
        this.goals = 0;
        this.assists = 0;
        this.saves = 0;
        this.gamesPlayed = 0;
    }

    /**
     * getter for the total number of goals scored by the player.
     * 
     * @return total goals scored
     */
    public int getTotalGoals(){
        return goals;
    }
    
    /**
     * getter for the total number of assists by the player.
     * 
     * @return total assists
     */
    public int getTotalAssists(){
        return assists;
    }
    
    /**
     * getter for the total number of saves made by the player.
     * 
     * @return total saves
     */
    public int getTotalSaves(){
        return saves;
    }
    
    /**
     * calculates and returns the players averages per game.
     * returns a formatted string with goals, assists, and saves per game.
     * 
     * @return formatted string with averages or "No games played" if no games played
     */
    public String averages(){
        if (gamesPlayed == 0)
            return "No games played";
        return String.format("%.2f Goals/Game | %.2f Assists/Game | %.2f Saves/Game",
            (double) goals/gamesPlayed,
            (double) assists/gamesPlayed,
            (double) saves/gamesPlayed);
    }

    /**
     * gets formatted stats for the soccer player.
     * returns a string with all the players soccer stats including goals, assists, saves, and games played.
     * 
     * @return formatted string containing all soccer statistics
     */
    @Override
    public String getStats() {
        return "\nSoccer Statistics for " + getName() + ":\n" +
               "Goals: " + goals + "\n" +
               "Assists: " + assists + "\n" +
               "Saves: " + saves + "\n" +
               "Games Played: " + gamesPlayed + "\n";
    }

    /**
     * updates the players stats with new game data.
     * expects an array with 3 values: goals, assists, saves.
     * automatically increments games played.
     * 
     * @param stats array containing goals, assists, saves (in that order)
     */
    @Override
    public void updateStats(int[] stats) {
        if (stats.length != 3) {
            System.out.println("Invalid stats array length. Expected 3 values.");
            return;
        }
        goals += stats[0];
        assists += stats[1];
        saves += stats[2];
        gamesPlayed++;
    }

    /**
     * getter for the number of games the player has played.
     * 
     * @return total games played
     */
    public int getGamesPlayed(){
        return gamesPlayed;
    }
}