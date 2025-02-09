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

    // Add a method to the Player class that performs an operation on its data
    public String getPlayerInfo(){
        return "Player Name: "+playerName+"\nTeam: "+team.getName();
    }
}    

    