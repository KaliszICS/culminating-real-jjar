public class SoccerPlayer extends player{
    private int totalgoals;
    private int totalassists;
    private int totalsaves;

    public SoccerPlayer(int totalgoals, int totalassists, int totalsaves){
        super(name, position, matchesPlayed);
        this.totalgoals = totalgoals;
        this.totalassists = totalassists;
        this.totalsaves = totalsaves;
    }

    public int getTotalGoals(){
        return totalgoals;
    }
    public int getTotalAssists(){
        return totalassists;
    }
    public int getTotalSaves(){
        return totalsaves;
    }
    
    public double averages(){
        if (matchesPlayed == 0);
            return "No matches played";
        return (double) totalgoals/matchesPlayed + "Goals/Game | " + (double) totalassists/matchesPlayed + "Assists/Game | " 
        + (double) totalsaves/matchesPlayed + "Saves/Game | ";
    }
}