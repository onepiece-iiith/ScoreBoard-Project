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

        String[] sqls = {sql1, sql2, sql3, sql4, sql5, sql6, sql7, sql8, sql9};
        
        executeSQLStatements(connectDB, sqls);

        return connectDB;
    }

    private void executeSQLStatements(Connection connection, String[] sqls) throws SQLException {
        for (String sql : sqls) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
        }
    }

    public ObservableList<TableBatsman> getBatsmanData(String tableName) throws Exception {


        Connection connect = getConnection();
        ObservableList<TableBatsman> list = FXCollections.observableArrayList();

        String sql = "SELECT * FROM " + tableName + ";";

        PreparedStatement statement = connect.prepareStatement(sql);
        ResultSet results = statement.executeQuery();

        while (results.next()) {

            String playerName = results.getString("batsman_name");
            String outType = results.getString("out_type");
            String run = results.getString("batsman_run");
            String ballPlayed = results.getString("ball_played");
            String four = results.getString("four_run");
            String six = results.getString("six_run");
            String strikeRate = results.getString("strike_rate");

            TableBatsman batsman = new TableBatsman(playerName, outType, run, ballPlayed, four, six, strikeRate);

            list.add(batsman);

        }
        return list;

    }

    public ObservableList<TableBowler> getBowlerData(String tableName) throws Exception {


        Connection connect = getConnection();
        ObservableList<TableBowler> list = FXCollections.observableArrayList();

        String sql = "select * from " + tableName + ";";

        PreparedStatement statement = connect.prepareStatement(sql);
        ResultSet results = statement.executeQuery();

        while (results.next()) {

            String bowlerName = results.getString("bowler_name");
            String bowlerOver = results.getString("bowler_over");
            String maidenOver = results.getString("maiden_over");
            String runGiven = results.getString("run_given");
            String wicketTaken = results.getString("wicket_taken");
            String wideBall = results.getString("wide_ball");
            String noBall = results.getString("no_ball");
            String economy = results.getString("economy");

            TableBowler bowler = new TableBowler(bowlerName, bowlerOver, maidenOver, runGiven, wicketTaken, wideBall, noBall, economy);

            list.add(bowler);

        }
        return list;

    }

}