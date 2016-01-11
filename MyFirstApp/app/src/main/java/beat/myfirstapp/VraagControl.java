package beat.myfirstapp;


public class VraagControl { //

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
    private Thread krijgvraag;

    VraagControl(int newgebruiker, int vraagid){
        error = "NoInfoGotten";
        gebruiker = newgebruiker;

        vId = vraagid;
/*
        vId = 5;

        //cControl = new CommentControl(vId);

        vTekst = "wat is de vraag?";
        aTekst = "antwoord a";
        bTekst = "antwoord b";
        aVotes = 12;
        bVotes = 20;
        voteUp = 4;
        voteDown = 1;
        optional_info = "opionele informatie";
        error = null;
*/
        MaakVraag();
    }

    private void MaakVraag(){
        final VraagControl thisVraagControl = this;
        //final CommentControl thisCommentControl = cControl;

        krijgvraag = new Thread(new Runnable(){
            public void run (){
                DatabaseFuncties.KrijgVraag(gebruiker, vId, thisVraagControl);
      //          thisCommentControl.KrijgComments(1);
            }
        });

        krijgvraag.start();
    }

    public int Vraag_id(){
        return vId;
    }

    public String Vraag_tekst(){ return vTekst; }

    public String Antwoord_A_tekst(){ return aTekst; }

    public String Antwoord_B_tekst(){ return bTekst; }

    public int Antwoord_A_votes(){
        return aVotes;
    }

    public int Antwoord_B_votes(){
        return bVotes;
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
    }*/

    public String Optional_Info(){
        return optional_info;
    }

    public String Error(){
        return error;
    }

    public void VraagOpgezocht(int v_id, String v_str, String a_str, String b_str, int a_votes, int b_votes, int votes_up, int votes_down, String additional_info){
        vId = v_id;
        vTekst = v_str;
        aTekst = a_str;
        bTekst = b_str;
        aVotes = a_votes;
        bVotes = a_votes;
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
}
