
package sample.product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phungnt.utils.DBUtil;

/**
 *
 * @author Phung Nguyen
 */
public class ProductDAO  implements Serializable{
    public List<ProductDTO> searchFoodByName(String search) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        ResultSet rs = null;
        List<ProductDTO> result = null;
        String productID, name, brand,  status, type;
        float price;
        int quantity;
        try {
            con =DBUtil.openConnection();
            if(con!=null){
                String sql = "SELECT productID, name, brand, price, quantity, status, type FROM tbl_Product WHERE name LIKE ?";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, "%" + search + "%");
                rs = pStm.executeQuery();
                result = new ArrayList<>();
                
                
                while(rs.next()){
                    productID = rs.getString("productID");
                    name = rs.getString("name");
                    brand = rs.getString("brand");
                    price = rs.getFloat("price");
                    quantity = rs.getInt("quantity");
                    status = rs.getString("status");
                    type = rs.getString("type");
                    result.add(new ProductDTO(productID, name, brand, price, quantity, status, type));
                    
                    
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
        return result;
        
        
    }
    public boolean updateStatus(String id) throws Exception{
        Connection con = null; 
        PreparedStatement pStm = null;
    
        boolean result  = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "UPDATE tbl_Product SET status = ? WHERE productID = ?";
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
      return result;  
        
    }
    public ProductDTO findById(String id) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        ResultSet rs = null;
        ProductDTO dto = null;
        String name, brand,  status, type;
        float price;
        int quantity ;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "SELECT  name, brand, price, quantity, status, type FROM tbl_Product WHERE productID = ? ";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, id);
                rs = pStm.executeQuery();
                if(rs.next()){
                    name = rs.getString("name");
                    brand = rs.getString("brand");
                    price =rs.getFloat("price");
                    quantity =  rs.getInt("quantity");
                    status = rs.getString("status");
                    type = rs.getString("type");
                    dto = new  ProductDTO(id, name, brand, price, quantity, status, type);
                    
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
        return dto;
        
                
    }
    
    public boolean updateById(String id, String name, String brand, float price, int quantity, String status, String type) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!= null){
                String sql  ="UPDATE tbl_Product SET name = ?, brand = ?, price = ?, quantity = ?, status = ?, type = ? WHERE productID = ?";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, name);
                pStm.setString(2, brand);
                pStm.setFloat(3, price);
                pStm.setInt(4, quantity);
                pStm.setString(5, status);
                pStm.setString(6, type);
                pStm.setString(7, id);
                result = pStm.executeUpdate() >0;
                
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
    public List<ProductDTO> searchByPrice(float min, float max) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        ResultSet rs = null;
        String id,name, brand, type , status;
        float price ;
        int quantity;
        List<ProductDTO> result = new ArrayList();
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "SELECT productID, name, brand, price, quantity, status, type FROM tbl_Product WHERE ?<=price AND price<=? AND status = ? AND type != ? ";
                        
                pStm = con.prepareStatement(sql);
                pStm.setString(1, String.valueOf(min));
                pStm.setString(2, String.valueOf(max));
                pStm.setString(3, "on");
                pStm.setString(4, "G");
                rs = pStm.executeQuery();
                while(rs.next()){
                    id = rs.getString("productID");
                    name = rs.getString("name");
                    brand = rs.getString("brand");
                    price = rs.getFloat("price");
                    quantity = rs.getInt("quantity");
                    status = rs.getString("status");
                    type = rs.getString("type");
                    result.add(new ProductDTO(id, name, brand, price, quantity, status, type));
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
       return result; 
    }
    public boolean insert(String id, String name, String brand, String price, String quantity, String status, String type) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "INSERT INTO tbl_Product VALUES(?,?,?,?,?,?,?)";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, id);
                pStm.setString(2, name);
                pStm.setString(3, brand);
                pStm.setFloat(4, Float.parseFloat(price));
                pStm.setInt(5, Integer.parseInt(quantity));
                pStm.setString(6, status);
                pStm.setString(7, type);
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
    public boolean  downQuantity(String id, int quantity) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "UPDATE tbl_Product SET quantity = ? WHERE productID = ?";
                pStm = con.prepareStatement(sql);
                pStm.setInt(1, quantity - 1);
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
    public boolean upQuantity(String id, int quantity) throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        boolean result = false;
        try {
            con = DBUtil.openConnection();
            if(con!=null){
                String sql = "UPDATE tbl_Product SET quantity = quantity + ? WHERE productID = ?";
                pStm = con.prepareStatement(sql);
                pStm.setInt(1, quantity);
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
    public List<ProductDTO> loadListGift() throws Exception{
        Connection con = null;
        PreparedStatement pStm = null;
        ResultSet rs = null;
        List<ProductDTO> listGift = null;
        String id, name, brand;
        int quantity;
        float price;
        try {
            con =DBUtil.openConnection();
            if(con!=null){
                String sql = "SELECT productID,name,brand,price,quantity FROM tbl_Product WHERE status = ? AND type = ? AND quantity >0";
                pStm = con.prepareStatement(sql);
                pStm.setString(1, "on");
                pStm.setString(2, "G");
                rs = pStm.executeQuery();
                listGift = new ArrayList<>();
                while(rs.next()){
                    id = rs.getString("productID");
                    name = rs.getString("name");
                    brand = rs.getString("brand");
                    quantity = rs.getInt("quantity");
                    price = rs.getFloat("price");
                    listGift.add(new ProductDTO(id, name, brand, price, quantity, "on", "G"));
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
           
        return  listGift;
                
    }
    
}
