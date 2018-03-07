package niv.hfad.com.niv2;

import android.view.View;

/**
 * Created by yoav on 2/13/2018.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
