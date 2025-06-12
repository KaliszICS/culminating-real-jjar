/**
 * @author Justin, Jonathan, Arvin, Raymond
 * @version 17.0.1
 **/
import java.util.ArrayList;

public interface SportsLeague {
    //main
    void addTeam(Team team);
    void removeTeam(Team team);
    void calculateStandings();
    void generateSchedule();
    
    //getters
    String getSport();
    ArrayList<String> getTeams();
    Schedule getSchedule();
    String getStandings();
    
    //mangement
    void recordGameResult(Game game);
    void updateTeamStats(Team team);
} 
