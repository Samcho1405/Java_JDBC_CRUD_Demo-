import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;// this import is used to store the data which is retrive from database
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcDemo {

    private static String url= "jdbc:mysql://localhost:3306/demo"; //db url
    private static String username="root"; //db username
    private static String  password=""; //your password
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    // System.out.println("Enter id");
    //     int id=sc.nextInt();
    //     System.out.println("Enter name");
    //     String name=sc.next();
    //     System.out.println("Enter salary");
    //     int salary=sc.nextInt();


        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //this line is used to load the mysql jdbc driver,
                                                                
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
           Connection connection = DriverManager.getConnection(url, username, password);
           // Statement statement =connection.createStatement();
         //********************This is a retrive data from databse query***********************     
            
            // String query="select * from demo";  
            // ResultSet resultset=statement.executeQuery(query);
            // while(resultset.next()){
            //        int id=resultset.getInt("id");
            //        String name=resultset.getString("name");
            //        int salary=resultset.getInt("salary");
            //        System.out.println("ID: "+id);
            //        System.out.println("name: "+name);
            //        System.out.println("Salary: "+salary);
            // }


             //********************This is a Create  data query*********************** 

            //   String query="insert into demo values(6,'kartik',50000)";  
            // int rowsAffected=statement.executeUpdate(query);
            // if(rowsAffected>0){
            //     System.out.println("Data inserted successfully.");
            // }else{
            //     System.out.println("Data insertion failed.");
            // }   
            // System.out.println("Rows affected: "+rowsAffected);

     //********************This is a Create query using user input*********************** 

            //   String query="insert into demo values("+id+",'"+name+"',"+salary+")";  
            // int rowsAffected=statement.executeUpdate(query);
            // if(rowsAffected>0){
            //     System.out.println("Data inserted successfully.");
            // }else{
            //     System.out.println("Data insertion failed.");
            // }   
            // System.out.println("Rows affected: "+rowsAffected);


          //********************This is a update   data query***********************
            
            //    String query="update demo set salary=60000 where id=6";  
            // int rowsAffected=statement.executeUpdate(query);
            // if(rowsAffected>0){
            //     System.out.println("Data updated successfully.");
            // }else{
            //     System.out.println("Data update failed.");
            // }   
            // System.out.println("Rows affected: "+rowsAffected);


        //********************This is a delete   data query***********************

            //  String query="delete from demo where id=6";  
            // int rowsAffected=statement.executeUpdate(query);
            // if(rowsAffected>0){
            //     System.out.println("Data deleted successfully.");
            // }else{
            //     System.out.println("Data deletion failed.");
            // }   
            // System.out.println("Rows affected: "+rowsAffected);


        //********************Now i am prictising Prepared Statement queris***********************
        //    String query="insert into demo values(?,?,?)";
        // PreparedStatement preparedStatement=connection.prepareStatement(query);
        // preparedStatement.setInt(1, id);
        // preparedStatement.setString(2, name);
        // preparedStatement.setInt(3, salary);
        // int rowsAffected=preparedStatement.executeUpdate();
        // if(rowsAffected>0){
        //     System.out.println("Data inserted successfully.");
        // }else{
        //     System.out.println("Data insertion failed.");
        // }   
        // System.out.println("Rows affected: "+rowsAffected);

        //********************This is update data Using Prepared Statement***********************

        // String query="update demo set salary=? where id=?";
        // PreparedStatement preparedStatement=connection.prepareStatement(query);

        // preparedStatement.setInt(1, 70000);
        // preparedStatement.setInt(2, 1);
        // int rowsAffected=preparedStatement.executeUpdate();
        // if(rowsAffected>0){ 
        //     System.out.println("Data updated successfully.");   
        // }else{
        //     System.out.println("Data update failed.");
        // }

        String query="delete from demo where id=?";
        PreparedStatement prepardStatement=connection.prepareStatement(query);
        prepardStatement.setInt(1, 6);
        int rowsAffected=prepardStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.println("Data deleted successfully.");
        }else{
            System.out.println("Data deletion failed.");
        }

    }catch(SQLException e){
        System.out.print(e);
    }
}
}