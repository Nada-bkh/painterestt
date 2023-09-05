
package painterestt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nadab
 */
public class MyConnection {
    static String URL ="jdbc:mysql://localhost:3306/painterest" ;
    static String USR ="root" ;
    static String PWD ="" ;
    Connection cnx ;
    
    public static MyConnection instance;

    
    public MyConnection() {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(URL ,USR ,PWD);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
           System.err.print(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public static MyConnection getInstance() {
        if (instance == null)
            instance=new MyConnection();
        return instance;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
