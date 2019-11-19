package edu.mum.ishop.dao;
import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.model.Product;
import edu.mum.ishop.model.User;
import edu.mum.ishop.modelView.UserData;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class DataAccessManager {

    private DataSource dataSource;
    private String dbName ="ishope-db";
    public DataAccessManager()
    {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/ishop-db");
            dbName ="ishop-db";
        } catch (NamingException e) {
            System.err.println(e);
        }
    }



    public List<Order> Order_SelectAll() {
        List<Order> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.order order by id");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id= rs.getInt("Id");
                int userId= rs.getInt("userId");
                Date  orderDate= rs.getDate("Order_Date");
                float tax= rs.getFloat("Tax");
                float shipping= rs.getFloat("Shipping");
                float subtotal= rs.getFloat("Subtotal");
                float total= rs.getFloat("Total");
                boolean IsCheckout= rs.getBoolean("IsCheckout");
                Order data = new Order(id,userId,orderDate,tax,shipping,subtotal,total,IsCheckout);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }
    public boolean Order_Add(Order order) {
        try {
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement pstmt = connection.prepareStatement(" INSERT INTO `"+dbName+"`.`order` ( `User_Id`, `Order_Date`, `Tax`, `Shipping`, `Subtotal`, `Total`, `IsCheckout`) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
            //pstmt.setInt(1, order.getId());
            pstmt.setInt(1, order.getUserId());
            pstmt.setDate(2, order.getOrderDate());
            pstmt.setFloat(3, order.getTax());
            pstmt.setFloat(4, order.getShipping());
            pstmt.setFloat(5, order.getSubtotal());
            pstmt.setFloat(6, order.getTotal());
            pstmt.setBoolean(7, order.isCheckout());
            pstmt.executeUpdate();


            int orderId =0;
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {

                    orderId=generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            List<OrderLine> lines = order.getOrderLines();
            for (int i = 0; i < lines.size() ; i++) {
                OrderLine line = lines.get(i);
                PreparedStatement p = connection.prepareStatement("INSERT INTO `"+dbName+"`.`order_line` ( `Order_Id`, `Product_Id`, `Unit_Price`, `Quantity`, `Subtotal`) VALUES ( ?, ?, ?, ?, ?)");
                //pstmt.setInt(1, order.getId());
                p.setInt(1, orderId);
                p.setInt(2, line.getProductId());
                p.setFloat(3, line.getUnitPrice());
                p.setFloat(4, line.getQuantity());
                p.setFloat(5, line.getSubtotal());
                p.executeUpdate();
            }
            connection.commit();
            connection.setAutoCommit(false);


        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    public List<OrderLine> OrderLine_SelectAll() {
        List<OrderLine> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.OrderLine order by id");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id= rs.getInt("Id");
                int orderId= rs.getInt("Order_Id");
                int  productId= rs.getInt("Product_Id");
                float unitPrice= rs.getFloat("Unit_Price");
                int quantity= rs.getInt("Quantity");
                float subtotal= rs.getFloat("Subtotal");

                OrderLine data = new OrderLine(id,orderId,productId,unitPrice,quantity, subtotal);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }
    public boolean OrderLine_Add(OrderLine order) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `"+dbName+"`.`order_line` ( `Order_Id`, `Product_Id`, `Unit_Price`, `Quantity`, `Subtotal`) VALUES ( ?, ?, ?, ?, ?)");
            //pstmt.setInt(1, order.getId());
            pstmt.setInt(1, order.getOrderId());
            pstmt.setInt(2, order.getProductId());
            pstmt.setFloat(3, order.getUnitPrice());
            pstmt.setFloat(4, order.getQuantity());
            pstmt.setFloat(5, order.getSubtotal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    public List<Product> Product_SelectAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.Product order by id");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id= rs.getInt("Id");
                String productName= rs.getString("Product_Name");
                String description= rs.getString("Description");
                String seller= rs.getString("Seller");
                float price= rs.getFloat("Price");
                boolean isActive= rs.getBoolean("IsActive");
                String imageUrl= rs.getString("Image_Url");

                Product data = new Product(id,productName,description,seller,price,isActive,imageUrl);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }
   /* public boolean Product_Add(Product order) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `"+dbName+"`.`product` ( `Product_Name`, `Description`, `Seller`, `Price`, `IsActive`, `Image_Url`) VALUES ( '?', '?', '?', ?, ?, '?');");
            //pstmt.setInt(1, order.getId());


            pstmt.setString(1,order.getProductName());
            pstmt.setString(2,order.getDescription());
            pstmt.setString(3,order.getSeller());
            pstmt.setFloat(4,order.getPrice());
            pstmt.setBoolean(5,order.isActive());
            pstmt.setString(6,order.getImageUrl());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
*/



    public List<User> User_SelectAll() {
        List<User> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.User order by id");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id= rs.getInt("Id");
                String userName= rs.getString("User_Name");
                String  email= rs.getString("Email");
                String address= rs.getString("Address");
                String password= rs.getString("Password");
                boolean isAdmin= rs.getBoolean("IsAdmin");

                User data = new User(id,userName,email,address,password,isAdmin);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }
    public boolean User_Add(User order) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `"+dbName+"`.`user` ( `User_Name`, `Email`, `Address`, `Password`, `IsAdmin`) VALUES ( ?, ?, ?, ?, ?)");
            //pstmt.setInt(1, order.getId());
            //pstmt.setInt(1, order.getId());
            pstmt.setString(1, order.getUserName());
            pstmt.setString(2, order.getEmail());
            pstmt.setString(3, order.getAddress());
            pstmt.setString(4, order.getPassword());
            pstmt.setBoolean(5, order.isAdmin());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    public UserData User_Login(String username, String pass) {
        UserData user =null ;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.User Where Email=? Password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                user.setUserId( rs.getInt("Id"));
                user.setUserName(rs.getString("User_Name"));
                user.setEmial(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setAdmin(rs.getBoolean("IsAdmin"));
                return  user;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}
