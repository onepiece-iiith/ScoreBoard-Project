import FXML_FIle.LoadingPageControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class LaunchApp extends Application {

    private static final String CONFIG_FILE = "config.properties";
    private static Properties config = new Properties();

    public static void main(String[] args) {
        loadConfig();
        launch(args);
    }

    private static void loadConfig() {
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            config.load(input);
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_FIle/LoadingPage.fxml"));
        Parent root = loader.load();

        LoadingPageControl loadingPageControl = loader.getController();
        loadingPageControl.setStage(primaryStage);


        String imagePath = config.getProperty("image_path", "Final Logo.png");
        Image icon = new Image("file:" + imagePath);                                                  // For IDE
        //Image icon = new Image(getClass().getResourceAsStream("/Final Logo.png"));                      // For JAR
        DataLoader dataLoader = new DataLoader();
        dataLoader.createFiles();


        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Cricket Live Scoreboard");

        primaryStage.setScene(new Scene(root));
        primaryStage.setX(600);
        primaryStage.setY(100);
        primaryStage.show();


        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            logOut(primaryStage);
        });


    }

    public void logOut(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setHeaderText("You are about to EXIT");
        alert.setContentText("Are you sure??");


        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }

    }




}

class DataLoader{

    private static final String CONFIG_FILE = "config.properties";
    private static Properties config = new Properties();

    static {
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            config.load(input);
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
        }
    }

    public void createFiles() throws IOException {

        String teamFilePath = config.getProperty("team_file_path", "/ScoreBoard/data/AllTeamName.txt");
        String playerFilePath = config.getProperty("player_file_path", "/ScoreBoard/data/AllPlayerName.txt");

        File teamFile = new File(teamFilePath);
        File playerFile = new File(playerFilePath);

        FileHandler fileHandler = new FileHandler();

        fileHandler.createFile(teamFile, getTeamList());
        fileHandler.createFile(playerFile, getPlayerList());

    }

    public ArrayList<String> getTeamList() throws IOException {

        ArrayList<String> list = new ArrayList<String>();

        String teamFilePath = config.getProperty("team_file_path", "AllTeamName.txt");
        InputStream in = new FileInputStream(teamFilePath);                    // For IDE
        //InputStream in = getClass().getResourceAsStream("/AllTeamName.txt");            // For JAR
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));


        String line;

        while ((line=reader.readLine())!=null) {
            list.add(line);
        }

        in.close();
        reader.close();


        return list;

    }

    public ArrayList<String> getPlayerList() throws IOException {

        ArrayList<String> list = new ArrayList<String>();

        String playerFilePath = config.getProperty("player_file_path", "AllPlayerName.txt");
        InputStream in = new FileInputStream(playerFilePath);                    // For IDE
        //InputStream in = getClass().getResourceAsStream("/AllPlayerName.txt");            // For JAR
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));


        String line;

        while ((line=reader.readLine())!=null) {
            list.add(line);
        }

        in.close();
        reader.close();


        return list;


    }
}

class FileHandler{

    public void createFile(File file, ArrayList<String> data) throws IOException{
        if (!file.exists()) {
            Path path = Paths.get(file.getParent());
            Files.createDirectories(path);
            PrintWriter output = new PrintWriter(file);
            for(String names : data){
                output.println(names);
            }
            output.close();
        }
    }
}