
package sample.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import phungnt.utils.DBUtil;

/**
 *
 * @author Phung Nguyen
 */
public class AccountDAO implements Serializable{
    public String checkLogin(String username, String password) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        ResultSet rs = null;
        String roleID = "failed";
        try {
          con = DBUtil.openConnection();
          if(con!=null){
              String sql = "SELECT roleID FROM tbl_Account WHERE accountID = ? AND password =? AND status = 'on' ";
              pStm = con.prepareStatement(sql);
              pStm.setString(1, username);
              pStm.setString(2, password);
              rs = pStm.executeQuery();
              if(rs.next()){
                  roleID = rs.getString("roleID");
              }
              
          }
            
        } 
        finally{
            if(rs!=null){
                rs.close();
            }
            if(pStm!=null){
                pStm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return roleID;
    }
    public AccountDTO findById(String accountID) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        ResultSet rs = null;
        AccountDTO dto = null;
        String id, password, fullName, address, phoneNumber, roleID, status;
        try {
            con =DBUtil.openConnection();
            if(con!=null){
                String sql = "SELECT  password, fullName, address, phoneNumber, roleID, status FROM tbl_Account WHERE accountID = ? ";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, accountID);
                rs = pStm.executeQuery();
                if(rs.next()){
                   password = rs.getString("password");
                   fullName = rs.getString("fullName");
                   address = rs.getString("address");
                   phoneNumber = rs.getString("phoneNumber");
                   roleID = rs.getString("roleID");
                   status = rs.getString("status");
                    dto = new AccountDTO(accountID, password, fullName, address, phoneNumber, roleID, status);
                    
                }
                
            }
        } 
        finally{
            if(rs!=null){
                rs.close();;
            }
            if(pStm!=null){
                pStm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return dto;
    }
    public boolean update(String id, String password, String fullName, String address, String phone) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "UPDATE tbl_Account SET password = ?, fullName = ?, address = ?, phoneNumber = ? WHERE accountID = ?";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, password);
                pStm.setString(2, fullName);
                pStm.setString(3, address);
                pStm.setString(4, phone);
                pStm.setString(5, id);
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
    public boolean updateStatus(String id) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "UPDATE tbl_Account SET status = ? WHERE accountID = ?";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, "off");
                pStm.setString(2, id);
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
        return  result;
        
    }
    public boolean insert(String accountID, String password, String fullName,String address, String phoneNumber) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result =false;
        try {
            con =DBUtil.openConnection();
            if(con!=null){
                String sql = "INSERT INTO tbl_Account VALUES(?,?,?,?,?,?,?)";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, accountID);
                pStm.setString(2, password);
                pStm.setString(3, fullName);
                pStm.setString(4, address);
                pStm.setString(5, phoneNumber);
                pStm.setString(6, "C" );
                pStm.setString(7, "on");
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
