package TableViewFiles;

public class TableBatsman {

    private String playerName;
    private String outType;
    private String batsmanRun;
    private String ballPlayed;
    private String fourRun;
    private String sixRun;
    private String strikeRate;

    public TableBatsman(String playerName, String outType, String batsmanRun, String ballPlayed, String fourRun, String sixRun, String strikeRate) {
        this.playerName = playerName;
        this.outType = outType;
        this.batsmanRun = batsmanRun;
        this.ballPlayed = ballPlayed;
        this.fourRun = fourRun;
        this.sixRun = sixRun;
        this.strikeRate = strikeRate;
    }

    // Getters and setters for all fields
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public String getBatsmanRun() {
        return batsmanRun;
    }

    public void setBatsmanRun(String batsmanRun) {
        this.batsmanRun = batsmanRun;
    }

    public String getBallPlayed() {
        return ballPlayed;
    }

    public void setBallPlayed(String ballPlayed) {
        this.ballPlayed = ballPlayed;
    }

    public String getFourRun() {
        return fourRun;
    }

    public void setFourRun(String fourRun) {
        this.fourRun = fourRun;
    }

    public String getSixRun() {
        return sixRun;
    }

    public void setSixRun(String sixRun) {
        this.sixRun = sixRun;
    }

    public String getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(String strikeRate) {
        this.strikeRate = strikeRate;
    }

    // Add a method to calculate strike rate
    public double calculateStrikeRate(){
        try{
            double run = Double.parseDouble(batsmanRun);
            double ball = Double.parseDouble(ballPlayed);
            return (run / ball) * 100;
        }catch (NumberFormatException e){
            return 0.0; // Handle potential exceptions
        }
    }
}
