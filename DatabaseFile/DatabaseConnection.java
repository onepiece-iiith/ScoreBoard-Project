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

        String sql3 = "CREATE TABLE BATSMAN1 (batsman_name varchar(70), out_type varchar(200), "
                                                + "batsman_run INT, ball_played INT, four_run INT, six_run INT, "
                                                + "strike_rate DOUBLE);";

        String sql4 = "CREATE TABLE BOWLER1 (bowler_name varchar(70), bowler_over DOUBLE, maiden_over INT, run_given INT, wicket_taken INT, "
                                            + "wide_ball INT, no_ball INT, economy DOUBLE);";

        String sql5 = "CREATE TABLE BATSMAN2 (batsman_name varchar(70), out_type varchar(200), "
                                            + "batsman_run INT, ball_played INT, four_run INT, six_run INT, "
                                            + "strike_rate DOUBLE);";

        String sql6 = "CREATE TABLE BOWLER2 (bowler_name varchar(70), bowler_over DOUBLE, maiden_over INT, run_given INT, wicket_taken INT, "
                                            + "wide_ball INT, no_ball INT, economy DOUBLE);";

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

    public ObservableList<TableBatsman> getBatsmanData(String tableName) throws Exception{


        Connection connect = getConnection();
        ObservableList<TableBatsman> list = FXCollections.observableArrayList();

        String sql = "SELECT * FROM " + tableName + ";";

        PreparedStatement statement = connect.prepareStatement(sql);
        ResultSet results = statement.executeQuery();

        while(results.next()){

            String playerName = results.getString("batsman_name");
            String outType = results.getString("out_type");
            int run = results.getInt("batsman_run");
            int ballPlayed = results.getInt("ball_played");
            int four = results.getInt("four_run");
            int six = results.getInt("six_run");
            double strikeRate = results.getDouble("strike_rate");

            TableBatsman batsman = new TableBatsman(playerName,outType,run,ballPlayed,four,six,strikeRate);

            list.add(batsman);

        }
        return list;

    }

    public ObservableList<TableBowler> getBowlerData(String tableName) throws Exception{


        Connection connect = getConnection();
        ObservableList<TableBowler> list = FXCollections.observableArrayList();

        String sql = "select * from " + tableName + ";";

        PreparedStatement statement = connect.prepareStatement(sql);
        ResultSet results = statement.executeQuery();

        while(results.next()){

            String bowlerName = results.getString("bowler_name");
            double bowlerOver = results.getDouble("bowler_over");
            int maidenOver = results.getInt("maiden_over");
            int runGiven = results.getInt("run_given");
            int wicketTaken = results.getInt("wicket_taken");
            int wideBall = results.getInt("wide_ball");
            int noBall = results.getInt("no_ball");
            double economy = results.getDouble("economy");

            TableBowler bowler = new TableBowler(bowlerName,bowlerOver,maidenOver,runGiven,wicketTaken,wideBall,noBall,economy);

            list.add(bowler);

        }
        return list;

    }

}