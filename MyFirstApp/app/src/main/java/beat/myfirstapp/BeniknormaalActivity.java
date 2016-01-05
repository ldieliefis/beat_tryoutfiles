package beat.myfirstapp;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

public class BeniknormaalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beniknormaal);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Intent intent = getIntent();
        //String resultaat = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        TextView textView = (TextView)findViewById(R.id.tekstvakje);
        //TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("ben je normaal?");
        //textView.setTextColor(255);



        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
