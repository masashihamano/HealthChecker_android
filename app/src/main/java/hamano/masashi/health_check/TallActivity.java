package hamano.masashi.health_check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TallActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText fheight;
    private EditText mheight;
    private TextView result;
    Button calBtn;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tall );

        fheight = findViewById( R.id.Tfheight );
        mheight = findViewById( R.id.Tmheight );
        result = findViewById( R.id.result );
        calBtn = findViewById( R.id.Tcalc );
        radioGroup = findViewById( R.id.gender );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "tall" );


        calBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String fheightStr = fheight.getText().toString();
        String mheightStr = mheight.getText().toString();

        if (fheightStr != null && !"".equals( fheightStr ) && mheightStr != null && !"".equals( mheightStr )) {

            final double fheightValue = Double.parseDouble( fheightStr );
            final double mheightValue = Double.parseDouble( mheightStr );

            int text = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById( text );

           String person = radioButton.getText().toString();

           if(person.equals( "Boy" ))
           {
               double tall = (fheightValue + mheightValue + 13) / 2+2;
                            displayTall( tall );
           }
           else if(person.equals( "Girl" ))
           {
               double tall1 = (fheightValue + mheightValue - 13) / 2+2;
               displayTall1( tall1 );
           }

//
//            radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup radioGroup, int checked) {
//
//                    switch(checked ){
//                        case R.id.male:
//                            double tall = (fheightValue + mheightValue + 13) / 2+2;
//                            displayTall( tall );
//                        break;
//
//                        case R.id.female:
//                            double tall1 = (fheightValue + mheightValue - 13) / 2+2;
//                            displayTall1( tall1 );
//                        break;
//
//                    }
//
//                }
//            } );
//
            Intent intent = new Intent( TallActivity.this, TallResultActivity.class );
            intent.putExtra( "D", result.getText().toString() );
            startActivity( intent );

        }
        else
        {
            Toast.makeText( this, "Please fill both field", Toast.LENGTH_SHORT ).show();
        }

    }

    private void displayTall(double tall) {

        String tallLabel = "";

        tallLabel = tall + "\n" + " for male"+ tallLabel ;

        result.setText( tallLabel );

    }

    private void displayTall1(double tall1) {

        String tallLabel = "";

        tallLabel = tall1 + "\n" + " for female"+ tallLabel;

        result.setText( tallLabel );


    }


}


