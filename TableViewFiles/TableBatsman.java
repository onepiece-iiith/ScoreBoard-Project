package TableViewFiles;

public class TableBatsman {

    private String playerName;
    private String outType;
    private BattingStats battingStats;

    public TableBatsman(String playerName, String outType, BattingStats battingStats) {
        this.playerName = playerName;
        this.outType = outType;
        this.battingStats = battingStats;
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

    public BattingStats getBattingStats() {
        return battingStats;
    }

    public void setBattingStats(BattingStats battingStats) {
        this.battingStats = battingStats;
    }
}

class BattingStats {
    private int batsmanRun;
    private int ballPlayed;
    private int fourRun;
    private int sixRun;
    private double strikeRate;

    public BattingStats(int batsmanRun, int ballPlayed, int fourRun, int sixRun, double strikeRate) {
        this.batsmanRun = batsmanRun;
        this.ballPlayed = ballPlayed;
        this.fourRun = fourRun;
        this.sixRun = sixRun;
        this.strikeRate = strikeRate;
    }

    // Getters and setters for all fields
    public int getBatsmanRun() {
        return batsmanRun;
    }

    public void setBatsmanRun(int batsmanRun) {
        this.batsmanRun = batsmanRun;
    }

    public int getBallPlayed() {
        return ballPlayed;
    }

    public void setBallPlayed(int ballPlayed) {
        this.ballPlayed = ballPlayed;
    }

    public int getFourRun() {
        return fourRun;
    }

    public void setFourRun(int fourRun) {
        this.fourRun = fourRun;
    }

    public int getSixRun() {
        return sixRun;
    }

    public void setSixRun(int sixRun) {
        this.sixRun = sixRun;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }
}
