package beat.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DisplayResultaatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_resultaat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String resultaat = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        TextView textView = (TextView)findViewById(R.id.antwoord_textview);
        textView.setTextSize(40);
        textView.setText(resultaat);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void ButtonVolgende(View view) {
        Intent intent = new Intent(this, MyActivity.class);

        startActivity(intent);
    }
    public void ButtonBenIkNormaal (View view){
        //TODO button werkend maken
        Intent intentie = new Intent(this, BeniknormaalActivity.class);
        startActivity(intentie);
    }
}
