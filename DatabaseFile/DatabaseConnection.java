package DatabaseFile;

import TableViewFiles.TableBatsman;
import TableViewFiles.TableBowler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnection {

    private String databaseName;
    private String databaseUser;
    private String databasePass;

    public DatabaseConnection(String databaseName, String databaseUser, String databasePass) {
        this.databaseName = databaseName;
        this.databaseUser = databaseUser;
        this.databasePass = databasePass;
    }

    public DatabaseConnection(String databaseUser, String databasePass) {
        this.databaseUser = databaseUser;
        this.databasePass = databasePass;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + this.databaseName, this.databaseUser, this.databasePass);
        return connection;

    }

    public Connection createDatabase(String newDatabaseName) throws Exception {

        String jdbcDriver = "com.mysql.jdbc.Driver";
        String jdbcURL = "jdbc:mysql://localhost/";
        String databaseName = newDatabaseName;
        Class.forName(jdbcDriver);
        Connection connectDB = DriverManager.getConnection(jdbcURL, this.databaseUser, this.databasePass);

        String sql1 = "CREATE DATABASE " + databaseName + ";";
        String sql2 = "USE " + databaseName + ";";

        String sql3 = "CREATE TABLE BATSMAN1 (batsman_name varchar(70), out_type varchar(200), " +
                                                "batsman_run varchar(10), ball_played varchar(10), four_run varchar(10), six_run varchar(10), " +
                                                "strike_rate varchar(10));";

        String sql4 = "CREATE TABLE BOWLER1 (bowler_name varchar(70), bowler_over varchar(10), maiden_over varchar(10), run_given varchar(10), wicket_taken varchar(10), " +
                                            "wide_ball varchar(10), no_ball varchar(10), economy varchar(10));";

        String sql5 = "CREATE TABLE BATSMAN2 (batsman_name varchar(70), out_type varchar(200), " +
                                            "batsman_run varchar(10), ball_played varchar(10), four_run varchar(10), six_run varchar(10), " +
                                            "strike_rate varchar(10));";

        String sql6 = "CREATE TABLE BOWLER2 (bowler_name varchar(70), bowler_over varchar(10), maiden_over varchar(10), run_given varchar(10), wicket_taken varchar(10), " +
                                            "wide_ball varchar(10), no_ball varchar(10), economy varchar(10));";

        String sql7 = "CREATE TABLE matchinfo1 (match_info1 varchar(400));";

        String sql8 = "CREATE TABLE matchinfo2 (match_info2 varchar(400));";

        String sql9 = "CREATE TABLE match_status (match_status varchar(400));";

        
        PreparedStatement statement1 = connectDB.prepareStatement(sql1);
        PreparedStatement statement2 = connectDB.prepareStatement(sql2);
        PreparedStatement statement3 = connectDB.prepareStatement(sql3);
        PreparedStatement statement4 = connectDB.prepareStatement(sql4);
        PreparedStatement statement5 = connectDB.prepareStatement(sql5);
        PreparedStatement statement6 = connectDB.prepareStatement(sql6);
        PreparedStatement statement7 = connectDB.prepareStatement(sql7);
        PreparedStatement statement8 = connectDB.prepareStatement(sql8);
        PreparedStatement statement9 = connectDB.prepareStatement(sql9);


        statement1.executeUpdate();
        statement2.executeUpdate();
        statement3.executeUpdate();
        statement4.executeUpdate();
        statement5.executeUpdate();
        statement6.executeUpdate();
        statement7.executeUpdate();
        statement8.executeUpdate();
        statement9.executeUpdate();

        statement1.close();
        statement2.close();
        statement3.close();
        statement4.close();
        statement5.close();
        statement6.close();
        statement7.close();
        statement8.close();
        statement9.close();

        return connectDB;
    }

    public <T extends PlayerStats> ObservableList<T> getPlayerData(String tableName, Class<T> playerStatsClass) throws Exception {
        Connection connect = getConnection();
        ObservableList<T> list = FXCollections.observableArrayList();

        String sql = "SELECT * FROM " + tableName + ";";

        PreparedStatement statement = connect.prepareStatement(sql);
        ResultSet results = statement.executeQuery();

        while (results.next()) {
            T playerStats = playerStatsClass.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class, String.class).newInstance(
                    results.getString("playerName"),
                    results.getString("attribute1"),
                    results.getString("attribute2"),
                    results.getString("attribute3"),
                    results.getString("attribute4"),
                    results.getString("attribute5"),
                    results.getString("attribute6")
            );
            list.add(playerStats);
        }

        return list;
    }

}

class PlayerStats{

    private String playerName;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;

    public PlayerStats() {}

    public PlayerStats(String playerName, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, String attribute6) {
        this.playerName = playerName;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.attribute6 = attribute6;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }
}
