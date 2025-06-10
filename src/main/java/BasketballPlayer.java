public class BasketballPlayer extends player{
    private int points;
    private int assists;
    private int rebounds;
    private int blocks;
    private int steals;
   

    public BasketballPlayer(int points, int assists, int rebounds, int blocks, int steals){
        super(name, position, matchesPlayed);
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.blocks = blocks;
        this.steals = steals;
    }
}