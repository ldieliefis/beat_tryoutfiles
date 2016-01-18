package beat.myfirstapp;

        import android.content.Intent;
        import android.content.res.Resources;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import org.w3c.dom.Text;

public class BeniknormaalActivity extends BeaTBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beniknormaal);

        Intent intent = getIntent();
        //int gebruiker = intent.getIntExtra("gebruiker", 0);
        int gebruiker = 2;
        int normaalpercentage;

        // vindt het percentage 'gekheid' van de gebruiker
        try{
            normaalpercentage = DatabaseFuncties.ZoekPercentage(gebruiker);

            setInhoud(normaalpercentage);
        }
        catch(Exception e){
            TextView textviewantwoord = (TextView)findViewById(R.id.tekstvakantwoord);
            textviewantwoord.setText("\n Helaas, er is iets mis gegaan! \n Probeer het later opnieuw.");}

    }

    private void setInhoud(int percentage){
        TextView textviewantwoord = (TextView)findViewById(R.id.tekstvakantwoord);

        // de tekst in het scherm hangt af van je score. deze is nu nog beperkt, maar kan gemakkelijk worden uitgebreid.
        switch(Math.round(percentage / 10)){
            case 1:
                textviewantwoord.setText(R.string.percentage0_10);
                break;
            case 2:
                textviewantwoord.setText(R.string.percentage11_50);
                break;
            case 3:
                textviewantwoord.setText(R.string.percentage11_50);
                break;
            case 4:
                textviewantwoord.setText(R.string.percentage11_50);
                break;
            case 5:
                textviewantwoord.setText(R.string.percentage11_50);
                break;
            case 6:
                textviewantwoord.setText(R.string.percentage51_90);
                break;
            case 7:
                textviewantwoord.setText(R.string.percentage51_90);
                break;
            case 8:
                textviewantwoord.setText(R.string.percentage51_90);
                break;
            case 9:
                textviewantwoord.setText(R.string.percentage51_90);
                break;
            case 10:
                textviewantwoord.setText(R.string.percentage91_100);
                break;
        }
        // vindt de vakken die je wilt aanpassen en past breedte aan percentage aan(weight wordt percentage)
        LinearLayout linkerbalk = (LinearLayout)findViewById(R.id.percentagebalk_links);
        LinearLayout.LayoutParams linkerbalk_params = (LinearLayout.LayoutParams) linkerbalk.getLayoutParams();
        LinearLayout rechterbalk = (LinearLayout)findViewById(R.id.percentagebalk_rechts);
        LinearLayout.LayoutParams rechterbalk_params = (LinearLayout.LayoutParams) rechterbalk.getLayoutParams();

        // zet altijd de je eigen score links
            linkerbalk_params.weight = percentage;
            linkerbalk.setLayoutParams(linkerbalk_params);
            rechterbalk_params.weight = 100 - percentage;
            rechterbalk.setLayoutParams(rechterbalk_params);

        TextView legenda_jouw_score = (TextView)findViewById(R.id.legenda_tekst_jouw_score);
        legenda_jouw_score.setText("Jij wijkt voor " + percentage + "% af van de meerderheid");
        TextView legenda_overigen = (TextView)findViewById(R.id.legenda_tekst_overigen);
        legenda_overigen.setText("Jij lijkt voor " + (100-percentage) + "% op de gemiddelde mens");

    }
}
