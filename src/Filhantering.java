import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Filhantering extends BankGui {

    public static void main(String[] args) {
        findFiles();
        createFile();
        writeToAFile();
        //readFromFile();

    }

    public static void findFiles() {
        File myFile = new File("C:\\LALLISH");
        String[] fileList = myFile.list();

        // loops through a list of strings and prints the content
        for (String aFileName : fileList != null ? fileList : new String[0]) {
            System.out.println(aFileName);
        }
    }

    /*************************************************************
     * Creates a file if the file does not exist
     *************************************************************/
    public static void createFile() {

        File myFile = new File("C:\\LALLISH\\Hej\\Hej.txt");

        // Try to create a file
        try {
            //If the file does not exist it will be created
            if (myFile.createNewFile()) {
                System.out.println("file created");
            } else {
                System.out.println("file already exists");
            }
        } catch (IOException e) {
            System.out.println("NOPE!");
            e.printStackTrace();
        }
    }

    public static void writeToAFile() {
        try {
            FileWriter myWriter = new FileWriter("Hej.txt", true);
            myWriter.write("Minecraft 2 \n");
            myWriter.close();
            System.out.println("I have written to the file");
        } catch (IOException e) {
            System.out.println("NO WRITING!");
            e.printStackTrace();
        }
    }
        public static void readFromFile(){

            try {
                File myFile = new File("Hej.txt");
                Scanner myScan = new Scanner(myFile);
                while(myScan.hasNextLine()) {
                    String data = myScan.nextLine();
                    System.out.println(data);
                }
                myScan.close();
            }catch(FileNotFoundException e){
                System.out.println("No such file");
                e.printStackTrace();
            }
        }
    }


