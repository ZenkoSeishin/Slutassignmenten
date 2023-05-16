import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Login {
    File myObj = new File("C:\\Users\\Tasci.Adem\\Pictures\\Slutassignmenten\\Slutassignmenten\\hej.txt");
    String data;
    char option = '0';
    public Scanner scanner = new Scanner(System.in);
    Path path = Paths.get("C:\\Users\\Tasci.Adem\\Pictures\\Slutassignmenten\\Slutassignmenten\\hej.txt");
//attribut
    String username;
    String userInput;
    int MenuStage = 1;

    //construktor

    public Login(){
       // SetName(myObj);
        MenuStage= 1;
        do {


        switch (MenuStage) {

            case 1:
                SetName(myObj);
                break;
            case 2:
                GetName(myObj);
                break;
            case 3:
                break;
        }

        }while (MenuStage ==1);


}


    //metoder

    public static boolean isLetter(String input){
        char[] chars = input.toCharArray();
        if (input.length() < 3 || input.contains(" ")) {
            return false;
        }
        for(char c : chars) {
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch(File fileName, String userInput) {
        boolean isMatch = false;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(userInput)) {
                    isMatch = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return isMatch;
    }


    //getseters

public static void SetName(File myObj){
    System.out.println("Enter text to write to file:");
    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    while(!isLetter(text)){
        System.out.print("Invalid input, please enter text containing 3 letters or more: ");
        text = scanner.nextLine();    }
    try {
        FileWriter writer = new FileWriter(myObj, true); // append mode
        writer.write(text + "\n"); // add a newline character
        writer.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
        e.printStackTrace();
    }
}

public static void GetName(File myObj){
    System.out.println("What is your name?");
    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    while(!isLetter(text)){
        System.out.print("Invalid input, please enter text containing 3 letters or more: ");
        text = scanner.nextLine();
        boolean match = isMatch(myObj,text);
        if (match == true){
            break;
        }
    }

}

    public static void main(String[] args) {
        new Login();
    }
}
