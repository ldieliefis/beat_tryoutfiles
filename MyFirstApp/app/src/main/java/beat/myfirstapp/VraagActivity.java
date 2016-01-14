package beat.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VraagActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "beat.myfirstapp.MESSAGE";

    private int gebruiker = 1;
    private VraagControl nieuwevraag1, nieuwevraag2;

    // TODO ervoor zorgen dat als je op het pijltje terug klikt, je max 1x naar het vraagscherm gaat + naar een nieuwe vraag
    // TODO waar wordt de eerste thread gestopt? kan na iedere resultaatschermweergave een thread gestopt worden oid?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vraag);

        (findViewById(R.id.ButtonResultaat)).setVisibility(View.VISIBLE);

        /*
        if (savedInstanceState != null){
            nieuwevraag1 = new VraagControl(gebruiker, savedInstanceState.getInt("vId"));
        }else {
            nieuwevraag1 = new VraagControl(gebruiker, -1);
        }*/


        nieuwevraag1 = new VraagControl(gebruiker, -1);

        nieuwevraag2 = new VraagControl(gebruiker, -1);

        while(nieuwevraag1.Error()=="NoInfoGotten"){}

        // zet de tekst (vraag) van de opgevraagde 'vraagcontrol' in de tekstview
        TextView textViewVraag = (TextView)findViewById(R.id.vraag_textview);
        //textViewVraag.setTextSize(40);
        textViewVraag.setText(nieuwevraag1.Vraag_tekst());

        // zet de tekst (antwoord a) van de opgevraagde 'vraagcontrol' in de bovenste button
        Button buttona = (Button)findViewById(R.id.ButtonA);
        //buttona.setTextSize(40);
        buttona.setText(nieuwevraag1.Antwoord_A_tekst());

        // zet de tekst (antwoord b) van de opgevraagde 'vraagcontrol' in de onderste button
        Button buttonb = (Button)findViewById(R.id.ButtonB);
        //buttonb.setTextSize(40);
        buttonb.setText(nieuwevraag1.Antwoord_B_tekst());
    }

    @Override
    protected void onResume(){
        super.onResume();

        
    }

    public void ButtonAntwoord(View view) {
        Intent intent = new Intent(this, ResultaatActivity.class);
        Button knop = (Button)view;
        String antwoord = knop.getText().toString();
        intent.putExtra("gegevenAntwoord", antwoord);

        String aantalA = (""+20/*nieuwevraag1.a_Votes*/);
        intent.putExtra("AantalA",aantalA);

        String aantalB = (""+80/*nieuwevraag1.b_Votes*/);
        intent.putExtra("AantalB", aantalB);

        startActivity(intent);
    }

    public void ButtonBenIkNormaal (View view){
        //TODO beniknormaalpagina ontwikkelen!
        Intent intentie = new Intent(this, BeniknormaalActivity.class);
        startActivity(intentie);
    }

    public  void ButtonVolgende(View view){
        //TODO buttonvolgende kopieren uit displayresultaatactivity
        //IPV het kopieren en plakken (en dus code 2 keer gebruiken) zet anders deze hele methode in BeaTBaseActivity
        //Hierdoor hoef je deze hele methode niet in beide methodes te zetten
        //WARNING: er is een kans dat hij dan niet meer goed door linkt vanuit de xml, maar ik verwacht dat hij dat nu ook al niet doet als je ze in twee activities bepaalt
        //Voor meer info vraag mij (Brian)

        nieuwevraag1 = new VraagControl(gebruiker, -1);
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

}
