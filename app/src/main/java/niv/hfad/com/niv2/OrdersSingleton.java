package niv.hfad.com.niv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yoav on 2/8/2018.
 */

class OrdersSingleton {

    private static final OrdersSingleton instance = new OrdersSingleton();
    private static List<Item> orderedItems = new ArrayList<>();
    private static HashSet<String> names = new HashSet<>();

    //private constructor to avoid client applications to use constructor
    private OrdersSingleton(){}

    static OrdersSingleton getInstance(){
        return instance;
    }

    void addOrder(String itemName, int wholesale, int retail , int amountToOrder, String color){
        if(amountToOrder == 0 )
            return;
        boolean found = false;
        for(Item item : orderedItems){
            if(itemName.equals(item.getItemName()) && color.equals(item.getColor())){
                item.setAmountToOrder(amountToOrder);
                found = true;
                break;
            }
        }
        if(!found){
            orderedItems.add(new Item(itemName , wholesale , retail , amountToOrder , color));
        }
//        if(!names.contains(itemName)){
//            orderedItems.add(new Item(itemName , wholesale , retail , amountToOrder , color));
//            names.add(itemName);
//        }else{
//            for(Item item : orderedItems){
//                if(item.getItemName().equals(itemName)){
//                    item.setAmountToOrder(amountToOrder);
//                    item.setColor(color);
//                }
//            }
//        }
    }

    String orderedItemsToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Item item : orderedItems){
            stringBuilder.append(item.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
