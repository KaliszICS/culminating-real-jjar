/**
 * Player class represents a player in a sports team.
 * It contains information about the player's name, goals, assists, position, saves, matches played,
 */
public class Player {
    private String name;
    private int goals;
    private int assists;
    private String position;
    private int saves;
    private int matchesPlayed;

    /**
     * Constructor to initialize a Player object with name, goals, assists, position, saves, and matches played.
     * @param name the name of the player
     * @param goals the number of goals scored by the player
     * @param assists the number of assists made by the player
     * @param position the position of the player in the team
     * @param saves the number of saves made by the player
     * @param matchesPlayed the number of matches played by the player
     */
    public Player(String name, int goals, int assists, String position, int saves, int matchesPlayed) {
        this.name = name;
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
    public int getMatchesPlayed(){
        return matchesPlayed;
    }

    /**
     * Getter for the team assigned to the player.
     * @return the team assigned to the player
     */
    public String getAssignedTeam() {
        return assignedTeam;
    }

    /**
     * Sets the team for the player.
     * @param team the team to which the player is assigned
     */
    public void setPlayerTeam(String team) {
        this.assignedTeam = team; //sets the team for the player
        System.out.println(name + " has been assigned to team: " + assignedTeam);
    }

    /**
     * Updates the player's status with new goals, assists, and saves.
     * @param newGoals new goals scored by the player
     * @param newAssists new assists made by the player
     * @param newSaves new saves made by the player
     */
    public void updateStatus(int newGoals, int newAssists, int newSaves) {
        this.goals += newGoals; //adds current goals with updated goals from new games
        this.assists += newAssists;
        this.saves += newSaves;

        System.out.println("Updated stats for " + name + ":");
        System.out.println("Goals: " + goals + ", Assists: " + assists + ", Saves: " + saves);
    }

    /**
     * Displays the player's profile including name, position, goals, assists, saves, matches played, and assigned team.
     */
    public void displayProfile() {
        System.out.println("(---Player Status---)");
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Goals: " + goals);
        System.out.println("Assists: " + assists);
        System.out.println("Saves: " + saves);
        System.out.println("Matches Played: " + matchesPlayed);
        System.out.println("Assigned Team: " + assignedTeam);
       
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
