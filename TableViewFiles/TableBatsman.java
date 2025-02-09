package TableViewFiles;

public class TableBatsman {

    private String playerName;
    private BattingStatistics battingStatistics;

    public TableBatsman(String playerName, BattingStatistics battingStatistics) {
        this.playerName = playerName;
        this.battingStatistics = battingStatistics;
    }

    public String getPlayerName() {
        return playerName;
    }

    public BattingStatistics getBattingStatistics() {
        return battingStatistics;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setBattingStatistics(BattingStatistics battingStatistics) {
        this.battingStatistics = battingStatistics;
    }
}

class BattingStatistics {
    private String outType;
    private String batsmanRun;
    private String ballPlayed;
    private String fourRun;
    private String sixRun;
    private String strikeRate;

    public BattingStatistics(String outType, String batsmanRun, String ballPlayed, String fourRun, String sixRun, String strikeRate) {
        this.outType = outType;
        this.batsmanRun = batsmanRun;
        this.ballPlayed = ballPlayed;
        this.fourRun = fourRun;
        this.sixRun = sixRun;
        this.strikeRate = strikeRate;
    }

    // Getters and setters for all fields
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
}