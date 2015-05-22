/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import sun.rmi.runtime.Log;
//import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Alexander
 */
@Stateless
public class OurBean {

    @Resource(name = "jdbc/shop") // The name you entered for the JDBC resource 
    private DataSource dataSource;

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
                if ((x1+x2+x3+x4+x5)!=0) {
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
