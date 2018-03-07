package niv.hfad.com.niv2;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by yoav on 2/14/2018.
 */

class EditTextWatcher implements TextWatcher {
    public Item item;
    EditTextWatcher(Item item) {
        this.item = item;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int i = 0;
        try{
            i = Integer.valueOf(s.toString());
        } catch (NumberFormatException e){
            System.out.println("");
        }
        item.setAmountToOrder(i);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
