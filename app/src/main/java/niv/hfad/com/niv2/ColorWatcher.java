package niv.hfad.com.niv2;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by yoav on 2/15/2018.
 */

public class ColorWatcher implements TextWatcher {
    public Item item;
    ColorWatcher(Item item) {
        this.item = item;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        item.setColor(s.);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
