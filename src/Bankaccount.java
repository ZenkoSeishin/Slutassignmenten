import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Bankaccount {
    //attribut

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //construktor

    public Bankaccount(String customerName, String customerId){
        customerName = customerName;
        customerId = customerId;
    }
    //metoder
    public void deposit (int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;

        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    public void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;

        }
    }
    public void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome "+ customerName);
        System.out.println("Your ID "+customerId);
        System.out.println("\n");

        System.out.println("1 : Check your Balance");
        System.out.println("2 : Deposit");
        System.out.println("3 : Previous Transaction");
        System.out.println("4 : Exit the system");
        do {
            System.out.println("-------------------------");
            System.out.println("Enter Your Option");
            System.out.println("-------------------------");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("-------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("-------------------------");
                    System.out.println("Enter an amount to deposit ");
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    int amount = scanner.nextInt();
                    deposit(amount);

                    break;

                case 'C':
                    System.out.println("-------------------------");
                    System.out.println("Enter an amount to withdraw ");
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    int amount2 = scanner.nextInt();
                    deposit(amount2);

                    break;

                case 'D':
                    System.out.println("-------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("-------------------------");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank You");
    }
    //getset
    public void getPreviousTransaction(){
        if(previousTransaction >0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }
}
