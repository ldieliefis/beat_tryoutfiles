package beat.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultaatActivity extends BeaTBaseActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultaat);

        //Dan zie je de resultaatbutton niet meer
        (findViewById(R.id.ButtonResultaat)).setVisibility(View.GONE);
        

        Intent intent = getIntent();
        String resultaat = intent.getStringExtra("gegevenAntwoord");

        TextView textView = (TextView)findViewById(R.id.antwoord_textview);
        textView.setTextSize(40);
        textView.setText(resultaat);


        String percentage1 = intent.getStringExtra("AantalA");
        String percentage2 = intent.getStringExtra("AantalB");
        TextView TV1 = (TextView) findViewById(R.id.textview1);
        TextView TV2 = (TextView) findViewById(R.id.textview2);
        TV1.setText(percentage1 +"%");
        TV2.setText(percentage2 +"%");

        tv =(TextView)findViewById(R.id.scrollViewReacties);

        scrollComments();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    public void ScrollViewReacties(View view){
        Button RB = (Button)findViewById(R.id.Reacties);


        RB.setText("Reacties");



    }

    public void Reacties(View view){
        tv.setHeight(700);
    }

    private void scrollComments(){

        tv.setMovementMethod(new ScrollingMovementMethod());

        tv.setText("aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg" + "\n" +"aldkg"
        );

    }
}
