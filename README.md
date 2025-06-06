[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19700910)

jarvin
jarnathan
jarstin
jarmond

// CANNOT COMMIT & SYNC - Jonathan 

import java.util.*; // Standings Class I created copy & Paste to codeSpace someone

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
