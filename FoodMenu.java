import java.util.ArrayList;
import java.util.List;

public class FoodMenu {

    private List<Food>menu;

    public FoodMenu(){
        this.menu = new ArrayList<>();

        menu.add(new Food("pizza","Spicy and delicious",90));
        menu.add(new Food("small chops","yummy and delicious",10));
        menu.add(new Food("burger","Juicy and delicious",100));
        menu.add(new Food("pasta","Spicy and delicious",80));
    }

    // Getting food item
    public Food getFood(int index){
        if(index > menu.size() || index < 1){
            return null;
        }else {
            return menu.get(index - 1);
        }
    }

    // getting the cheapest food in the menu
    public Food getlowestCostFood(){
        if(menu.isEmpty()){
            return null;
        }

        Food cheapestFood = menu.get(0);

        for(Food food: menu){
            if(food.getPrice() < cheapestFood.getPrice()){
                cheapestFood = food;
            }
        }
        return cheapestFood;

    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        int count = 1;
        for (Food item : menu) {
            returnString.append(count)
                        .append(". ")
                        .append(item.toString())
                        .append("\n");
            count++;
        }
        return returnString.toString();
    }
}
