package beat.myfirstapp;

        import android.content.Intent;
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

public class BeniknormaalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beniknormaal);

        Intent intent = getIntent();
        int gebruiker = intent.getIntExtra("gebruiker", 0);

        TextView textView = (TextView)findViewById(R.id.tekstvaktitel);
        textView.setTextSize(40);
        textView.setText("Ben jij normaal?");

        TextView textviewantwoord = (TextView)findViewById(R.id.tekstvakantwoord);
        textviewantwoord.setText("\n Nee, jij bent juist heel bijzonder! \nJij bent gebruiker nummer "+gebruiker);
    }

}
