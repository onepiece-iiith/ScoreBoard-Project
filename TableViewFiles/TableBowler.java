package TableViewFiles;

public class TableBowler {

    private String bowlerName;
    private int bowlerOver;
    private int maidenOver;
    private int runGiven;
    private int wicketTaken;
    private int wideBall;
    private int noBall;
    private double economy;

    public TableBowler(String bowlerName, int bowlerOver, int maidenOver, int runGiven, int wicketTaken, int wideBall, int noBall, double economy) {
        this.bowlerName = bowlerName;
        this.bowlerOver = bowlerOver;
        this.maidenOver = maidenOver;
        this.runGiven = runGiven;
        this.wicketTaken = wicketTaken;
        this.wideBall = wideBall;
        this.noBall = noBall;
        this.economy = economy;
    }

    // Getters and setters for all fields
    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public int getBowlerOver() {
        return bowlerOver;
    }

    public void setBowlerOver(int bowlerOver) {
        this.bowlerOver = bowlerOver;
    }

    public int getMaidenOver() {
        return maidenOver;
    }

    public void setMaidenOver(int maidenOver) {
        this.maidenOver = maidenOver;
    }

    public int getRunGiven() {
        return runGiven;
    }

    public void setRunGiven(int runGiven) {
        this.runGiven = runGiven;
    }

    public int getWicketTaken() {
        return wicketTaken;
    }

    public void setWicketTaken(int wicketTaken) {
        this.wicketTaken = wicketTaken;
    }

    public int getWideBall() {
        return wideBall;
    }

    public void setWideBall(int wideBall) {
        this.wideBall = wideBall;
    }

    public int getNoBall() {
        return noBall;
    }

    public void setNoBall(int noBall) {
        this.noBall = noBall;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }
}