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

      public boolean shouldSimulate(){
      String userPrompt = "\n Enter 1 to CONTINUE simulation or 0 to EXIT program:";
      IntUserInputRetriever<Boolean> intUserInputRetriever = s -> {
        if(s == 1 && customer.getMoney() >= menu.getLowestCostFood().getPrice()){
            return true;
        }else if(s == 0){
          System.out.println("\nThank you for eating with us! Hope to see you soon!");
          return false;
        } else {
          throw new IllegalArgumentException();
        }
      };
      return this.getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }


}
