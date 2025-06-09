import java.util.ArrayList;
import java.util.Arrays;

public class Standings {
    private ArrayList<String> teams;
    private ArrayList<Game> games;
    private String standings;

    public Standings(ArrayList<String> teams, ArrayList<Game> games) {
        this.teams = teams;
        this.games = games;
        this.standings = "";
    }

    public void calculateStandings() {
        String[] teamsArray = teams.toArray(new String[0]);
        mergeSort(teamsArray, 0, teamsArray.length - 1);
        
        teams.clear();
        teams.addAll(Arrays.asList(teamsArray));
        
        standings = "League Standings:\n";
        for (int i = 0; i < teams.size(); i++) {
            String team = teams.get(i);
            standings += team + " - Wins: " + getTeamWins(team) +
                    ", Points Scored: " + getTeamPointsScored(team) + "\n";
        }
    }

    private void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(String[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            int wins1 = getTeamWins(L[i]);
            int wins2 = getTeamWins(R[j]);
            
            if (wins1 > wins2 || (wins1 == wins2 &&  getTeamPointsScored(L[i]) > getTeamPointsScored(R[j]))) {
                arr[k] = L[i];
                i++;
            } 
            
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private int getTeamWins(String teamName) {
        int wins = 0;
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.getTeam1().getTeamName().equals(teamName) && game.getTeam1Score() > game.getTeam2Score()) {
                wins++;
            } 

            else if (game.getTeam2().getTeamName().equals(teamName) && game.getTeam2Score() > game.getTeam1Score()) {
                wins++;
            }
        }
        return wins;
    }

    private int getTeamPointsScored(String teamName) {
        int points = 0;
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.getTeam1().getTeamName().equals(teamName)) {
                points += game.getTeam1Score();
            } 
            
            else if (game.getTeam2().getTeamName().equals(teamName)) {
                points += game.getTeam2Score();
            }
        }
        return points;
    }

    public String getStandings() {
        return standings;
    }
}
