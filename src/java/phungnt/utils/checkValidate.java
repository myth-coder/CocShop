
package phungnt.utils;

/**
 *
 * @author Phung Nguyen
 */
public class checkValidate {
    
    public static boolean getPrice(String price){
        
        try {
            float n = Float.parseFloat(price);
            if(n>=0)
                return true;
        } 
        catch (Exception e) {
            return false;
        }
        return false;
    }
    public static boolean getInt(String price){
        
        try {
            int n = Integer.parseInt(price);
            if(n>=0)
                return true;
        } 
        catch (Exception e) {
            return false;
        }
        return false;
    }
}
