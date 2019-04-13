
package phungnt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Phung Nguyen
 */
public class DBUtil implements Serializable{
    public static Connection openConnection() throws Exception{
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1456;databaseName = CocShop";
        con = DriverManager.getConnection(url,"sa","1911");
        
        return con;
    }
}
