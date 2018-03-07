package niv.hfad.com.niv2;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoav on 2/8/2018.
 */

public class Item {

    private String itemName;
    private int wholesale;
    private int retail;
    private int amountToOrder;
    private String color;
    private String imagePath;

    public List<String> getColors() {
        return colors;
    }

    private List<String> colors = new ArrayList<>();

    Item(String name, int wholesale, int retail){
        this.itemName = name;
        this.wholesale = wholesale;
        this.retail = retail;
        this.amountToOrder = 0;
        this.imagePath = "C:\\Users\\yoav\\AndroidStudioProjects\\Niv2\\app\\src\\main\\res\\drawable-xxxhdpi\\" + itemName.toLowerCase();
        this.color = " ";
        colors.add("Select color...");
        colors.add("Sblack");
        colors.add("Gblack");
        colors.add("Ggrey");
        colors.add("Gcamel");
        colors.add("Gold");
        colors.add("Silver");
    }

    Item(String name , int wholesale , int retail , int amountToOrder , String color){
        this.itemName = name;
        this.wholesale = wholesale;
        this.retail = retail;
        this.amountToOrder = amountToOrder;
        this.color = color;
    }

    public String getImagePath(){
        return imagePath;
    }

    @Override
    public String toString(){
        return "item name = " + itemName + " , " +
                " wholesale = " + wholesale + " wholesale = "
                + retail +  " amountToOrder = " + amountToOrder
                + " color = " + color + "\n";
    }


    String getItemName() {
        return itemName;
    }

    public int getWholesale() {
        return wholesale;
    }

    public int getRetail() {
        return retail;
    }

    int getAmountToOrder() {
        return amountToOrder;
    }

    void setAmountToOrder(int amountToOrder) {
        this.amountToOrder = amountToOrder;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

}
