package beat.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class VraagActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "beat.myfirstapp.MESSAGE";

    private int gebruiker = 1, vraagteller; //TODO vraagteller verwijderen!!
    private VraagControl nieuwevraag1, nieuwevraag2;

    // TODO ervoor zorgen dat als je op het pijltje terug klikt, je max 1x naar het vraagscherm gaat + naar een nieuwe vraag
    // TODO waar wordt de eerste thread gestopt? kan na iedere resultaatschermweergave een thread gestopt worden oid?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vraag);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //vraagteller = 0;
        /*
        if (savedInstanceState != null){
            nieuwevraag1 = new VraagControl(gebruiker, savedInstanceState.getInt("vId"));
        }else {
            nieuwevraag1 = new VraagControl(gebruiker, -1);
        }*/


        nieuwevraag1 = new VraagControl(gebruiker, -1);

        nieuwevraag2 = new VraagControl(gebruiker, -1);

        //vraagteller += 1;

        // zet de tekst (vraag) van de opgevraagde 'vraagcontrol' in de tekstview
        TextView textViewVraag = (TextView)findViewById(R.id.vraag_textview);
        textViewVraag.setTextSize(40);
        textViewVraag.setText(nieuwevraag1.Vraag_tekst());

        // zet de tekst (antwoord a) van de opgevraagde 'vraagcontrol' in de bovenste button
        Button buttona = (Button)findViewById(R.id.ButtonA);
        buttona.setTextSize(40);
        buttona.setText(nieuwevraag1.Antwoord_A_tekst());

        // zet de tekst (antwoord b) van de opgevraagde 'vraagcontrol' in de onderste button
        Button buttonb = (Button)findViewById(R.id.ButtonB);
        buttonb.setTextSize(40);
        buttonb.setText(nieuwevraag1.Antwoord_B_tekst());
    }


    @Override
    protected void onStart(){
        super.onStart();
        //TODO onStart() functie schrijven: deze wordt aangeroepen na onCreate en na onStop
/*
        nieuwevraag1 = nieuwevraag2;
        nieuwevraag2 = new VraagControl(gebruiker, vraagteller);
        vraagteller += 1;

        TextView textViewVraag = (TextView)findViewById(R.id.vraag_textview);
        textViewVraag.setTextSize(40);
        textViewVraag.setText(nieuwevraag1.Vraag_tekst());

        Button buttona = (Button)findViewById(R.id.ButtonA);
        buttona.setTextSize(40);
        buttona.setText(nieuwevraag1.Antwoord_A_tekst());

        Button buttonb = (Button)findViewById(R.id.ButtonB);
        buttonb.setTextSize(40);
        buttonb.setText(nieuwevraag1.Antwoord_B_tekst()); */
    }

    @Override
    protected void onPause(){
        super.onPause();
        // TODO onPause() functie schrijven: wordt aangeroepen als pop-up scherm/slide screen ed in beeld komen.
    }

    @Override
    protected void onStop(){
        super.onStop();
        //TODO onStop() functie schrijven; wordt aangeroepen als andere Activity in beeld komt en huidig programma dus niet meer zichtbaar is
    }

    @Override
    protected void onResume(){
        super.onResume();
        //TODO onResume() functie schrijven: wordt aangeroepen na onPause() hier ook de vraagteller enzo in??
    }


    public void ButtonAntwoord(View view) {
        Intent intent = new Intent(this, ResultaatActivity.class);
        Button knop = (Button)view;
        String antwoord = knop.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, antwoord);
        startActivity(intent);
    }

    public void ButtonBenIkNormaal (View view){
        //TODO button werkend maken
        Intent intentie = new Intent(this, BeniknormaalActivity.class);
        startActivity(intentie);
    }

    public  void ButtonVolgende(View view){
        //TODO buttonvolgende kopieren uit displayresultaatactivity
    }

    public void ButtonResultaat(View view){
        //TODO buttonresultaat
    }

    public void ButtonVote(View view){
        //TODO buttonvote
    }

    public void ButtonReport(View view){
        //TODO buttonreport
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
