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

public class BloodActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result;
    Button calBtn;
    RadioGroup radioGroup1, radioGroup2;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_blood );

        result = findViewById( R.id.result );
        calBtn = findViewById( R.id.calc );
        radioGroup1 = findViewById( R.id.fblood );
        radioGroup2 = findViewById( R.id.mblood );

        radioGroup1.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId != -1){
                    RadioButton radioButton = findViewById( checkedId );
                    String text = radioButton.getText().toString();

                }


            }
        } );

        Intent intent = getIntent();
        int position = intent.getExtras(  ).getInt( "blood" );

        calBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        int checkedId = radioGroup1.getCheckedRadioButtonId();

        if (checkedId != -1){
            RadioButton radioButton = findViewById( checkedId );
            String text = radioButton.getText().toString();

        }else{

        }




    }

    private void displayblood(String blood) {

        String bloodLabel = "";

        bloodLabel = blood + "\n" + " for male"+ bloodLabel ;

        result.setText( bloodLabel );

    }


}


