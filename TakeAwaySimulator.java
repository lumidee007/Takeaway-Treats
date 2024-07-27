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

    public Food getMenuSelection(){
      System.out.println("Our Menu options:\n");

      System.out.println(menu);

      String userPrompt = "Choose a menu item (Enter the corresponding number):";


      IntUserInputRetriever<Food> intUserInputRetriever = s -> {
        if(menu.getFood(s) != null){
            return menu.getFood(s);
        }else {
          throw new IllegalArgumentException();
        }
      };

      return this.getOutputOnIntInput(userPrompt, intUserInputRetriever);

    }
    
public boolean isStillOrderingFood(){

      String userPrompt = "\nEnter 1 to CONTINUE shopping or 0 to CHECKOUT:";

      IntUserInputRetriever<Boolean> intUserInputRetriever = s -> {
        if(s ==1){
            return true;
        }else if (s==0){
          return false;
        }else {
          throw new IllegalArgumentException();
        }
      };
      return this.getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    // / CheckoutCustomer
    public void checkoutCustomer(ShoppingBag<Food> shoppingBag){
      System.out.println("\nProcessing payment...");

      int remainingMoney = customer.getMoney() - shoppingBag.getTotalPrice();
      customer.setMoney(remainingMoney);

      System.out.println("Your remaining money is $" + remainingMoney);
      System.out.println("\nThank you and enjoy your food!");
     }






      // 2. TakeOutprompt
      public void takeOutprompt(){
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();


        int customerMoneyLeft = customer.getMoney();
        

        boolean stillOrdering = true;


        while(stillOrdering){
            System.out.println("You have $" + customerMoneyLeft + " left to spend\n");

            Food item = this.getMenuSelection();
            
            if(customerMoneyLeft >= item.getPrice()){
              customerMoneyLeft -= item.getPrice();
              shoppingBag.addItem(item);
            } else {
              System.out.println("\nOops! Looks like you don't have enough for that. Choose another item or checkout.'");
            }
            stillOrdering = this.isStillOrderingFood();
            if(stillOrdering == false){
              checkoutCustomer(shoppingBag);
            }
          }
       }

      // 1. StartTakeOutSimulator
      public void startTakeOutSimulator(){

          boolean continueSimulating = true;

           while(continueSimulating){
              System.out.println(
                "\n-----------------------------------\n Name's Table & Grill\n----------------------------------\n"
              );
              System.out.println("Welcome " + customer.getName() + "! ");

              this.takeOutprompt();
              
              continueSimulating = this.shouldSimulate();
           }
        }

}
