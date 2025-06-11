public class BasketballPlayer extends Player {
    protected int points;
    protected int rebounds;
    protected int assists;
    protected int steals;
    protected int blocks;
    protected int fieldGoals;
    protected int fieldGoalAttempts;
    protected int threePointers;
    protected int threePointAttempts;
    protected int freeThrows;
    protected int freeThrowAttempts;

    /**
     * Constructor for the BasketballPlayer class.
     * @param name the name of the player
     * @param number the jersey number of the player
     * @param age the age of the player
     * @param height the height of the player in centimeters
     * @param weight the weight of the player in kilograms
     */
    public BasketballPlayer(String name, int number, int age, int height, int weight) {
        super(name, number, age, height, weight);
        this.rebounds = 0;
        this.assists = 0;
        this.steals = 0;
        this.blocks = 0;
        this.fieldGoals = 0;
        this.fieldGoalAttempts = 0;
        this.threePointers = 0;
        this.threePointAttempts = 0;
        this.freeThrows = 0;
        this.freeThrowAttempts = 0;
    }

    /**
     * Getter for the player's basketball specific statistics.
     * @return a string containing the player's basketball statistics
     */
    @Override
    public String getStats() {
        String stats = "\nBasketball Statistics for " + getName() + ":\n" +
                      "Points: " + points + "\n" +
                      "Rebounds: " + rebounds + "\n" +
                      "Assists: " + assists + "\n" +
                      "Steals: " + steals + "\n" +
                      "Blocks: " + blocks + "\n" +
                      "Field Goals: " + fieldGoals + "/" + fieldGoalAttempts + "\n" +
                      "3-Pointers: " + threePointers + "/" + threePointAttempts + "\n" +
                      "Free Throws: " + freeThrows + "/" + freeThrowAttempts + "\n" +
                      "Games Played: " + getGamesPlayed() + "\n";
        return stats;
    }

    /**
     * Updates the player's basketball statistics after a game.
     * @param stats an array of integers containing the game statistics in the following order:
     *             [points, rebounds, assists, steals, blocks, fieldGoalsMade, fieldGoalsAttempted,
     *              threePointersMade, threePointersAttempted, freeThrowsMade, freeThrowsAttempted]
     */
    @Override
    public void updateStats(int[] stats) {
        if (stats.length != 11) {
            System.out.println("Invalid stats array length. Expected 11 values.");
            return;
        }

        addPoints(stats[0]);
        rebounds += stats[1];
        assists += stats[2];
        steals += stats[3];
        blocks += stats[4];
        fieldGoals += stats[5];
        fieldGoalAttempts += stats[6];
        threePointers += stats[7];
        threePointAttempts += stats[8];
        freeThrows += stats[9];
        freeThrowAttempts += stats[10];
        incrementGamesPlayed();
    }

    public String averages() {
        if (getGamesPlayed() == 0)
            return "No games played";
        return String.format("%.1f Points/Game | %.1f Rebounds/Game | %.1f Assists/Game | %.1f Steals/Game | %.1f Blocks/Game",
            (double) points/getGamesPlayed(),
            (double) rebounds/getGamesPlayed(),
            (double) assists/getGamesPlayed(),
            (double) steals/getGamesPlayed(),
            (double) blocks/getGamesPlayed());
    }
}