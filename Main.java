import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {



           Scanner input = new Scanner(System.in);
        System.out.println("\nWhat is your name");
        String customerName = input.nextLine();

        int money = 0;
        boolean validInput = false;

        while(!validInput){
          System.out.println("\nWhat is your starting money?");
          try{
            money = input.nextInt();
            if(money <= 0){
              throw new InputMismatchException();
            }
            validInput = true;
          } catch(InputMismatchException e){
            System.out.println("\nInvalid input. Please enter a valid positive number.");
          }
        }

        Customer customer = new Customer(customerName, money);
        
        TakeAwaySimulator takeOutSimulator = new TakeAwaySimulator(customer, input);
        
        takeOutSimulator.startTakeOutSimulator();
    }
}
