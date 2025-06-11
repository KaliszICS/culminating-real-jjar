public class VolleyballPlayer extends Player {
    protected int points;
    protected int kills;
    protected int blocks;
    protected int digs;
    protected int aces;
    protected int assists;
    protected int serviceErrors;
    protected int attackErrors;
    protected double attackPercentage;

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
        this.attackPercentage = 0.0;
    }

    /**
     * Getter for the player's volleyball specific statistics.
     * @return a string containing the player's volleyball statistics
     */
    @Override
    public String getStats() {
        return "\nVolleyball Statistics for " + getName() + ":\n" +
               "Points: " + points + "\n" +
               "Kills: " + kills + "\n" +
               "Blocks: " + blocks + "\n" +
               "Digs: " + digs + "\n" +
               "Aces: " + aces + "\n" +
               "Assists: " + assists + "\n" +
               "Service Errors: " + serviceErrors + "\n" +
               "Attack Errors: " + attackErrors + "\n" +
               "Attack Percentage: " + String.format("%.1f", attackPercentage) + "%\n" +
               "Games Played: " + getGamesPlayed() + "\n";
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
        kills += stats[0];
        blocks += stats[1];
        digs += stats[2];
        aces += stats[3];
        assists += stats[4];
        serviceErrors += stats[5];
        attackErrors += stats[6];
        int successfulAttacks = stats[7];
        int totalAttacks = stats[8];
        if (totalAttacks > 0) {
            attackPercentage = (double) successfulAttacks / totalAttacks * 100;
        }
        incrementGamesPlayed();
    }
/**
 * @return a string of all the player's per-game statistics as doubles
 */
    public String averages() {
        if (getGamesPlayed() == 0)
            return "No games played";
        return String.format("%.1f Points/Game | %.1f Kills/Game | %.1f Blocks/Game | %.1f Digs/Game | %.1f Aces/Game",
            (double) points/getGamesPlayed(),
            (double) kills/getGamesPlayed(),
            (double) blocks/getGamesPlayed(),
            (double) digs/getGamesPlayed(),
            (double) aces/getGamesPlayed());
    }
} 