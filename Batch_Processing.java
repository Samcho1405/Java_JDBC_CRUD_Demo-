import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;// this import is used to store the data which is retrive from database
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Batch_Processing {
    
    private static String url= "jdbc:mysql://localhost:3306/demo"; //db url
    private static String username="root"; //db username
    private static String  password="1405"; //your password

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    System.out.println("Enter id");
        int id=sc.nextInt();
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter salary");
        int salary=sc.nextInt();


        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //this line is used to load the mysql jdbc driver,
                                                                
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            
           Connection connection = DriverManager.getConnection(url, username, password);
             String query="insert into demo values(?,?,?)";
             for(int i=0;i<3;i++){
                System.out.println("Enter id");
                id=sc.nextInt();
                System.out.println("Enter name");
                name=sc.next();
                System.out.println("Enter salary");
                salary=sc.nextInt();
                PreparedStatement statement =connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, salary);
                statement.addBatch();
             }
           PreparedStatement statement =connection.prepareStatement(query);
           statement.setInt(1, id);
           statement.setString(2, name);
           statement.setInt(3, salary);
           statement.addBatch();

           int rowsAffected[]=statement.executeBatch();
           for(int i=0;i<rowsAffected.length;i++){
            System.out.println("Statement "+(i+1)+": "+rowsAffected[i]+" rows affected.");
           }
         //  System.out.println("Batch executed successfully. Rows affected: "+rowsAffected.length);

    }catch(SQLException e){
            System.out.println(e);

            }    
            }
        }