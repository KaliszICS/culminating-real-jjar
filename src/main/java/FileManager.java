import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void saveGamesToFile(ArrayList<Game> games, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Game game : games) {
                String gameData = game.getTeam1().getTeamName() + "," +
                              game.getTeam2().getTeamName() + "," +
                              game.getTeam1Score() + "," +
                              game.getTeam2Score() + "," +
                              game.isGameOver();
                bw.write(gameData);
                bw.newLine();
                bw.close();
            }
            System.out.println("Games saved to " + fileName);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void saveScheduleToFile(Schedule schedule, String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter (fileName));
            for (Game game : schedule.getGames()) {
                String gameData = game.getTeam1().getTeamName() + "," +
                                  game.getTeam2().getTeamName() + "," +
                                  game.getTeam1Score() + "," +
                                  game.getTeam2Score() + "," +
                                  game.isGameOver();
                bw.write(gameData);
                bw.newLine();
                bw.close();
            }
            System.out.println("Schedule saved to " + fileName);
        } catch (IOException e) {
            System.out.println(e);
        } 
    }
}
