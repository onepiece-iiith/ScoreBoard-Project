package TableViewFiles;

public class TableBatsman {

    private String playerName;
    private String outType;
    private int batsmanRun;
    private int ballPlayed;
    private int fourRun;
    private int sixRun;
    private double strikeRate;

    public TableBatsman(String playerName, String outType, int batsmanRun, int ballPlayed, int fourRun, int sixRun, double strikeRate) {
        this.playerName = playerName;
        this.outType = outType;
        this.batsmanRun = batsmanRun;
        this.ballPlayed = ballPlayed;
        this.fourRun = fourRun;
        this.sixRun = sixRun;
        this.strikeRate = strikeRate;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getOutType() {
        return outType;
    }

    public int getBatsmanRun() {
        return batsmanRun;
    }

    public int getBallPlayed() {
        return ballPlayed;
    }

    public int getFourRun() {
        return fourRun;
    }

    public int getSixRun() {
        return sixRun;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public void setBatsmanRun(int batsmanRun) {
        this.batsmanRun = batsmanRun;
    }

    public void setBallPlayed(int ballPlayed) {
        this.ballPlayed = ballPlayed;
    }

    public void setFourRun(int fourRun) {
        this.fourRun = fourRun;
    }

    public void setSixRun(int sixRun) {
        this.sixRun = sixRun;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }
}