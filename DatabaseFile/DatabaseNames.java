package DatabaseFile;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseNames {
    private String saveNames;

    public DatabaseNames(String saveNames){

        this.saveNames = saveNames;

        try {

            FileWriter file = new FileWriter("/ScoreBoard/data/databaseNames.txt", true);
            BufferedWriter buffer = new BufferedWriter(file);
            PrintWriter output = new PrintWriter(buffer);


            output.println(saveNames);

            output.flush();

            file.close();
            buffer.close();
            output.close();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage());
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


        File file = new File("/ScoreBoard/data/databaseNames.txt");

        if(!file.exists()){
            if (!file.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Error creating database names file.");
            }
        }
        try (Scanner scan = new Scanner(file)) {
            ArrayList<String> names = new ArrayList<>();

            while(scan.hasNextLine()){
                String dataName = scan.nextLine();
                names.add(dataName);
            }
            return names;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error reading database names file: " + e.getMessage());
            return new ArrayList<>(); // Return empty list on error
        }
    }

}
