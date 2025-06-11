public class BasketballPlayer extends Player {
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private int fieldGoalsMade;
    private int fieldGoalsAttempted;
    private int threePointersMade;
    private int threePointersAttempted;
    private int freeThrowsMade;
    private int freeThrowsAttempted;

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
        this.fieldGoalsMade = 0;
        this.fieldGoalsAttempted = 0;
        this.threePointersMade = 0;
        this.threePointersAttempted = 0;
        this.freeThrowsMade = 0;
        this.freeThrowsAttempted = 0;
    }

    /**
     * Getter for the player's basketball specific statistics.
     * @return a string containing the player's basketball statistics
     */
    @Override
    public String getStats() {
        String stats = "\nBasketball Statistics for " + getName() + ":\n" +
                      "Points: " + getPoints() + "\n" +
                      "Rebounds: " + rebounds + "\n" +
                      "Assists: " + assists + "\n" +
                      "Steals: " + steals + "\n" +
                      "Blocks: " + blocks + "\n" +
                      "Field Goals: " + fieldGoalsMade + "/" + fieldGoalsAttempted + "\n" +
                      "3-Pointers: " + threePointersMade + "/" + threePointersAttempted + "\n" +
                      "Free Throws: " + freeThrowsMade + "/" + freeThrowsAttempted + "\n" +
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
        fieldGoalsMade += stats[5];
        fieldGoalsAttempted += stats[6];
        threePointersMade += stats[7];
        threePointersAttempted += stats[8];
        freeThrowsMade += stats[9];
        freeThrowsAttempted += stats[10];
        incrementGamesPlayed();
    }
}