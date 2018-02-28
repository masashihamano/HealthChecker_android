package hamano.masashi.health_check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class RohrerActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText height;
    private EditText weight;
    private TextView result;
    Button calBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_rohrer );

        height = findViewById( R.id.height );
        weight = findViewById( R.id.weight );
        result = findViewById( R.id.result );
        calBtn = findViewById( R.id.calc );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "roh" );

        calBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals( heightStr ) && weightStr != null && !"".equals( weightStr )) {
            float heightValue = Float.parseFloat( heightStr );
            float weightValue = Float.parseFloat( weightStr );
            float positiveValue3 = 3.0f;
            float positiveValue7 = 7.0f;
            float positiveValue10 = 10.0f;

            float roh = (float) (weightValue / Math.pow(heightValue,positiveValue3)* Math.pow( positiveValue10,positiveValue7 ));

            displayRohrer( roh );

//            BigDecimal bd = new BigDecimal(roh);
//            BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
//            bd2.doubleValue();


            Intent intent1 = new Intent( RohrerActivity.this, RohrerResultActivity.class );
            intent1.putExtra( "B", result.getText().toString() );
            startActivity( intent1 );

        }
    }

    private void displayRohrer(float roh) {

        String rohLabel = "";

        if (Float.compare( roh, 100f ) <= 0) {
            rohLabel = getString( R.string.severely_underweight );
        } else if (Float.compare( roh, 100f ) > 0 && Float.compare( roh, 115f ) <= 0) {
            rohLabel = getString( R.string.underweight );
        } else if (Float.compare( roh, 115f ) > 0 && Float.compare( roh, 145f ) <= 0) {
            rohLabel = getString( R.string.normal);
        } else if (Float.compare( roh, 145f ) > 0 && Float.compare( roh, 160f ) <= 0) {
            rohLabel = getString( R.string.overweight );
        } else {
            rohLabel = getString( R.string.obese_class_i );
        }

        rohLabel = roh + "\n\n" + rohLabel;

        result.setText( rohLabel );

    }
}
