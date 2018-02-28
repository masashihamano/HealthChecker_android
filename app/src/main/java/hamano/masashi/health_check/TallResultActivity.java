package hamano.masashi.health_check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TallResultActivity extends AppCompatActivity {

    private static final String TAG = "Second Action";
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tall_result );

        result = findViewById( R.id.result );

        String d = getIntent().getStringExtra( "D" );
        result.setText( d );

    }
}
