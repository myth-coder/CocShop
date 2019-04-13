
package sample.orderdetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import phungnt.utils.DBUtil;

/**
 *
 * @author Phung Nguyen
 */
public class OrderDetailDAO implements Serializable{
    public boolean insert(String id, String productID, int quantity, float price, float totalPrice, String orderID) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "INSERT INTO tbl_OrderDetail VALUES(?,?,?,?,?,?)";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, id);
                pStm.setString(2, productID);
                pStm.setInt(3, quantity);
                pStm.setFloat(4, price);
                pStm.setFloat(5, totalPrice);
                pStm.setString(6, orderID);
                result = pStm.executeUpdate() > 0;
            }
        } 
        finally{
            if(pStm!= null){
                pStm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return result;
        
    }
}
