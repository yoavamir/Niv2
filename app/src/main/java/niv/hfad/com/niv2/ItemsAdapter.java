package niv.hfad.com.niv2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yoav on 2/13/2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private ArrayList<Item> itemList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemName , wholesale , retail;
        EditText amount;
        Spinner spinner;
        ImageView imageView;
        MyViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.itemName);
            retail = view.findViewById(R.id.retail);
            wholesale = view.findViewById(R.id.wholesale);
            amount = view.findViewById(R.id.amount);
            spinner = view.findViewById(R.id.spinner);
            imageView = view.findViewById(R.id.imageView);
        }
    }


    ItemsAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.example, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Item item = itemList.get(position);
        Resources resources = holder.imageView.getResources();
        final int resourceId = resources.getIdentifier(item.getItemName().toLowerCase(), "drawable",
                holder.imageView.getContext().getPackageName());
        holder.imageView.setImageResource(resourceId);
        holder.itemName.setText(String.format("Item name : %s" , item.getItemName()));
        holder.retail.setText(String.format("Retail price : %s" , String.valueOf(item.getRetail())));
        holder.wholesale.setText(String.format("Wholesale price : %s" , String.valueOf(item.getWholesale())));
        holder.amount.addTextChangedListener(new EditTextWatcher(item));
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                holder.spinner.getContext(),R.layout.spinner_item,item.getColors()){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        holder.spinner.setAdapter(spinnerArrayAdapter);
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                item.setColor(selectedItemText);
//                // If user change the default selection
//                // First item is disable and it is used for hint
//                if(position > 0){
//                    // Notify the selected item text
//                    Toast.makeText
//                            (this, "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
//                            .show();
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        holder.spinner.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
