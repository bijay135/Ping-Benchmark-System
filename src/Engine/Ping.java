package Engine;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;

public class Ping {
    private static boolean pingResult;

    public static boolean getPingResult() {
        return pingResult;
    }
   
    public static void startPing(String ip) throws UnknownHostException {
        InetAddress inet = InetAddress.getByName(ip);
        
        try {
            long currentTime = new GregorianCalendar().getTimeInMillis();
                    
            if(inet.isReachable(1500)){
                currentTime = new GregorianCalendar().getTimeInMillis()-currentTime;
                       
                Data.pingData[Data.counter] = currentTime;
                
                pingResult = true;
            }
            else{
                // System.out.println(ip+" timed out.\n"); For Debugging
                
                pingResult = false;
            }
        }       
        catch(Exception e) {
            e.printStackTrace();
            
            pingResult = false;
        } 
    }
}
