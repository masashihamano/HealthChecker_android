package hamano.masashi.health_check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class KaupActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText height;
    private EditText weight;
    private TextView result;
    Button calBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_kaup );

        height = findViewById( R.id.height );
        weight = findViewById( R.id.weight );
        result = findViewById( R.id.result );
        calBtn = findViewById( R.id.calc );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "kaup" );

        calBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals( heightStr ) && weightStr != null && !"".equals( weightStr )) {
            float heightValue = Float.parseFloat( heightStr );
            float weightValue = Float.parseFloat( weightStr );
            float positiveValue4 = 4.0f;
            float positiveValue10 = 10.0f;

            float kaup = (float) (weightValue / ( heightValue * heightValue) * Math.pow( positiveValue10, positiveValue4 ));

//            BigDecimal bd = new BigDecimal(kaup);
//            BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
//            bd2.doubleValue();

            displayKaup( kaup );

            Intent intent = new Intent( KaupActivity.this, KaupResultActivity.class );
            intent.putExtra( "C", result.getText().toString() );
            startActivity( intent );
        }
    }

    private void displayKaup(float kaup) {

        String kaupLabel = "";

        if (Float.compare( kaup, 13f ) <= 0) {
            kaupLabel = getString( R.string.severely_underweight );
        } else if (Float.compare( kaup, 13f ) > 0 && Float.compare( kaup, 15f ) <= 0) {
            kaupLabel = getString( R.string.underweight );
        } else if (Float.compare( kaup, 15f ) > 0 && Float.compare( kaup, 18f ) <= 0) {
            kaupLabel = getString( R.string.normal);
        } else if (Float.compare( kaup, 18f ) > 0 && Float.compare( kaup, 20f ) <= 0) {
            kaupLabel = getString( R.string.overweight );
        } else {
            kaupLabel = getString( R.string.obese_class_i );
        }

        kaupLabel = kaup + "\n\n" + kaupLabel;

        result.setText( kaupLabel );

    }


}
