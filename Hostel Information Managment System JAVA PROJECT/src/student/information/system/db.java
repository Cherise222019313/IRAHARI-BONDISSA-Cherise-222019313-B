
package student.information.system;


import java.sql.*;
import javax.swing.*;
public class db {

    Connection conn=null;
    public static Connection java_db(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/studentinfo", "root", "");
       
            return conn;
           
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
           return null;
        }
        
    }
}
