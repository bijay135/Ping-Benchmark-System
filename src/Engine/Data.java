package Engine;

public class Data {
    public static int counter = 0;
    public static long pingData[] = new long[121];
    
    // For Debugging
    /*
    public static void printData(){
        System.out.println("Ping "+counter+": "+pingData[counter]+"\n");
    }
    */
    
    public static void clearData(){
        counter = 0;
    }
}
