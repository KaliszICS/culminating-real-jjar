public interface League {
    void generateSchedule();
    void calculateStandings();
    void addTeam(Team team);
    void removeTeam(Team team);
    void playGame(Game game);
    void displayStandings();
} 