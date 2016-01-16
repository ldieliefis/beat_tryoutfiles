package beat.myfirstapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class BeatPopup {
    public static void Help_Pages(final Context context, final int page){
        final AlertDialog.Builder popUp = new AlertDialog.Builder(context, R.style.BeaTPopUp);

        String[] Help_Titles = context.getResources().getStringArray(R.array.help_titles);
        String[] Help_Messages = context.getResources().getStringArray(R.array.help_messages);

        popUp
                .setTitle(Help_Titles[page])
                .setMessage(Help_Messages[page]);

        switch (page){
            case 0:
                popUp.setNeutralButton(R.string.help_sluit, MaakListener(context, page, 0));
                popUp.setPositiveButton(R.string.help_volgende, MaakListener(context, page, 1));
                break;
            case (6):
                popUp.setPositiveButton(R.string.help_sluit, MaakListener(context, page, 0));
                popUp.setNeutralButton(R.string.help_vorige, MaakListener(context, page, -1));
                break;
            default:
                popUp.setNeutralButton(R.string.help_vorige, MaakListener(context, page, -1));
                popUp.setNegativeButton(R.string.help_sluit, MaakListener(context, page, 0));
                popUp.setPositiveButton(R.string.help_volgende, MaakListener(context, page, 1));
                break;
        }
        popUp.show();
    }

    private static DialogInterface.OnClickListener MaakListener(final Context context, final int page, final int optie){
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
}
