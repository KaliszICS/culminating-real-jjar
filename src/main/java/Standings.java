import java.util.*;
public class Standings {
    private HashMap<Team, Integer> rankings;

    public Standings(HashMap<Team, Integer> rankings) {
        this.rankings = rankings;
    }

    public void calculateRankings() {
        for(Team team : rankings.keySet()) {
            int points = rankings.get(team);
            System.out.println("Team: " + team.getTeamName() + ", Points: " + points);
        }
    }

    public ArrayList<String> displayStandings() {
        ArrayList<String> standingList = new ArrayList<>();
        for (Team team : rankings.keySet()) {
            int points = rankings.get(team);
            standingList.add("Team: " + team.getTeamName() + ", Points: " + points);
        }
        return standingList;
    }
}
