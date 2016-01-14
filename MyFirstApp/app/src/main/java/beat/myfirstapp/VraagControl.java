package beat.myfirstapp;

import beat.myfirstapp.DatabaseFuncties;

public class VraagControl{

    private int vId;
    private String vTekst;
    private String aTekst;
    private String bTekst;
    private int aVotes;
    private int bVotes;
    //private CommentControl cControl;
    private int voteUp;
    private int voteDown;
    private String optional_info;
    private String error;
    private int gebruiker;
    private Boolean beantwoord;
    private Thread krijgvraag;

    VraagControl(int newgebruiker, int vraagid){
        beantwoord = null;
        error = "NoInfoGotten";
        gebruiker = newgebruiker;
        //cControl = new CommentControl(vId);

        vId = vraagid;

        MaakVraag();
    }

    private void MaakVraag(){
        final VraagControl thisVraagControl = this;

        krijgvraag = new Thread(new Runnable(){
            public void run (){
                DatabaseFuncties.KrijgVraag(gebruiker, vId, thisVraagControl);
            }
        });

        krijgvraag.start();

        //cControl.KrijgComments(1);
    }

    private void AntwoordVraag(char answer){
        final char finalanswer = answer;
        final VraagControl thisVraagControl = this;

        Thread antwoordvraag = new Thread(new Runnable(){
            public void run (){
                DatabaseFuncties.VoteVraag(thisVraagControl ,gebruiker, vId, finalanswer, 1);
            }
        });

        antwoordvraag.start();
    }

    public int Vraag_id(){
        return vId;
    }

    public String Vraag_tekst(){
        if(error == null){return vTekst;}
        else if(error == "Wrong Question") {return "an error occurred";}
        else if(error == "geen internet"){return "er is geen verbinding met internet?";}
        else {return "opgehaalde vraag:"+error;}
    }

    public String Antwoord_A_tekst(){
        return aTekst;
    }

    public String Antwoord_B_tekst(){
        return bTekst;
    }

    public int Antwoord_A_votes(){
        return aVotes;
    }

    public int Antwoord_B_votes(){
        return bVotes;
    }

    public int Antwoord_A_Percentage(){
        int percentage = (aVotes * 100) / (aVotes + bVotes);
        return percentage;
    }

    public int Antwoord_B_Percentage(){
        int percentage = (bVotes * 100) / (aVotes + bVotes);
        return percentage;
    }

    public int Votes_Up(){
        return voteUp;
    }

    public int Votes_Down(){
        return voteDown;
    }

    /*
    public CommentControl Comment_Control(){
        return cControl;
    }

    public String Comment_Top_tekst(){
        return cControl.ReturnComment(0, 2);
    }

    public String Comment_Top_Vote_Up(){
        return cControl.ReturnComment(0, 3);
    }

    public String Comment_Top_Vote_Down(){
        return cControl.ReturnComment(0, 4);
    }

    public String Comment_Top_User(){
        return cControl.ReturnComment(0, 1);
    }
*/

    public String Optional_Info(){
        return optional_info;
    }

    public String Error(){
        return error;
    }

    public boolean Beantwoord(){
        return beantwoord;
    }

    public void VraagOpgezocht(int v_id, String v_str, String a_str, String b_str, int a_votes, int b_votes, int votes_up, int votes_down, String additional_info){
        vId = v_id;
        vTekst = v_str;
        aTekst = a_str;
        bTekst = b_str;
        aVotes = a_votes;
        bVotes = b_votes;
        voteUp = votes_up;
        voteDown = votes_down;
        optional_info = additional_info;
        error = null;
        StopThread();
    }


    public void StopThread(){
        krijgvraag.interrupt();
    }


    public void VraagOpgezochtError(String reason){
        error = reason;
    }

    public void VraagBeantwoord(boolean succes){
        beantwoord = succes;
    }
}
