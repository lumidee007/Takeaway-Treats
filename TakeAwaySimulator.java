import java.util.Scanner;

public class TakeAwaySimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeAwaySimulator(Customer customer, Scanner input) {
        this.customer = customer;
        this.menu = new FoodMenu();
        this.input = input;
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever){
    while(true){
      System.out.println(userInputPrompt);
      
      if(input.hasNextInt()){
        int userInput = input.nextInt();
        input.nextLine();
        try{
          return intUserInputRetriever.produceOutputOnIntUserInput(userInput);
        }catch (IllegalArgumentException e){
          System.out.println(userInput + "is not a valid input. Try Again!\n");
        }
      }else {
          System.out.println("Input needs to be an 'int' type.\n");
          input.next();
      }
    }
  }


}
