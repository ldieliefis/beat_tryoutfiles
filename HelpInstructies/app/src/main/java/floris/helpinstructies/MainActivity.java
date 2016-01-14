package floris.helpinstructies;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void HelpPopUp1(final View view)  {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this,R.style.AlertDialogStijl);
        myAlert.setMessage(R.string.helpcontent1).setNeutralButton(R.string.sluit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}});
        myAlert.setPositiveButton(R.string.volgende, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp2(view);}})
                .setTitle(R.string.helptitel1);
        myAlert.show();
    }

    public void HelpPopUp2(final View view)  {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this,R.style.AlertDialogStijl);
        myAlert.setMessage(R.string.helpcontent2).setPositiveButton(R.string.volgende, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp3(view);}});
        myAlert.setNeutralButton(R.string.vorige, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp1(view);}});
        myAlert.setNegativeButton(R.string.sluit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}})
                .setTitle(R.string.helptitel2);
        myAlert.show();
    }
    public void HelpPopUp3(final View view)  {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this, R.style.AlertDialogStijl);
        myAlert.setMessage(R.string.helpcontent3).setPositiveButton(R.string.volgende, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp4(view);}});
        myAlert.setNeutralButton(R.string.vorige, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp2(view);}});
        myAlert.setNegativeButton(R.string.sluit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}})
                .setTitle(R.string.helptitel3);
        myAlert.show();
    }
    public void HelpPopUp4(final View view)  {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this, R.style.AlertDialogStijl);
        myAlert.setMessage(R.string.helpcontent4).setPositiveButton(R.string.volgende, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp5(view);}});
        myAlert.setNeutralButton(R.string.vorige, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp3(view);}});
        myAlert.setNegativeButton(R.string.sluit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}})
                .setTitle(R.string.helptitel4);
        myAlert.show();
    }
    public void HelpPopUp5(final View view)  {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this, R.style.AlertDialogStijl);
        myAlert.setMessage(R.string.helpcontent5).setPositiveButton(R.string.volgende, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp6(view);}});
        myAlert.setNeutralButton(R.string.vorige, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp4(view);}});
        myAlert.setNegativeButton(R.string.sluit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}})
                .setTitle(R.string.helptitel5);
        myAlert.show();
    }
    public void HelpPopUp6(final View view)  {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this, R.style.AlertDialogStijl);
        myAlert.setMessage(R.string.helpcontent6).setPositiveButton(R.string.volgende, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp7(view);}});
        myAlert.setNeutralButton(R.string.vorige, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp5(view);}});
        myAlert.setNegativeButton(R.string.sluit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}})
                .setTitle(R.string.helptitel6);
        myAlert.show();
    }
    public void HelpPopUp7(final View view)  {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this, R.style.AlertDialogStijl);
        myAlert.setMessage(R.string.helpcontent7).setPositiveButton(R.string.sluit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}});
        myAlert.setNeutralButton(R.string.vorige, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {HelpPopUp6(view);} })
                .setTitle(R.string.helptitel7);
        myAlert.show();
    }
}



