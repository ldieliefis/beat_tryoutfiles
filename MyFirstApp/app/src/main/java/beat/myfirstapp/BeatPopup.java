package beat.myfirstapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class BeatPopup {
    public static void Help_Pages(final Context context, final int page){
        final AlertDialog.Builder popUp = new AlertDialog.Builder(context, R.style.BeaTTheme_PopUp);

        String[] Help_Titles = context.getResources().getStringArray(R.array.help_titles);
        String[] Help_Messages = context.getResources().getStringArray(R.array.help_messages);

        popUp
                .setIcon(R.drawable.logo_klein)
                .setTitle(Help_Titles[page])
                .setMessage(Help_Messages[page])
                .setNeutralButton(R.string.help_vorige, MaakHelpListener(context, page, -1))
                .setNegativeButton(R.string.help_sluit, MaakHelpListener(context, page, 0))
                .setPositiveButton(R.string.help_volgende, MaakHelpListener(context, page, 1));

        if(page == 0){
            popUp.setNeutralButton(R.string.help_sluit, MaakHelpListener(context, page, 0));
            popUp.setNegativeButton(null, null);
        }
        if(page == Help_Titles.length-1){
            popUp.setPositiveButton(null, null);
        }

        popUp.show();
    }

    private static DialogInterface.OnClickListener MaakHelpListener(final Context context, final int page, final int optie){
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (optie != 0){
                    Help_Pages(context, page + optie);
                }
            }
        };
        return listener;
    }

    public static void Credits(final Context context){

        AlertDialog.Builder credits = new AlertDialog.Builder(context, R.style.BeaTTheme_PopUp);
        credits
                .setIcon(R.drawable.logo_klein)
                .setTitle(R.string.credits_title)
                .setMessage(R.string.credits_message)
                .setPositiveButton(R.string.credits_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        credits.show();
    }
}
