package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class conn {
    public static Connection Connect() {
        try {
            String url = "jdbc:mysql://localhost:3307/real_estate";
            String user = "root";
            String password = "123456789";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
