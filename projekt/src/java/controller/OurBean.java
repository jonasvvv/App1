package controller;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Grupp 24
 */
@Stateless
public class OurBean {

    @Resource(name = "jdbc/shop")
    private DataSource dataSource;

    /**
     * Places an order in the database and clears the cart if the order is not
     * empty.
     *
     * @param CName Customer name
     * @return false if an empty order was being placed else true.
     */
    public Boolean placeOrder(String CName) {
        try {
            try (Connection conn = dataSource.getConnection()) {
                PreparedStatement getCart = conn.prepareStatement("Select * from ShoppingCart where CName=?");
                getCart.setString(1, CName);
                ResultSet cart = getCart.executeQuery();
                cart.next();

                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ORDERINFO(CName, Sandbag, Clock, Hat, Pizza, Spaceship) VALUES (?,?,?,?,?,?)");
                pstmt.setString(1, CName);
                int x1 = cart.getInt(2);
                int x2 = cart.getInt(3);
                int x3 = cart.getInt(4);
                int x4 = cart.getInt(5);
                int x5 = cart.getInt(6);
                pstmt.setInt(2, cart.getInt(2));
                pstmt.setInt(3, cart.getInt(3));
                pstmt.setInt(4, cart.getInt(4));
                pstmt.setInt(5, cart.getInt(5));
                pstmt.setInt(6, cart.getInt(6));
                if ((x1 + x2 + x3 + x4 + x5) != 0) {
                    pstmt.executeUpdate();
                    clearCart(CName);
                    return true;
                }
            }
        } catch (Throwable e) {
            out.println(e);
        }
        return false;
    }

    /**
     * Gets the order history of the specified customer.
     *
     * @param CName Customer name.
     * @return List containing the order history of specified customer.
     */
    public ArrayList getOrderHist(String CName) {
        ArrayList list = new ArrayList();
        try {
            try (Connection conn = dataSource.getConnection()) {

                // Create a new row in the database
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM OrderInfo where CName=?");
                pstmt.setString(1, CName);
                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ArrayList row = new ArrayList();
                    for (int i = 3; i <= 8; i++) {
                        row.add(rs.getString(i));
                    }
                    list.add(row);
                }
            }
        } catch (Throwable e) {
            out.println(e);
        }
        return list;
    }

    /**
     * Gets the customer information of specified user.
     *
     * @param CName Customer name
     * @return list of customer information.
     */
    public ArrayList getCInfo(String CName) {
        ArrayList list = new ArrayList();
        try {
            try (Connection conn = dataSource.getConnection()) {
                // Create a new row in the database
                PreparedStatement pstmt = conn.prepareStatement("SELECT First, Last, Address FROM Customer where CName=?");
                pstmt.setString(1, CName);
                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ArrayList row = new ArrayList();
                    for (int i = 1; i <= 3; i++) {
                        row.add(rs.getString(i));
                    }
                    list.add(row);
                }
            }
        } catch (Throwable e) {
            out.println(e);
        }
        return list;
    }

    /**
     * Gets the product information
     *
     * @return list containing product information.
     */
    public ArrayList getProducts() {
        ArrayList list = new ArrayList();
        try {
            try (Connection conn = dataSource.getConnection()) {
                // Create a new row in the database
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Products");
                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    ArrayList row = new ArrayList();
                    for (int i = 1; i <= 2; i++) {
                        row.add(rs.getString(i));
                    }
                    list.add(row);
                }
            }
        } catch (Throwable e) {
            out.println(e);
        }
        return list;
    }

    /**
     * Gets the Shopping cart for specified user.
     *
     * @param CName Customer name
     * @return list containing shopping cart.
     */
    public ArrayList getShoppingCart(String CName) {
        ArrayList list = new ArrayList();
        try {
            try (Connection conn = dataSource.getConnection()) {
                // Create a new row in the database
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ShoppingCart where CName=?");
                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                pstmt.setString(1, CName);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    ArrayList row = new ArrayList();
                    for (int i = 2; i <= 6; i++) {
                        row.add(rs.getString(i));
                    }
                    list.add(row);
                }
            }
        } catch (Throwable e) {
            out.println(e);
        }
        return list;
    }

    /**
     * Gets the total sum of specified customers shopping cart.
     *
     * @param CName Customer name
     * @return sum of all products prices in the shopping cart.
     */
    public int getTotalCart(String CName) {
        int sum = 0;
        ArrayList products;
        ArrayList row;
        String price;
        try {
            try (Connection conn = dataSource.getConnection()) {
                products = getProducts();
                // Create a new row in the database
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ShoppingCart where CName=?");
                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                pstmt.setString(1, CName);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    for (int i = 2; i <= 6; i++) {
                        row = (ArrayList) products.get(i - 2);
                        price = (String) row.get(1);
                        sum = sum + rs.getInt(i) * Integer.parseInt(price);
                    }

                }
            }
        } catch (Throwable e) {
            out.println(e);
        }
        return sum;
    }

    /**
     * adds one specified product to the shopping cart of specified customer.
     *
     * @param CName Customer name.
     * @param PName Product name.
     */
    public void addShoppingCart(String CName, String PName) {
        try {
            try (Connection conn = dataSource.getConnection()) {
                PreparedStatement getCart = conn.prepareStatement("Select * from ShoppingCart where CName=?");
                getCart.setString(1, CName);
                ResultSet cart = getCart.executeQuery();
                cart.next();

                PreparedStatement pstmt = conn.prepareStatement("UPDATE SHOPPINGCART SET " + PName + "=? WHERE CName=?");
                pstmt.setString(2, CName);
                pstmt.setInt(1, cart.getInt(PName) + 1);
                // Create a new row in the database

                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                pstmt.executeUpdate();
            }
        } catch (Throwable e) {
            out.println(e);
        }
    }

    /**
     * Clears the shopping cart of products for specified user.
     *
     * @param CName Customer name.
     */
    public void clearCart(String CName) {
        try {
            try (Connection conn = dataSource.getConnection()) {
                PreparedStatement cleanCart = conn.prepareStatement("UPDATE SHOPPINGCART SET Sandbag=0, Clock=0, Hat=0, Pizza=0, Spaceship=0 WHERE CName=?");
                cleanCart.setString(1, CName);
                cleanCart.executeUpdate();
            }
        } catch (Throwable e) {
            out.println(e);
        }

    }

}
