import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>>{
    
    private Map<T, Integer>shoppingBag;

    public ShoppingBag(){
        this.shoppingBag = new HashMap<>();
    }


    // Adding item and count of each item in the shopping_bag
    public void addItem(T item){
        if(shoppingBag.get(item) == null){
            shoppingBag.put(item, 1);
        }else{
            Integer itemCount = shoppingBag.get(item);
            itemCount++;
            shoppingBag.put(item, itemCount);
        }
    }

    // Total price of items in the shopping_bag
    public int getTotalPrice(){
            int totalPrice = 0;
            
        for (Map.Entry<T, Integer> entry : shoppingBag.entrySet()) {
            T item = entry.getKey();
            Integer itemQuantity = entry.getValue();
            int itemPrice = item.getPrice();
            totalPrice += itemQuantity * itemPrice;
        }
            return totalPrice;
    }



        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ShoppingBag{\n");
        for (Map.Entry<T, Integer> entry : shoppingBag.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
