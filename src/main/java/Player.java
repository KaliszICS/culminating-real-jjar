public class Player {
    private String name;
    private int goals;
    private int assists;
    private String position;
    private int saves;
    private int matchesPlayed;

    public Player(String name, int goals, int assists, String position, int saves, int matchesPlayed) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.position = position;
        this.saves = saves;
        this.matchesPlayed = matchesPlayed;
        
    }

    public String getName() {
        return name;
    }
    public int getGoals() {
        return goals;
    }
    public int getAssists() {
        return assists;
    }
    public String getPosition() {
        return position;
    }
    public int getSaves() {
        return saves;
    }
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void updateStatus(int newGoals, int newAssists, int newSaves) {
        this.goals += newGoals; //adds current goals with updated goals from new games
        this.assists += newAssists;
        this.saves += newSaves;

        System.out.println("Updated stats for " + name + ":");
        System.out.println("Goals: " + goals + ", Assists: " + assists + ", Saves: " + saves);
    }

    public void displayProfile() {
        System.out.println("(---Player Status---)");
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Goals: " + goals);
        System.out.println("Assists: " + assists);
        System.out.println("Saves: " + saves);
        System.out.println("Matches Played: " + matchesPlayed);
       
    }

    public void matchPerformance() {
        if(matchesPlayed > 0) {
            double goalsPerGame = (double) goals / matchesPlayed;
            double assistsPerGame = (double) assists / matchesPlayed;
            System.out.println("Goals per match: " + goalsPerGame);
            System.out.println("Assists per match: " + assistsPerGame);
        }
    }
}
