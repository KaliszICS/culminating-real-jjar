/**
 * Represents a game between two teams.
 * Contains information about the teams, their scores, and the game status.
 */
public class Game {
    private final Team team1;
    private final Team team2;
    private int team1Score;  
    private int team2Score; 
    private boolean gameOver;

    /**
     * Constructor to initialize a Game object with two teams and their scores.
     * @param team1 The first team.
     * @param team2 The second team.
     * @param team1Score The score of the first team.
     * @param team2Score The score of the second team.
     * @param gameOver Indicates whether the game is over or not.
     */
    public Game(Team team1, Team team2, int team1Score, int team2Score, boolean gameOver) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.gameOver = gameOver;
    }

    /**
     * Returns the first team in the game.
     * @return The first team.
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * Returns the second team in the game.
     * @return The second team.
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * Returns the score of the first team.
     * @return The score of the first team.
     */
    public int getTeam1Score() {
        return team1Score;
    }
    
    /**
     * Returns the score of the second team.
     * @return The score of the second team.
     */
    public int getTeam2Score() {
        return team2Score;
    }

    /**
     * Returns the status of the game (whether it is over or not).
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    // public void simulateGame() {
    //     System.out.println("Match Starting 🏆: " + team1.getTeamName() + " vs " + team2.getTeamName());

    //     // Sets each teams points to 0 (GAME BEGINS)
    //     team1Score = 0;
    //     team2Score = 0;

        
    //     Random random = new Random();
    //     team1Score = random.nextInt(6); // 0-5 goals
    //     team2Score = random.nextInt(6); // 0-5 goals
        
    //     gameOver = true; 

    //     // FINAL RESULTS
    //     System.out.println("GAME OVER!");
    //     System.out.println("FINAL SCORE: " + team1.getTeamName() + " " + team1Score + " -- " + team2Score + " " + team2.getTeamName());
        
     
    //     if(team1Score > team2Score) {
    //         System.out.println(team1.getTeamName() + " WINS!! 🎉🎉 ");
    //     } else if (team2Score > team1Score){
            
    //         System.out.println(team2.getTeamName() + " WINS!! 🎉🎉");
    //     } else {
    //         System.out.println("DRAW");
    //     }
    // }

    
//   public String displayGameInfo() {

//   }
    
    /**
     * Returns a string representation of the game, including team names and scores.
     * The format depends on whether the game is over or not.
     * @return A string describing the game.
     */
    @Override
    public String toString() {
        // Fixed: Use actual team scores instead of generic score variable
        if (gameOver) {
            return team1.getTeamName() + " " + team1Score + " - " + team2Score + " " + team2.getTeamName() + " (FINAL)";
        } else {
            return team1.getTeamName() + " vs " + team2.getTeamName() + " (" + team1Score + " - " + team2Score + ")";
        }
    }
}
