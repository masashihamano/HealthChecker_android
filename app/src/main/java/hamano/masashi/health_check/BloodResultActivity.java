package hamano.masashi.health_check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BloodResultActivity extends AppCompatActivity {

    TextView aValue;
    TextView bValue;
    TextView abValue;
    TextView oValue;

    private static final String TAG = "Second Action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_blood_result );

        aValue = (TextView) findViewById( R.id.typeavalue );
        bValue = (TextView) findViewById( R.id.typebvalue );
        abValue = (TextView) findViewById( R.id.typeabvalue );
        oValue = (TextView) findViewById( R.id.typeovalue );

        String a = getIntent().getStringExtra( "A" );
        String b = getIntent().getStringExtra( "B" );
        String ab = getIntent().getStringExtra( "AB" );
        String o = getIntent().getStringExtra( "O" );

        aValue.setText( a );
        bValue.setText( b );
        abValue.setText( ab );
        oValue.setText( o );

    }
}
