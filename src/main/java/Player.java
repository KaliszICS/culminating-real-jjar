/**
 * Player class represents a player in a sports team.
 * It contains information about the player's name, goals, assists, position, saves, matches played,
 */
public class Player {
    private String name;
    private int goals;
    private int assists;
    private String position;
    private int matchesPlayed;

    /**
     * Constructor to initialize a Player object with name, goals, assists, position, and matches played.
     * @param name the name of the player
     * @param goals the number of goals scored by the player
     * @param assists the number of assists made by the player
     * @param position the position of the player in the team
     * @param matchesPlayed the number of matches played by the player
     */
    public Player(String name, int goals, int assists, String position, int matchesPlayed) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.position = position;
        this.matchesPlayed = matchesPlayed;
    }
    
    /**
     * Getter for the player's name.
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
  
    /**
     * Getter for the player's goals.
     * @return the number of goals scored by the player
     */
    public int getGoals() {
        return goals;
    }
  
    /**
     * Getter for the player's assists.
     * @return the number of assists made by the player
     */
    public int getAssists() {
        return assists;
    }
  
    /**
     * Getter for the player's position.
     * @return the position of the player
     */
    public String getPosition() {
        return position;
    }

    /**
     * Getter for the number of matches played by the player.
     * @return the number of matches played by the player
     */
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    /**
     * Updates the player's status with new goals and assists.
     * @param newGoals new goals scored by the player
     * @param newAssists new assists made by the player
     */
    public void updateStatus(int newGoals, int newAssists) {
        this.goals += newGoals;
        this.assists += newAssists;
        this.matchesPlayed++;

        System.out.println("Updated stats for " + name + ":");
        System.out.println("Goals: " + goals + ", Assists: " + assists);
    }

    /**
     * Displays the player's profile including name, position, goals, assists, and matches played.
     */
    public void displayProfile() {
        System.out.println("(---Player Status---)");
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Goals: " + goals);
        System.out.println("Assists: " + assists);
        System.out.println("Matches Played: " + matchesPlayed);
    }

    /**
     * Calculates and displays the player's performance metrics such as goals per match and assists per match.
     */
    public void matchPerformance() {
        if(matchesPlayed > 0) {
            double goalsPerGame = (double) goals / matchesPlayed;
            double assistsPerGame = (double) assists / matchesPlayed;
            System.out.println("Goals per match: " + goalsPerGame);
            System.out.println("Assists per match: " + assistsPerGame);
        }
    }
    
}
