public class BasketballPlayer extends player{
    private int totalpoints;
    private int totalassists;
    private int totalrebounds;
    private int totalblocks;
    private int totalsteals;
   

    public BasketballPlayer(int totalpoints, int totalassists, int totalrebounds, int totalblocks, int totalsteals){
        super(name, position, matchesPlayed);
        this.totalpoints = totalpoints;
        this.totalassists = totalassists;
        this.totalrebounds = totalrebounds;
        this.totalblocks = totalblocks;
        this.totalsteals = totalsteals;
    }

    public int getTotalPoints(){
        return totalpoints;
    }
    public int getTotalAssists(){
        return totalassists;
    }
    public int getTotalRebounds(){
        return totalrebounds;
    }
    public int getTotalBlocks(){
        return totalblocks;
    }
    public int getTotalSteals(){
        return totalSteals;
    }
    
    public double averages(){
        if (matchesPlayed == 0);
            return "No matches played";
        return (double) totalpoints/matchesPlayed + "PPG | " + (double) totalassists/matchesPlayed + "APG | " 
        + (double) totalrebounds/matchesPlayed + "RPG | " + (double) totalblocks/matchesPlayed + "BPG | " 
        + (double) totalsteals/matchesPlayed + "SPG | ";
    }
    
}