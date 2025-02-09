package DatabaseFile;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseNames {
    private final String dataDirectory = "/ScoreBoard/data/";
    private final String databaseNamesFileName = "databaseNames.txt";
    private String saveNames;

    public DatabaseNames(String saveNames){

        this.saveNames = saveNames;

        try {
            Path filePath = Paths.get(dataDirectory, databaseNamesFileName);
            Files.createDirectories(filePath.getParent());
            FileWriter file = new FileWriter(filePath.toString(), true);
            BufferedWriter buffer = new BufferedWriter(file);
            PrintWriter output = new PrintWriter(buffer);


            output.println(saveNames);

            output.flush();

            file.close();
            buffer.close();
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DatabaseNames(){}

    public String getSaveNames() {
        return saveNames;
    }

    public String toString(){
        return saveNames;
    }

    public ArrayList<String> getDatabaseNames() throws IOException {
        Path filePath = Paths.get(dataDirectory, databaseNamesFileName);
        File file = filePath.toFile();

        if(!file.exists()){
            file.createNewFile();
        }
        Scanner scan = new Scanner(file);
        ArrayList<String> names = new ArrayList<>();

        while(scan.hasNextLine()){
            String dataName = scan.nextLine();
            names.add(dataName);
        }
        scan.close();
        return names;

    }
}