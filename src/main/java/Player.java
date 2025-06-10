public class Player {
    private String name;
    private int goals;
    private int assists;
    private String position;
    private int saves;
    private int matchesPlayed;

    public Player(String name, int goals, int assists, String position, int saves, int matchesPlayed) {
        this.name = name;
        this.position = position;
        this.matchesPlayed = matchesPlayed;
    }
    
    public String getName() {
        return name;
    }
  
    public String getPosition() {
        return position;

    }
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    public String getAssignedTeam() {
        return assignedTeam;
    }
    public void setPlayerTeam(String team) {
        this.assignedTeam = team; //sets the team for the player
        System.out.println(name + " has been assigned to team: " + assignedTeam);
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
        System.out.println("Assigned Team: " + assignedTeam);
       
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
