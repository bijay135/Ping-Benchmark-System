package Engine;

import java.net.InetAddress;

public class Server {
    private static final String s1 = "google.com";
    private static final String s2 = "youtube.com";
    private static final String s3 = "gmail.com";
    private static String selectedServer;
    private static boolean reachableResult;
    
    public static String getSelectedServer() {
        return selectedServer;
    }
  
    public static void serverChoice(int value){
        switch(value){
            case 1:
                selectedServer = s1;
            break;
            case 2:
                selectedServer = s2;
            break;
            case 3:
                selectedServer = s3;
            break;
        } 
    }
    
    public static boolean isReachable(){
        try {
            if(InetAddress.getByName(selectedServer).isReachable(1500)){
                reachableResult = true;
            }
            else{
                reachableResult = false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return reachableResult;
    }
}
