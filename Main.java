// import java.util.Map;

public class Main {
    
    public static void main(String[] args) {



        Food pizza = new Food("pizza","Spicy and delicious",90);
        Food burger = new Food("burger","Juicy and delicious",100);
   
        Food samosa = new Food("samosa","Spicy and delicious",10);


        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        
        shoppingBag.addItem(pizza);
        shoppingBag.addItem(samosa);
        shoppingBag.addItem(samosa);
        shoppingBag.addItem(burger);

        // System.out.println(shoppingBag.toString());
        // System.out.println(shoppingBag.getTotalPrice());
        // System.out.println(new FoodMenu());
        // System.out.println(new FoodMenu().getFood(2));
        System.out.println(new FoodMenu().getlowestCostFood());
    }
}
