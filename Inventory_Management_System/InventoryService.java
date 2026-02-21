package Inventory_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InventoryService {

    public static void Addproduct(Connection con){
      try{
         String query="insert into inventory (name,prize,quantity) values(?,?,?)";
        PreparedStatement preparedStatement=con.prepareStatement(query);
    Scanner sc=new Scanner(System.in);
    while(true){
    System.out.println("Plese Enter  name");
        String name=sc.next();
        System.out.println("Enter Prize ");
        int prize=sc.nextInt();
        System.out.println("Enter Quatity");
        int qun=sc.nextInt();
        System.out.println("Are you want to inseart our record Y/N");
        String  choose=sc.next();
      preparedStatement.setString(1, name);
       preparedStatement.setInt(2, prize);
        preparedStatement.setInt(3, qun);
            if(choose.toUpperCase().equals("N")){
             break;    
            }
    }
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.println("Data inserted successfully.");
        }else{
            System.out.println("Data insertion failed.");
        }   
        System.out.println("Rows affected: "+rowsAffected);

        }catch(SQLException e){
            System.out.println(e);

        }
    }

    public static void  updateProduct(Connection con){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Product ID to update:");
        int id=sc.nextInt();
        System.out.println("Which field value to update (name/prize/quantity):");
        String field=sc.next();

        try{
            String query="update inventory set "+field+"=? where id=?";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            System.out.println("Enter new value for "+field+":");
            if(field.equals("name")){
                preparedStatement.setString(1, sc.next());
            }else if(field.equals("prize")){
                preparedStatement.setInt(1, sc.nextInt());
            }else if(field.equals("quantity")){
                preparedStatement.setInt(1, sc.nextInt());
            }
            preparedStatement.setInt(2, id);
            int rowsAffected=preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Product updated successfully.");
            }else{
                System.out.println("Product update failed.");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void deleteProduct(Connection con){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Product ID to delete:");
        int id=sc.nextInt();
        try{
            String query="delete from inventory where id=?";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rowsAffected=preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Product deleted successfully.");
            }else{
                System.out.println("Product deletion failed.");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void viewProducts(Connection con){
        try{
            String query="select * from inventory";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("ID: "+resultSet.getInt("id")+", Name: "+resultSet.getString("name")+", Prize: "+resultSet.getInt("prize")+", Quantity: "+resultSet.getInt("quantity"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void serchProductByName(Connection con){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Product Name to search:");
        String name=sc.next();
        try{
            String query="select * from inventory where name=?";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("ID: "+resultSet.getInt("id")+", Name: "+resultSet.getString("name")+", Prize: "+resultSet.getInt("prize")+", Quantity: "+resultSet.getInt("quantity"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    

}

