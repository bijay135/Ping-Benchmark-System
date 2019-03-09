package Engine;
 
public class Variance {
    private static double X = 0;
    private static double mean = 0; 
    private static double X2 = 0;
    private static double standardDeviation = 0;
    private static double decimalVariance = 0;
    private static int variance = 0;

    public static int getVariance() {
        return variance;
    }
    
    public static void clearVariance(){
        X = 0;
        mean = 0; 
        X2 = 0;
        standardDeviation = 0;
        decimalVariance = 0;
        variance = 0;
    }
    
    public static void calculateVariance(){
        if(Data.counter == 120){
            X+=Data.pingData[Data.counter];
            X2+=Math.pow((Data.pingData[Data.counter]),2);
            
            mean=X/120;
            standardDeviation=Math.sqrt((X2/120)-(Math.pow((mean),2)));
            
            decimalVariance=(standardDeviation/mean)*1000;
            variance = (int) decimalVariance;
        }
        else{
            X+=Data.pingData[Data.counter];
            X2+=Math.pow((Data.pingData[Data.counter]),2);
        }
    }
}
