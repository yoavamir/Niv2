package niv.hfad.com.niv2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShowMenuActivity extends Activity {

    AtomicBoolean dataLoaded = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_menu);
        if (!dataLoaded.get())
            prepareData();
    }

    private void prepareData() {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("stock.xls");
            ReadExcel.fillStock(inputStream);
            dataLoaded.set(true);
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }


    public void onOpenNecklaces(View view) {
        Intent intent = new Intent(this, NecklacesActivity.class);
        startActivity(intent);
    }


    public void onOpenBracelets(View view) {
        Intent intent = new Intent(this, BraceletsActivity.class);
        startActivity(intent);
    }

    public void onOpenEarrings(View view) {
        Intent intent = new Intent(this, EarringsActivity.class);
        startActivity(intent);
    }

    public void onOpenOrders(View view) {
        Intent intent = new Intent(this, CollectOrdersActivity.class);
        startActivity(intent);

    }

}
