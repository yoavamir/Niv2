package niv.hfad.com.niv2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NecklacesActivity extends Activity {

    private static List<Item> itemList = new ArrayList<>();
    OrdersSingleton ordersSingleton = OrdersSingleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_necklaces);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        ItemsAdapter itemsAdapter = new ItemsAdapter((ArrayList<Item>) itemList);
        recyclerView.setHasFixedSize(true);
        final RecyclerView.LayoutManager iLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(iLayoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener(){
            @Override
            public void onClick (View view,int position){
                final Item item = itemList.get(position);
                Toast.makeText(getApplicationContext(), item.getItemName() + " is selected!", Toast.LENGTH_SHORT).show();
                final String itemName = item.getItemName();
//                EditText amount = findViewById(R.id.amount);
//                Spinner spinner = findViewById(R.id.spinner);
//
//                final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                        spinner.getContext(),R.layout.spinner_item,item.getColors()){
//                    @Override
//                    public boolean isEnabled(int position){
//                        if(position == 0)
//                        {
//                            // Disable the first item from Spinner
//                            // First item will be use for hint
//                            return false;
//                        }
//                        else
//                        {
//                            return true;
//                        }
//                    }
//                    @Override
//                    public View getDropDownView(int position, View convertView,
//                                                ViewGroup parent) {
//                        View view = super.getDropDownView(position, convertView, parent);
//                        TextView tv = (TextView) view;
//                        if(position == 0){
//                            // Set the hint text color gray
//                            tv.setTextColor(Color.GRAY);
//                        }
//                        else {
//                            tv.setTextColor(Color.BLACK);
//                        }
//                        return view;
//                    }
//                };
//                spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
//                spinner.setAdapter(spinnerArrayAdapter);
//                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        String selectedItemText = (String) parent.getItemAtPosition(position);
//                        // If user change the default selection
//                        // First item is disable and it is used for hint
//                        if(position > 0){
//                            // Notify the selected item text
//                            Toast.makeText
//                                    (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
//                                    .show();
//                        }
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });
//
//
//                amount.addTextChangedListener(new EditTextWatcher(item));

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
