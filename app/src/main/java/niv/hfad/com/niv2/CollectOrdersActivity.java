package niv.hfad.com.niv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CollectOrdersActivity extends Activity {

    OrdersSingleton ordersSingleton = OrdersSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_orders);
        TextView messageView = findViewById(R.id.message);
        messageView.setText(ordersSingleton.orderedItemsToString());

    }

    public void onSendMail(View view){
        String messageText = ordersSingleton.orderedItemsToString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String[] mails = {"info@nivjewelry.com"};
        EditText editText = findViewById(R.id.client_name_ET);
        String clientName = editText.getText().toString();
        intent.putExtra(Intent.EXTRA_EMAIL , mails);
        intent.putExtra(Intent.EXTRA_SUBJECT , "Order - " + clientName);
        String order = messageText + "\n" + "Client name : " + clientName;
        intent.putExtra(Intent.EXTRA_TEXT , order);
        startActivity(intent);
    }
}
