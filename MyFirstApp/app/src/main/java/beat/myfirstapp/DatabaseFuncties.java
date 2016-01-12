package beat.myfirstapp;

import java.util.Random;

public class DatabaseFuncties {

    int vTeller = 0;
/*
    private static String[] KrijgWebStringArray(String pagina, String splitter){
        String totaalString = NetwerkControl.LaadWebpagina(pagina);
        String[] totaalList = totaalString.split(splitter);
        return totaalList;
    }
*/
    public static void KrijgVraag(int gebruiker, int vId, VraagControl vControl){

        // REMOVE "//" IN NEXT LINE TO GO OUT OF TESTING MODE
        //String[] resultaatArray = KrijgWebStringArray("krijgvraag.php?question_id=" + vId + "&user_id=" + gebruiker, "~");

        Random rand = new Random();
        int vraagnummer = rand.nextInt(4);

        // REMOVE NEXT TO LINES TO GO OUT OF TESTING MODE, ALSO LOOK IN THE IF STATEMENT BELOW
        String test;
        switch (vraagnummer){
            // the order of elements is v_id, v_str, a_str, b_str, a_votes, b_votes, votes_up, votes_down, additional_info
            case 0:
                test = "1~Ben je meer een kattenmens of meer een hondenmens?~Kat~Hond~1~2~3~4~";
                break;
            case 1:
                test = "2~Maak je een mug of een olifant?~Mug~Olifant~1~2~3~4~";
                break;
            case 2:
                test = "3~Forever alone en je geliefde altijd gelukkig of samen met je geliefde, maar je geliefde is ongelukkig?~Jij gelukkig~Je geliefde gelukkig~1~2~3~4~";
                break;
            case 3:
                test = "4~Roze en blauw of groen en geel?~Roze en blauw~Groen en geel~1~2~3~4~";
                break;
            default:

                test = "0~vraag~antwoord A~Antwoord B~1~2~3~4~Extra informatie";
        }

        String[] resultaatArray = test.split("~");

        if (resultaatArray.length == 8){
            resultaatArray = new String[]{resultaatArray[0], resultaatArray[1], resultaatArray[2], resultaatArray[3]
                    , resultaatArray[4], resultaatArray[5], resultaatArray[6], resultaatArray[7], null};
        }

        // the order of elements is v_id, v_str, a_str, b_str, a_votes, b_votes, votes_up, votes_down, additional_info

        if (resultaatArray.length == 9){
            // REMOVE "&& false" FROM THE STATEMENT BELOW TO GO OUT OF TESTING MODE
            if(Integer.parseInt(resultaatArray[0]) != vId && vId >= 0 && false){
                vControl.VraagOpgezochtError("Wrong Question");

            }else{
                vControl.VraagOpgezocht(vId, resultaatArray[1], resultaatArray[2], resultaatArray[3]
                        , Integer.parseInt(resultaatArray[4]), Integer.parseInt(resultaatArray[5])
                        , Integer.parseInt(resultaatArray[6]), Integer.parseInt(resultaatArray[7]), resultaatArray[8]);
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

    public static void VoteVraag(int gebruiker, int vId, char vote){
        NetwerkControl.LaadWebpagina("votevraag.php?question_id=" + vId + "&user_id=" + gebruiker + "&vote=" + vote);
    }
    */
}