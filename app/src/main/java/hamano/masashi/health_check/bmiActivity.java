package hamano.masashi.health_check;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.xml.transform.Result;

import static android.media.MediaCodec.MetricsConstants.HEIGHT;

public class bmiActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText height;
    private EditText weight;
    private TextView result;
    Button calBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bmi );

        height = findViewById( R.id.height );
        weight = findViewById( R.id.weight );
        result = findViewById( R.id.result );
        calBtn = findViewById( R.id.calc );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "bmi" );

        calBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals( heightStr ) && weightStr != null && !"".equals( weightStr )){
            float heightValue = Float.parseFloat( heightStr )/100;
            float weightValue = Float.parseFloat( weightStr );

            float bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);

            Intent intent1 = new Intent( bmiActivity.this, Bmi_ResultActivity.class );
            intent1.putExtra( "A",result.getText().toString() );
            startActivity( intent1 );

        }
    }

    private void displayBMI(float bmi) {

        String bmiLabel = "";

        if (Float.compare( bmi, 15f ) <= 0) {
            bmiLabel = getString( R.string.very_severely_underweight );
        } else if (Float.compare( bmi, 15f ) > 0 && Float.compare( bmi, 16f ) <= 0) {
            bmiLabel = getString( R.string.severely_underweight );
        } else if (Float.compare( bmi, 16f ) > 0 && Float.compare( bmi, 18.5f ) <= 0) {
            bmiLabel = getString( R.string.underweight );
        } else if (Float.compare( bmi, 18.5f ) > 0 && Float.compare( bmi, 25f ) <= 0) {
            bmiLabel = getString( R.string.normal );
        } else if (Float.compare( bmi, 25f ) > 0 && Float.compare( bmi, 30f ) <= 0) {
            bmiLabel = getString( R.string.overweight );
        } else if (Float.compare( bmi, 30f ) > 0 && Float.compare( bmi, 35f ) <= 0) {
            bmiLabel = getString( R.string.obese_class_i );
        } else if (Float.compare( bmi, 35f ) > 0 && Float.compare( bmi, 40f ) <= 0) {
            bmiLabel = getString( R.string.obese_class_ii );
        } else {
            bmiLabel = getString( R.string.obese_class_iii );
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText( bmiLabel );

    }


}
