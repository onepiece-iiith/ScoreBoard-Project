package ClassFile;


public class Player {

    private String playerName;
    private Team team;

    Player() {

    }

    public Player(String playerName, Team team) {
        this.playerName = playerName;
        this.team = team;
    }



    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return team.getName();
    }

    public void setTeam(Team team){
        this.team = team;
    }
    // Add a method to get the team object
    public Team getTeam(){
        return team;
    }
    // Add methods to perform operations on the player, such as calculating statistics,
    // updating player information, or interacting with other parts of the application.
    public void addMatchData(MatchData data){
        //Implementation to add Match Data
    }
    public MatchData getMatchData(){
        //Implementation to get Match data
        return null;
    }


} 