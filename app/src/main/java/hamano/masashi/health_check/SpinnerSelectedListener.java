package hamano.masashi.health_check;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by masashihamano on 2018/03/08.
 */

public class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String selected = parent.getItemAtPosition(pos).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
