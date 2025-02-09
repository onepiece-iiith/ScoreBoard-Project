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

public class LaunchApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_FIle/LoadingPage.fxml"));
        Parent root = loader.load();

        LoadingPageControl loadingPageControl = loader.getController();
        loadingPageControl.setStage(primaryStage);


        Image icon = new Image("file:Final Logo.png");                                                  // For IDE
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

    public void createFiles() throws IOException {

        File teamFile = new File("/ScoreBoard/data/AllTeamName.txt");
        File playerFile = new File("/ScoreBoard/data/AllPlayerName.txt");

        FileHandler fileHandler = new FileHandler();

        fileHandler.createFile(teamFile, getTeamList());
        fileHandler.createFile(playerFile, getPlayerList());

    }

    public ArrayList<String> getTeamList() throws IOException {

        ArrayList<String> list = new ArrayList<String>();


        InputStream in = new FileInputStream("AllTeamName.txt");                    // For IDE
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

        InputStream in = new FileInputStream("AllPlayerName.txt");                    // For IDE
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
            Path path = Paths.get("/ScoreBoard/data/");
            Files.createDirectories(path);
            PrintWriter output = new PrintWriter(file);
            for(String names : data){
                output.println(names);
            }
            output.close();
        }
    }
}