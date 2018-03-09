package hamano.masashi.health_check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class BloodActivity extends AppCompatActivity implements View.OnClickListener {

    String[] bloodGroups;
    Spinner fathertype;
    Spinner mothertype;

    TextView aValue;
    TextView bValue;
    TextView abValue;
    TextView oValue;

    Button calBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_blood );

        aValue = (TextView) findViewById( R.id.typeavalue );
        bValue = (TextView) findViewById( R.id.typebvalue );
        abValue = (TextView) findViewById( R.id.typeabvalue );
        oValue = (TextView) findViewById( R.id.typeovalue );

        calBtn = findViewById( R.id.calc );
        calBtn.setOnClickListener( this );

        this.bloodGroups = new String[]{"A", "B", "AB", "O"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>( this, android.R.layout.simple_spinner_dropdown_item, bloodGroups );

        fathertype = (Spinner) findViewById( R.id.fathertype );
        fathertype.setAdapter( adapter );

        fathertype.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new GroupViewer( fathertype.getSelectedItemPosition(), mothertype.getSelectedItemPosition(), aValue, bValue, abValue, oValue ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


        mothertype = (Spinner) findViewById( R.id.mothertype );
        mothertype.setAdapter( adapter );

        mothertype.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new GroupViewer( fathertype.getSelectedItemPosition(), mothertype.getSelectedItemPosition(), aValue, bValue, abValue, oValue ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

        @Override
        public void onClick(View view) {

            fathertype.setOnItemSelectedListener(new SpinnerSelectedListener());
            mothertype.setOnItemSelectedListener(new SpinnerSelectedListener());

            Intent intent = new Intent(getApplicationContext(), BloodResultActivity.class );

            intent.putExtra( "A",aValue.getText().toString() );
            intent.putExtra( "B",bValue.getText().toString() );
            intent.putExtra( "AB",abValue.getText().toString() );
            intent.putExtra( "O",oValue.getText().toString() );

            startActivity( intent );
    }
}







