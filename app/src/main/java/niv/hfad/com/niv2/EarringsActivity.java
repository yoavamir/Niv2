package niv.hfad.com.niv2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class EarringsActivity extends Activity {

    private static List<Item> itemList = new ArrayList<>();
    OrdersSingleton ordersSingleton = OrdersSingleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earrings);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ItemsAdapter itemsAdapter = new ItemsAdapter((ArrayList<Item>) itemList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager iLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(iLayoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener(){
            @Override
            public void onClick (View view,int position){
                final Item item = itemList.get(position);
                Toast.makeText(getApplicationContext(), item.getItemName() + " is selected!", Toast.LENGTH_SHORT).show();
                String itemName = item.getItemName();

                try {
                    ordersSingleton.addOrder(itemName, item.getWholesale(), item.getRetail(), item.getAmountToOrder(),item.getColor());
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext() , "Please select an item" , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }


        }));
    }

    public static void addToList(String name, Integer wholesale , Integer retail) {
        itemList.add(new Item(name , wholesale , retail));
    }

}
