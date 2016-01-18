package beat.myfirstapp;

import android.os.HandlerThread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class DatabaseFuncties {

    private static String[] KrijgWebStringArray(String pagina, String splitter){
        String totaalString = NetwerkControl.LaadWebpagina(pagina);
        String[] totaalList = totaalString.split(splitter);
        return totaalList;
    }

    // vraag het percentage 'dat de gebruiker normaal is' op, zet om van string naar int

    /*public static void ZoekPercentage(final int gebruiker){
        Thread krijgpercentage = new Thread(new Runnable(){
            public void run (){
                DatabaseFuncties.KrijgNormaalPercentage(gebruiker);
            }
        });

        krijgpercentage.start();
    }*/

    // from http://stackoverflow.com/questions/9148899/returning-value-from-thread
    public static int ZoekPercentage(final int gebruiker)throws InterruptedException
    {
        final CountDownLatch latch = new CountDownLatch(1);
        final int[] percentage = new int[1];
        Thread krijgpercentage = new HandlerThread("UIHandler"){
            @Override
            public void run(){
                DatabaseFuncties.KrijgNormaalPercentage(gebruiker);
                percentage[0] = DatabaseFuncties.KrijgNormaalPercentage(gebruiker);
                latch.countDown(); // Release await() in the test thread.
            }
        };
        krijgpercentage.start();
        latch.await(); // Wait for countDown() in the UI thread. Or could uiThread.join();
        return percentage[0];
    }

    private static int KrijgNormaalPercentage(int gebruiker){

        String resultaatArray = NetwerkControl.LaadWebpagina("krijgnormaalpercentage.php?&user_id=" + gebruiker);
        int percentage = Integer.parseInt(resultaatArray);
        return percentage;
    }

    public static void KrijgVraag(int gebruiker, int vId, VraagControl vControl){

        String[] resultaatArray = KrijgWebStringArray("krijgvraag.php?question_id=" + vId + "&user_id=" + gebruiker, "~");


        // the order of elements is v_id, v_str, a_str, b_str, a_votes, b_votes, votes_up, votes_down, additional_info
        if (resultaatArray.length == 9 | resultaatArray.length == 8){
            // REMOVE "&& false" FROM THE STATEMENT BELOW TO GO OUT OF TESTING MODE
            if(Integer.parseInt(resultaatArray[0]) != vId && vId >= 0){
                vControl.VraagOpgezochtError("Wrong Question");

            }else{
                vControl.VraagOpgezocht(vId, resultaatArray[1], resultaatArray[2], resultaatArray[3]
                        , Integer.parseInt(resultaatArray[4]), Integer.parseInt(resultaatArray[5])
                        , Integer.parseInt(resultaatArray[6]), Integer.parseInt(resultaatArray[7]), "hier moet extra info");
            }

        }else{
            vControl.VraagOpgezochtError(resultaatArray[0]);
        }

    }
/*
    public static void KrijgComment(CommentControl cControl, int vraagid, int begin, int aantal){

        //String[] commentArray = KrijgWebStringArray("krijgcomment.php?question_id=" + vraagid + "&begin=" + begin + "&aantal=" + aantal, "~~");
        String comments = "id1~user1~text1~up1~down1~~id2~user2~text2~up2~down2~~id3~user3~text3~up3~down3";
        String[] commentArray = comments.split("~~");


        for (String lossecomment : commentArray) {
            String[] comment = lossecomment.split("~");
            // volgorde: vraagid, username, commenttext, upvotes, downvotes

            // REMOVE "|| true" FROM THE STATEMENT BELOW TO GO OUT OF TESTING MODE
            if (comment.length == 5 && Integer.parseInt(comment[0]) == vraagid || true) {
                cControl.AddComments(comment[0], comment[1], comment[2], comment[3], comment[4]);
            }else{
                cControl.VerminderComments();
            }
        }
    }
    */


    public static void VoteVraag(VraagControl vControl,int gebruiker, int vId, char answer, int poging){
        String result = NetwerkControl.LaadWebpagina("antwoordvraag.php?question_id=" + vId + "&user_id=" + gebruiker + "&answer=" + answer);

        if (result == "true"){
            vControl.VraagBeantwoord(true);
        }else {
            if (poging > 11){
                vControl.VraagBeantwoord(false);
            }else{
                VoteVraag(vControl, gebruiker, vId, answer, poging + 1);
            }
        }
    }

}
