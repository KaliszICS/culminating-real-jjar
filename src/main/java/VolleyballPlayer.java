public class VolleyballPlayer extends Player {
    private int kills;
    private int blocks;
    private int digs;
    private int aces;
    private int assists;
    private int serviceErrors;
    private int attackErrors;
    private int totalAttacks;

    /**
     * Constructor for the VolleyballPlayer class.
     * @param name the name of the player
     * @param number the jersey number of the player
     * @param age the age of the player
     * @param height the height of the player in centimeters
     * @param weight the weight of the player in kilograms
     */
    public VolleyballPlayer(String name, int number, int age, int height, int weight) {
        super(name, number, age, height, weight);
        this.kills = 0;
        this.blocks = 0;
        this.digs = 0;
        this.aces = 0;
        this.assists = 0;
        this.serviceErrors = 0;
        this.attackErrors = 0;
        this.totalAttacks = 0;
    }

    /**
     * Getter for the player's volleyball specific statistics.
     * @return a string containing the player's volleyball statistics
     */
    @Override
    public String getStats() {
        String stats = "\nVolleyball Statistics for " + getName() + ":\n" +
                      "Points: " + getPoints() + "\n" +
                      "Kills: " + kills + "\n" +
                      "Blocks: " + blocks + "\n" +
                      "Digs: " + digs + "\n" +
                      "Aces: " + aces + "\n" +
                      "Assists: " + assists + "\n" +
                      "Service Errors: " + serviceErrors + "\n" +
                      "Attack Errors: " + attackErrors + "\n" +
                      "Attack Percentage: " + calculateAttackPercentage() + "%\n" +
                      "Games Played: " + getGamesPlayed() + "\n";
        return stats;
    }

    /**
     * Updates the player's volleyball statistics after a game.
     * @param stats an array of integers containing the game statistics in the following order:
     *             [points, kills, blocks, digs, aces, assists, serviceErrors, attackErrors, totalAttacks]
     */
    @Override
    public void updateStats(int[] stats) {
        if (stats.length != 9) {
            System.out.println("Invalid stats array length. Expected 9 values.");
            return;
        }

        addPoints(stats[0]);
        kills += stats[1];
        blocks += stats[2];
        digs += stats[3];
        aces += stats[4];
        assists += stats[5];
        serviceErrors += stats[6];
        attackErrors += stats[7];
        totalAttacks += stats[8];
        incrementGamesPlayed();
    }

    /**
     * Calculates the player's attack percentage.
     * @return the attack percentage as a double
     */
    private double calculateAttackPercentage() {
        if (totalAttacks == 0) {
            return 0.0;
        }
        return ((double) (kills - attackErrors) / totalAttacks) * 100;
    }
} 