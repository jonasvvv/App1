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
//import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Alexander
 */
@Stateless
public class OurBean {

    @Resource(name = "jdbc/shop") // The name you entered for the JDBC resource 
    private DataSource dataSource;

    public void placeOrder(String CName) {
        try {
            try (Connection conn = dataSource.getConnection()) {
                PreparedStatement getCart = conn.prepareStatement("Select * from ShoppingCart where CName=?");
                getCart.setString(1, CName);
                ResultSet cart = getCart.executeQuery();

                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ORDERINFO(CName, Prod1, Prod2, Prod3) VALUES (?,?,?,?);");
                pstmt.setString(1, CName);
                pstmt.setInt(2, cart.getInt("Prod1"));
                pstmt.setInt(3, cart.getInt("Prod2"));
                pstmt.setInt(4, cart.getInt("Prod3"));
                // Create a new row in the database

                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                pstmt.executeUpdate();
            }
        } catch (Throwable e) {
            out.println(e);
        }
    }

    public ArrayList getOrderHist(String CName) {
        ArrayList list = new ArrayList();
        try {
            try (Connection conn = dataSource.getConnection()) {

                // Create a new row in the database
                PreparedStatement pstmt = conn.prepareStatement("SELECT OID, OTime, PName, Amount FROM OrderID natural join OrderInfo where CName=?");
                pstmt.setString(1, CName);
                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    ArrayList row = new ArrayList();
                    for (int i = 1; i <= 4; i++) {
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
    
    public ArrayList getShoppingCart() {
        ArrayList list = new ArrayList();
        try {
            try (Connection conn = dataSource.getConnection()) {
                // Create a new row in the database
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ShoppingCart");
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


    public void addShoppingCart(String CName, int pid) {
        try {
            try (Connection conn = dataSource.getConnection()) {
                PreparedStatement getCart = conn.prepareStatement("Select * from ShoppingCart where CName=?");
                getCart.setString(1, CName);
                ResultSet cart = getCart.executeQuery();
                
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SHOPPINGCART(CName, Prod1, Prod2, Prod3) VALUES (?,?,?,?);");
                pstmt.setString(1, CName);
                pstmt.setInt(pid+1, cart.getInt(pid)+1);
                // Create a new row in the database

                //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                pstmt.executeUpdate();
            }
        } catch (Throwable e) {
            out.println(e);
        }
    }
    
}
