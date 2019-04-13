
package sample.orders;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import phungnt.utils.DBUtil;

/**
 *
 * @author Phung Nguyen
 */
public class OrderDAO implements Serializable{
    public  boolean insert(String OrderId, float totalPrice,  String accountID, String address, String phoneNumber) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "INSERT INTO tbl_Order VALUES(?,?,?,?,?,?)";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, OrderId);
                pStm.setFloat(2, totalPrice);
                pStm.setString(3, accountID);
                 pStm.setString(4, address);
                  pStm.setString(5, phoneNumber);
                  pStm.setString(6, "available");
                result = pStm.executeUpdate() > 0;
            }
        } 
        finally{
            if(pStm!=null){
                pStm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return result;
    }
}
