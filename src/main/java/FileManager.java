import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void saveGamesToFile(ArrayList<Game> games) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("GamesFile.txt"))) {
            for (Game game : games) {
                String gameData = game.getTeam1().getTeamName() + "," + // Format of how it's going to be stored in the file    
                              game.getTeam2().getTeamName() + "," +
                              game.getTeam1Score() + "," +
                              game.getTeam2Score() + "," +
                              game.isGameOver();
                bw.write(gameData);
                bw.newLine();
                
            }
            System.out.println("Games saved to " + "GamesFile.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }

    public static void saveScheduleToFile(Schedule schedule) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter ("ScheduleFile.txt"))) {
                for (Game game : schedule.getGames()) {
                String gameData = game.getTeam1().getTeamName() + "," +
                                  game.getTeam2().getTeamName() + "," +
                                  game.getTeam1Score() + "," +
                                  game.getTeam2Score() + "," +
                                  game.isGameOver();
                bw.write(gameData);
                bw.newLine();     
        }
            
            System.out.println("Schedule saved to " + "ScheduleFile.txt");
        } catch (IOException e) {
            System.out.println(e);
        } 

    }
        
       
        public static void saveStandingsToFile(String standings) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("StandingsFile.txt"))) {
            bw.write(standings);
            bw.newLine();
            
            System.out.println("Standings saved to " + "StandingsFile.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

       public static void saveTeamsToFile(ArrayList<Team> teams) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("TeamsFile.txt"))) {
                for(Team team : teams) {
                    String teamData = team.getTeamName() + "," +
                                      team.getPlayers() + "," + 
                                      team.getPlayers().size();
                    bw.write(teamData);
                    bw.newLine();   
             
                }     
                System.out.println("Teams saved to " + "TeamsFile.txt");
       } catch (IOException e) {
           System.out.println(e);
                
         } 
    }
}


