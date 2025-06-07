import java.util.Random;
public class Game {
    final Team team1;
    final Team team2;
    private int team1Score;  
    private int team2Score; 
    private boolean gameOver;

    
    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = 0;  // Games start at 0-0
        this.team2Score = 0;
        this.gameOver = false;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }
    
    public int getTeam2Score() {
        return team2Score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void simulateGame() {
        System.out.println("Match Starting 🏆: " + team1.getTeamName() + " vs " + team2.getTeamName());

        // Sets each teams points to 0 (GAME BEGINS)
        team1Score = 0;
        team2Score = 0;

        
        Random random = new Random();
        team1Score = random.nextInt(6); // 0-5 goals
        team2Score = random.nextInt(6); // 0-5 goals
        
        gameOver = true; 

        // FINAL RESULTS
        System.out.println("GAME OVER!");
        System.out.println("FINAL SCORE: " + team1.getTeamName() + " " + team1Score + " -- " + team2Score + " " + team2.getTeamName());
        
     
        if(team1Score > team2Score) {
            System.out.println(team1.getTeamName() + " WINS!! 🎉🎉 ");
        } else if (team2Score > team1Score){
            
            System.out.println(team2.getTeamName() + " WINS!! 🎉🎉");
        } else {
            System.out.println("DRAW");
        }
    }

    
  public String displayGameInfo() {

  }
    

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
