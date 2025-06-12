/**
 * Abstract class representing a player in a sports league.
 * Contains common attributes and methods that all players share.
 */
public abstract class Player {
    private String name;
    private int number;
    private int age;
    private int height;
    private int weight;
    private int points;
    private int gamesPlayed;

    /**
     * Constructor for the Player class.
     * @param name name of the player
     * @param number jersey number of the player
     * @param age age of the player
     * @param height height of the player in centimeters
     * @param weight weight of the player in kilograms
     */
    public Player(String name, int number, int age, int height, int weight) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.points = 0;
        this.gamesPlayed = 0;
    }

    /**
     * Getter for the player's name.
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the player's jersey number.
     * @return the jersey number of the player
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getter for the player's age.
     * @return the age of the player
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for the player's height.
     * @return the height of the player in centimeters
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for the player's weight.
     * @return the weight of the player in kilograms
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Getter for the player's total points.
     * @return the total points of the player
     */
    public int getPoints() {
        return points;
    }

    /**
     * Getter for the number of games the player has played.
     * @return the number of games played
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * Adds points to the player's total points.
     * @param points points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Sets the player's total points.
     * @param points total points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Increments the number of games played by the player.
     */
    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    /**
     * Abstract method to get sport-specific statistics.
     * @return a string containing the player's statistics
     */
    public abstract String getStats();

    /**
     * Abstract method to update sport-specific statistics after a game.
     * @param stats an array of integers containing the game statistics
     */
    public abstract void updateStats(int[] stats);

}