public class SoccerPlayer extends Player{
    protected int goals;
    protected int assists;
    protected int saves;
    protected int gamesPlayed;

    public SoccerPlayer(String name, int number, int age, int height, int weight){
        super(name, number, age, height, weight);
        this.goals = 0;
        this.assists = 0;
        this.saves = 0;
        this.gamesPlayed = 0;
    }

    public int getTotalGoals(){
        return goals;
    }
    public int getTotalAssists(){
        return assists;
    }
    public int getTotalSaves(){
        return saves;
    }
    
    public String averages(){
        if (gamesPlayed == 0)
            return "No games played";
        return String.format("%.2f Goals/Game | %.2f Assists/Game | %.2f Saves/Game",
            (double) goals/gamesPlayed,
            (double) assists/gamesPlayed,
            (double) saves/gamesPlayed);
    }

    @Override
    public String getStats() {
        return "\nSoccer Statistics for " + getName() + ":\n" +
               "Goals: " + goals + "\n" +
               "Assists: " + assists + "\n" +
               "Saves: " + saves + "\n" +
               "Games Played: " + gamesPlayed + "\n";
    }

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

    public int getGamesPlayed(){
        return gamesPlayed;
    }
}