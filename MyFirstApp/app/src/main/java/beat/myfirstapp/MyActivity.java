package beat.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "beat.myfirstapp.MESSAGE";

    private int gebruiker = 1;
    private VraagControl nieuwevraag1, nieuwevraag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null){
            nieuwevraag1 = new VraagControl(gebruiker, savedInstanceState.getInt("vId"));
        }else {
            nieuwevraag1 = new VraagControl(gebruiker, -1);
        }

        nieuwevraag2 = new VraagControl(gebruiker, -1);

        TextView textViewVraag = (TextView)findViewById(R.id.vraag_textview);
        textViewVraag.setTextSize(40);
        textViewVraag.setText(nieuwevraag1.Vraag_tekst());

        Button buttona = (Button)findViewById(R.id.ButtonA);
        buttona.setTextSize(40);
        buttona.setText(nieuwevraag1.Antwoord_A_tekst());

        Button buttonb = (Button)findViewById(R.id.ButtonB);
        buttonb.setTextSize(40);
        buttonb.setText(nieuwevraag1.Antwoord_B_tekst());
    }


    public void ButtonAntwoord(View view) {
        Intent intent = new Intent(this, DisplayResultaatActivity.class);
        Button knop = (Button)view;
        String antwoord = knop.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, antwoord);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
