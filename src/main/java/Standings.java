/**
 * @author Justin, Jonathan, Arvin, Raymond
 * @version 17.0.1
 **/
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Standings class calculates and maintains the standings of teams in a league.
 */
public class Standings {
    private ArrayList<String> teams;
    private ArrayList<Game> games;
    private String standings;

    /**
     * Constructor for Standings class.
     * @param teams List of team names.
     * @param games List of games played in the league.
     */
    public Standings(ArrayList<String> teams, ArrayList<Game> games) {
        this.teams = teams;
        this.games = games;
        this.standings = "";
    }

    /**
     * Calculates the standings of the teams based on their wins and points scored.
     * Uses merge sort to sort the teams.
     * Teams are sorted first by number of wins, then by points scored.
     * The standings are stored in a string format.
     */
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

    /**
     * Recursively sorts the array of team names using merge sort.
     * @param arr Array of team names.
     * @param left Starting index of the array to be sorted.
     * @param right Ending index of the array to be sorted. 
     */
    private void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two subarrays into a single sorted array.
     * The comparison is based on the number of wins and points scored by each team.
     * @param arr Array of team names to be sorted.
     * @param left Starting index of the left subarray.
     * @param mid Midpoint index of the array.
     * @param right Ending index of the right subarray.
     */
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

    /**
     * Calculates the number of wins for a given team.
     * @param teamName Name of the team.
     * @return Number of wins for the team.
     */
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

    /**
     * Calculates the total points scored by a given team.
     * @param teamName Name of the team.
     * @return Total points scored by the team.
     */
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

    /**
     * Returns the standings of the league.
     * @return String representation of the standings.
     */
    public String getStandings() {
        return standings;
    }
}
