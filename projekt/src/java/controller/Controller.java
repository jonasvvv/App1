/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grupp 24
 */
@WebServlet(name = "Controller",
        loadOnStartup = 1,
        urlPatterns = {"/products",
            "/Controller",
            "/confirm",
            "/cart",
            "/order"})

public class Controller extends HttpServlet {

    @EJB
    private OurBean myBean;

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

        String userPath = request.getServletPath();

        switch (userPath) {
            case "/products":
                request.setAttribute("products", myBean.getProducts());
                break;
            case "/cart":
                request.setAttribute("cart", myBean.getShoppingCart(request.getRemoteUser()));
                request.setAttribute("products", myBean.getProducts());
                request.setAttribute("totalcart", myBean.getTotalCart(request.getRemoteUser()));
                break;
            case "/order":
                request.setAttribute("order", myBean.getOrderHist(request.getRemoteUser()));
                request.setAttribute("products", myBean.getProducts());
                break;
            case "/confirm":
                break;
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
        if (request.getParameter("place") != null) {
            //checks to see if the user has placed an empty order.
            if (myBean.placeOrder(request.getRemoteUser())) {
                response.sendRedirect("/projekt/confirm");
            } else {
                response.sendRedirect("/projekt/cart");
            }
        }
        if (request.getParameter("clear") != null) {
            myBean.clearCart(request.getRemoteUser());
            response.sendRedirect("/projekt/cart");
        }
        if (request.getParameter("toCart") != null) {
            myBean.addShoppingCart(request.getRemoteUser(), request.getParameter("productName"));
            response.sendRedirect("/projekt/products");
        }
    }
}
