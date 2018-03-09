package hamano.masashi.health_check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BmrActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText height, weight ,age ;
    private TextView result;
    Button calBtn;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bmr );

        height = findViewById( R.id.height );
        weight = findViewById( R.id.weight );
        age = findViewById( R.id.age );
        result = findViewById( R.id.result );
        calBtn = findViewById( R.id.Tcalc );
        radioGroup = findViewById( R.id.gender );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "bmr" );

        calBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        String ageStr = age.getText().toString();

        if (heightStr != null && !"".equals( heightStr ) && weightStr != null && !"".equals( weightStr ) && ageStr != null && !"".equals( ageStr )) {

            final double heightValue = Double.parseDouble( heightStr );
            final double weightValue = Double.parseDouble( weightStr );

            final double ageValue = Double.parseDouble( ageStr );


            int text = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById( text );

            String person = radioButton.getText().toString();

            if (person.equals( "Male" )) {
                double bmr = 13.397 * weightValue + 4.799 * heightValue - 5.677 * ageValue + 88.362 ;
                displayTall( bmr );
            } else if (person.equals( "Female" )) {
                double bmr1 = 9.247 * weightValue + 3.098 * heightValue - 4.33 * ageValue + 447.593;
                displayTall1( bmr1 );
            }

            Intent intent = new Intent( BmrActivity.this, BmrResultActivity.class );
            intent.putExtra( "F", result.getText().toString() );
            startActivity( intent );

        }
        else
        {
            Toast.makeText( this, "Please fill both field", Toast.LENGTH_SHORT ).show();
        }

    }

    private void displayTall(double bmr) {

        String bmrLabel = "";

        bmrLabel = bmr + "\n" + " for male"+ bmrLabel ;

        result.setText( bmrLabel );

    }

    private void displayTall1(double bmr1) {

        String bmrLabel = "";

        bmrLabel = bmr1 + "\n" + " for female"+ bmrLabel;

        result.setText( bmrLabel );


    }

}
