package Inventory_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Configration {

    public static Connection getConnection()throws Exception{
        
          //  Class.forName("com.mysql.cj.jdbc.Driver"); //this line is used to load the mysql jdbc driver,
                                                                
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/?? ",//?? is your database name
                                              "root",
                                              "");//insert your password here
    
} 
}
