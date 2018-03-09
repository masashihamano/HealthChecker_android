package hamano.masashi.health_check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmrResultActivity extends AppCompatActivity {

    private static final String TAG = "Second Action";
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bmr_result );

        result = findViewById( R.id.result );

        String f = getIntent().getStringExtra( "F" );
        result.setText( f );
    }
}
