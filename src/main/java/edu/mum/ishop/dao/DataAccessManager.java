package edu.mum.ishop.dao;
import edu.mum.ishop.model.Order;
import edu.mum.ishop.model.OrderLine;
import edu.mum.ishop.model.Product;
import edu.mum.ishop.model.User;
import edu.mum.ishop.modelView.OrderView;
import edu.mum.ishop.modelView.UserData;

import java.sql.*;
import java.time.LocalDate;
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
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.order order by id");
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int id= rs.getInt("Id");
                int userId= rs.getInt("userId");
                LocalDate orderDate= rs.getDate("Order_Date").toLocalDate();
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
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return list;
    }
    public boolean Order_Add(Order order) {

        Connection connection=null;
        PreparedStatement pstmt=null;
        //ResultSet rs=null;
        //ResultSet generatedKeys=null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(" INSERT INTO `"+dbName+"`.`order` ( `User_Id`, `Order_Date`, `Tax`, `Shipping`, `Subtotal`, `Total`, `IsCheckout`) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
            //pstmt.setInt(1, order.getId());
            pstmt.setInt(1, order.getUserId());
            pstmt.setDate(2, Date.valueOf(order.getOrderDate()));
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
                if(generatedKeys!=null)
                    generatedKeys.close();
            }

            List<OrderLine> lines = order.getOrderLines();
            for (int i = 0; i < lines.size() ; i++) {
                OrderLine line = lines.get(i);
                PreparedStatement p = connection.prepareStatement("INSERT INTO `"+dbName+"`.`order_line` ( `Order_Id`, `Product_Id`, `Unit_Price`, `Quantity`, `Subtotal`) VALUES ( ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
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
        finally {
            try
            {
//                if (rs!=null)
//                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return true;
    }

    public List<OrderView> OrderView_SelectAll() {
        List<OrderView> list = new ArrayList<>();
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            connection = dataSource.getConnection();
            String sql="SELECT `order`.`Id`,     `order`.`User_Id`,     `order`.`Order_Date`,     `order`.`Tax`,     `order`.`Shipping`,     `order`.`Subtotal`,     `order`.`Total`,     `order`.`IsCheckout` ,     `ishop-db`.`user`.User_Name,     `ishop-db`.`user`.Address,     `ishop-db`.`user`.Email FROM `ishop-db`.`order` inner join `ishop-db`.`user` on   `ishop-db`.`order`.`User_Id` = `ishop-db`.`user`.Id";
            sql=sql.replace("ishop-db",dbName);

            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int id= rs.getInt("Id");
                int userId= rs.getInt("User_Id");
                Date  orderDate= rs.getDate("Order_Date");
                float tax= rs.getFloat("Tax");
                float shipping= rs.getFloat("Shipping");
                float subtotal= rs.getFloat("Subtotal");
                float total= rs.getFloat("Total");
                boolean IsCheckout= rs.getBoolean("IsCheckout");

                String userName= rs.getString("User_Name");
                String address= rs.getString("User_Name");
                String email= rs.getString("Email");

                OrderView data = new OrderView(id,userId,orderDate,tax,shipping,subtotal,total,IsCheckout,userName,address,email);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return list;
    }

    public List<OrderLine> OrderLine_SelectAll() {
        List<OrderLine> list = new ArrayList<>();
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.OrderLine order by id");
            rs = pstmt.executeQuery();
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
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return list;
    }
    public boolean OrderLine_Add(OrderLine order) {

        Connection connection=null;
        PreparedStatement pstmt=null;


        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("INSERT INTO `"+dbName+"`.`order_line` ( `Order_Id`, `Product_Id`, `Unit_Price`, `Quantity`, `Subtotal`) VALUES ( ?, ?, ?, ?, ?)");
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
        }finally {
            try
            {

                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return true;
    }

    public List<Product> Product_SelectAll() {
        List<Product> list = new ArrayList<>();
        Connection connection=null;
        ResultSet rs=null;
        PreparedStatement pstmt=null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.Product order by id");
            rs = pstmt.executeQuery();
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
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return list;
    }
    public Product Product_SelectOne(int productId) {
        Product product = null;
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.Product where id=?");
            pstmt.setInt(1, productId);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                product=new Product(
                    rs.getInt("Id"),
                    rs.getString("Product_Name"),
                    rs.getString("Description"),
                    rs.getString("Seller"),
                    rs.getFloat("Price"),
                    rs.getBoolean("IsActive"),
                    rs.getString("Image_Url"));
            }
            connection.close();
            return product;
        } catch (SQLException e) {
            System.err.println(e);
        }
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return null;
    }
    public List<Product> Product_Search(String q) {
        List<Product> list = new ArrayList<>();
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.Product where Product_Name like ? or Description like ?");
            pstmt.setString(1, "%"+q+"%");
            pstmt.setString(2, "%"+q+"%");
            rs = pstmt.executeQuery();
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
            return list;
        } catch (SQLException e) {
            System.err.println(e);
        }
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return null;
    }





    public List<User> User_SelectAll() {
        List<User> list = new ArrayList<>();
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.User order by id");
            rs = pstmt.executeQuery();
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
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return list;
    }
    public boolean User_Add(User order) {
        Connection connection=null;
        PreparedStatement pstmt=null;

        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("INSERT INTO `"+dbName+"`.`user` ( `User_Name`, `Email`, `Address`, `Password`, `IsAdmin`) VALUES ( ?, ?, ?, ?, ?)");
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
        finally {
            try
            {

                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return true;
    }



    public User User_Login(String email) {
        User user =null ;
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM `"+dbName+"`.User Where Email=?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                user=new User();
                user.setId( rs.getInt("Id"));
                user.setUserName(rs.getString("User_Name"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setAdmin(rs.getBoolean("IsAdmin"));
                user.setPassword(rs.getString("Password"));
                return  user;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        finally {
            try
            {
                if (rs!=null)
                    rs.close();
                if (connection!=null)
                    connection.close();
                if (pstmt!=null)
                    pstmt.close();

            }
            catch (Exception e)
            {
            }
        }
        return null;
    }
}
