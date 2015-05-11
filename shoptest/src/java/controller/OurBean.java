/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Alexander
 */
@Stateless
public class OurBean {
@Resource(name="jdbc/shop") // The name you entered for the JDBC resource 
private DataSource dataSource;

public void placeOrder(String user, String nr, String nr2){
            try {
                try (Connection conn = dataSource.getConnection()) {
                    // Create a new row in the database
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BOOKORDER VALUES ("+user+","+nr+","+nr2+")");
                    //PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
                    pstmt.executeUpdate();
                }
            } catch (Throwable e) {
                out.println(e);
            }
}
}
