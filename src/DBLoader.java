

import java.sql.*;

public class DBLoader {
    public static ResultSet executeQuery(String query) {
        System.out.println("    "+query);
        ResultSet rs = null;
        
        try{              
            //used to register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading done");
            
            //Create connection with database
            Connection conn 
            = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pos2024", "root", "System123@");
           
            System.out.println("Connection done");
            
            //used to create statement 
            //object of statement is responsible to execute queries with the database
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                                                                    ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement created");
            
            
            //Execute query
            rs = stmt.executeQuery(query);
            System.out.println("ResultSet Created"); 
            
      
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return rs;
        
    }
}