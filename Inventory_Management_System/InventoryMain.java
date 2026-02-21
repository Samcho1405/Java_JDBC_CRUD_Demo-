package Inventory_Management_System;

import java.sql.Connection;
import java.util.Scanner;

public class InventoryMain {
      public static void main(String[] args) throws Exception {
       InventoryService v1=new InventoryService();
        Connection con=DB_Configration.getConnection();
        // InventoryService.Addproduct(con);
        // InventoryService.updateProduct(con);
       
         
        System.out.println("1. Add Product");
        System.out.println("2. Delete Product");
        System.out.println("3. Update Product");
        System.out.println("4. View Products");
        System.out.println("5. Search Product by Name");
        System.out.println("6. Exit");
        System.out.print("Enter your choice:");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                InventoryService.Addproduct(con);
                break;
            case 2:
                InventoryService.deleteProduct(con);
                break;
            case 3:
                InventoryService.updateProduct(con);
                break;
                
            case 4:
                InventoryService.viewProducts(con);
                break;
                
            case 5:
                InventoryService.serchProductByName(con);
                break;
            case 6:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
      
      }    
    
}
