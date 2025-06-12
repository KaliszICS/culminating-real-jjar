public class VolleyballPlayer extends Player {
    private int kills;
    private int blocks;
    private int digs;
    private int aces;
    private int assists;
    private int serviceErrors;
    private int attackErrors;
    private double attackPercentage;

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

    // specific getters
    public int getVolleyballPoints() {
        return getPoints();
    }

    public int getKills() {
        return kills;
    }

    public int getVolleyballBlocks() {
        return blocks;
    }

    public int getDigs() {
        return digs;
    }

    public int getAces() {
        return aces;
    }

    public int getVolleyballAssists() {
        return assists;
    }

    public int getServiceErrors() {
        return serviceErrors;
    }

    public int getAttackErrors() {
        return attackErrors;
    }

    public double getAttackPercentage() {
        return attackPercentage;
    }

    // specific setters
    public void setVolleyballPoints(int points) {
        setPoints(points);
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setVolleyballBlocks(int blocks) {
        this.blocks = blocks;
    }

    public void setDigs(int digs) {
        this.digs = digs;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public void setVolleyballAssists(int assists) {
        this.assists = assists;
    }

    public void setServiceErrors(int serviceErrors) {
        this.serviceErrors = serviceErrors;
    }

    public void setAttackErrors(int attackErrors) {
        this.attackErrors = attackErrors;
    }

    public void setAttackPercentage(double attackPercentage) {
        this.attackPercentage = attackPercentage;
    }

    /**
     * Getter for the player's volleyball specific statistics.
     * @return a string containing the player's volleyball statistics
     */
    @Override
    public String getStats() {
        return "\nVolleyball Statistics for " + getName() + ":\n" +
               "Points: " + getPoints() + "\n" +
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
            (double) getPoints()/getGamesPlayed(),
            (double) kills/getGamesPlayed(),
            (double) blocks/getGamesPlayed(),
            (double) digs/getGamesPlayed(),
            (double) aces/getGamesPlayed());
    }
} 