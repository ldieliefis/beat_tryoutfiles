package beat.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultaatActivity extends AppCompatActivity {

    Button re;
    TextView tv;
    VraagControl nieuwevraag1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultaat);

        //Dan zie je de resultaatbutton niet meer
        //(findViewById(R.id.ButtonResultaat)).setVisibility(View.GONE);
        

        Intent intent = getIntent();
        String resultaat = intent.getStringExtra("gegevenAntwoord");

        TextView textView = (TextView)findViewById(R.id.Antwoord_A_Text);
        textView.setTextSize(40);
        textView.setText(resultaat);


        String percentage1 = intent.getStringExtra("AantalA");
        String percentage2 = intent.getStringExtra("AantalB");
        TextView TV1 = (TextView) findViewById(R.id.Antwoord_A_Percentage);
        TextView TV2 = (TextView) findViewById(R.id.Antwoord_B_Percentage);
        TV1.setText(""+percentage1 +"%");
        TV2.setText("" + percentage2 + "%");

        /*LinearLayout Antwoord_A_Bar = (LinearLayout)findViewById(R.id.Antwoord_A_Bar);
        LinearLayout.LayoutParams Antwoord_A_params = (LinearLayout.LayoutParams) Antwoord_A_Bar.getLayoutParams();
        Antwoord_A_params.weight = (float)nieuwevraag1.Antwoord_A_Percentage();
        Antwoord_A_Bar.setLayoutParams(Antwoord_A_params);

        LinearLayout Antwoord_B_Bar = (LinearLayout)findViewById(R.id.Antwoord_B_Bar);
        LinearLayout.LayoutParams Antwoord_B_params = (LinearLayout.LayoutParams) Antwoord_B_Bar.getLayoutParams();
        Antwoord_B_params.weight = (float)nieuwevraag1.Antwoord_B_Percentage();
        Antwoord_B_Bar.setLayoutParams(Antwoord_B_params);*/

        tv =(TextView)findViewById(R.id.Reacties_Button);

        scrollComments();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void ButtonVolgende(View view) {
        Intent intent = new Intent(this, VraagActivity.class);
        startActivity(intent);
    }
    public void ButtonBenIkNormaal (View view){
        //TODO button werkend maken
        Intent intentie = new Intent(this, BeniknormaalActivity.class);
        startActivity(intentie);
    }

    public void Reacties(View view){
        re = (Button)findViewById(R.id.Reacties_Button);
        re.setHeight(700);
    }

    private void scrollComments(){
        tv.setMovementMethod(new ScrollingMovementMethod());
        tv.setText("aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
                        + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg");

    }
}
