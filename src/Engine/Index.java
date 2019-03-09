package Engine;

public class Index {
    private static int score = 0;
    public static String d1,d2,d3,d4,d5,d6;

    public static int getScore() {
        return score;
    }
    
    public static void calculateScore(){
        if(Variance.getVariance() <=50){
            score = 10;
        }
        else if(Variance.getVariance()  > 50 && Variance.getVariance()  <= 150){
            score = 9;
        }
        else if(Variance.getVariance() > 150 && Variance.getVariance() <= 250){
            score = 8;
        }
        else if(Variance.getVariance() > 250 && Variance.getVariance() <= 350){
            score = 7;
        }
        else if(Variance.getVariance() > 350 && Variance.getVariance() <= 450){
            score = 6;
        }
        else if(Variance.getVariance() > 450 && Variance.getVariance() <= 550){
            score = 5;
        }
        else if(Variance.getVariance() > 550 && Variance.getVariance() <= 650){
            score = 4;
        }
        else if(Variance.getVariance() > 650 && Variance.getVariance() <= 750){
            score = 3;
        }
        else if(Variance.getVariance() > 750 && Variance.getVariance() <= 850){
            score = 2;
        }
        else{
            score = 1;
        }
    }
        
    public static void scoreDetails(){
        switch(score){
            case 10:
                d1 = "Your internet stability is ideal, your latency variation is ideally low";
                d2 = "\nExpect ideal latency in gaming, video calls, voice over network";
                d3 = "\nYou will also have ideal response time from websites and every web activities";
                
                d4 = "";
                d5 = "";
                d6 = "";
            break;
            case 9:
                d1 = "Your internet stability is excellent";
                d2 = "\nExpect excellent latency in gaming, video calls, voice over network";
                d3 = "\nYou will also have excellent response time from websites and every web activities";
                
                d4 = "\nYou will be free of lag, desync or packet loss during web activities";
                d5 = "\nSwitch to wired connection to improve stability further";
                d6 = "";
            break;
            case 8:
                d1= "Your internet stability is good";
                d2 = "\nExpect good latency in gaming, video calls, voice over network";
                d3 = "\nYou will also have good response time from websites and every web activities";
                
                d4 = "\nYou might get rare lag, desync or packet loss during web activities";
                d5 = "\nConsider moving closer to wifi signal or switching to wired connection";
                d6 = "";
            break;
            case 7:
                d1 = "Your internet stability is poor";
                d2 = "\nExpect poor latency in gaming, video calls, voice over network";
                d3 = "\nYou will also have poor response time from websites and every web activities";
                
                d4 = "\nYou will get occassional lag, desync or packet loss during web activities ";
                d5 = "\nTry reducing your network and user load to improve stability";
                d6 = "\nAlso, consider switching to wired connection to improve stability";
            break;
            case 6:
                d1 = "Your internet stability is poor";
                d2 ="\nExpect poor latency in gaming, video calls, voice over network";
                d3 ="\nYou will also have poor response time from websites and every web activities";
                
                d4 = "\nYou will get frequent lag, desync or packet loss during web activities";
                d5 = "\nCheck if your wifi signal is too low or you have massive network and user load";
                d6 = "\nAlso, consider switching to wired connection to improve stability";
            break;
            case 5:
                d1 = "Your internet stability is very poor";
                d2 = "\nExpect very poor latency in gaming, video calls, voice over network";
                d3 = "\nYou will also have very poor response time from websites and every web activities";
                
                d4= "\nYou will get semi-continuous lag, desync or packet loss during web activities ";
                d5 = "\nYour internet bandwidth is flooded, try rebooting router or reduce load";
                d6 = "\nMove closer to source if using wireless connection";
            break;
            case 4:
                d1 = "Your internet stability is very poor";
                d2 = "\nExpect very poor latency in gaming, video calls, voice over network";
                d3 = "\nYou will also have very poor response time from websites and every web activities";
                
                d4 = "\nYou will get continuous lag, desync or packet loss during web activities";
                d5 = "\nReduce your network and user load greatly to improve stability";
                d6 = "\nYou have too many network users consuing the bandwidth";
            break;
            case 3:
                d1 = "Your internet is unstable";
                d2 = "\nYour internet cannot handle gaming, video calls, voice over network smoothly";
                d3 = "\nYou will also have unusable response time from websites and every web activities";
                
                d4 = "nYou will be flooded with lag, desync or packet loss during web activities ";
                d5 = "\nYour internet connection is flooded with too many users";
                d6 = "\nConsider limiting users or reducing network load to improve stability";
            break;
            case 2:
                d1 = "Your internet is unstable";
                d2 = "\nYour internet cannot handle gaming, video calls, voice over network smoothly";
                d3 = "\nYou will also have unusable response time from websites and every web activities";
                
                d4 = "\nYou will be always flooded with lag, desync or packet loss during web activities";
                d5 = "\nYour internet connection is hung due to too mant requests";
                d6 = "\nTry rebooting router, reduce network and user load to improve stability";
            break;
            case 1:
                d1 = "Your internet is completely unstable, your latency is varying too much";
                d2 = "\nTry reducing network load, users load, moving closer to router or switching to wired";
                d3 = "\nIf nothing works consider changing your Internet Service Provider";
                
                d4 = "";
                d5 = "";
                d6 = "";
            break;
        }
    }
}
