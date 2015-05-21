/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author jonasviklund
 */
@WebServlet(name = "Controller",
        loadOnStartup = 1,
        urlPatterns = {"/Controller", "/products",
            "/confirm",
            "/cart",
            "/order"})

public class Controller extends HttpServlet {

    @EJB
    private OurBean myBean;

    @Resource(name = "jdbc/shop") // The name you entered for the JDBC resource 
    private DataSource dataSource;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nr = request.getParameter("nr");
            String nr2 = request.getParameter("nr2");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

       // if (request.getParameter("products") != null) {
        //  }
        String userPath = request.getServletPath();

        if (userPath.equals("/products")) {
            request.setAttribute("products", myBean.getProducts());
            
        } else if (userPath.equals("/cart")) {
            //request.setAttribute("cart", myBean.getShoppingCart());
            
        } else if (userPath.equals("/order")) {
            request.setAttribute("order", myBean.getOrderHist(request.getRemoteUser()));
            
        } else if (userPath.equals("/confirm")) {

        }

        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getParameter("place") != null) {
            myBean.placeOrder(request.getRemoteUser());
            response.sendRedirect("/projekt/confirm");

        }

        if (request.getParameter("toCart") != null) {
           // myBean.addShoppingCart(request.getRemoteUser(),request.getParameter("productId"));
            response.sendRedirect("/projekt/confirm");

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
