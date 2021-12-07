/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mh.Servlets;
import com.mh.Cookies.CookieUtils;
import com.mh.Dao.DatabaseContext;
import com.mh.Entities.Product;
import com.mh.Queries.ProductQuery;
import com.mh.Services.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuyen
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

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
         ServletContext context = request.getServletContext();
        Object dbObject = context.getAttribute("DatabaseContext");
        
        RequestDispatcher requestDispatcher = null;   
        // If unable to get the database context, return an error page
        if (dbObject==null)
        {
            request.setAttribute("error", "DatabaseContext is null: "+request.getServletContext().getAttribute("error"));
            requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        DatabaseContext db = (DatabaseContext)dbObject;
        
        //Create product queries
        ProductService service = new ProductService(db);
        
        String ownerIdS = CookieUtils.getCookieValue(request.getCookies(), "ownerId");
        int ownerId;
        if (ownerIdS != null){
            ownerId = Integer.parseInt(ownerIdS);
        }
        else
        {
            request.setAttribute("error","Unfound cookie");
            requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        
        try {
            // get a list of products and displau it using a jsp page; otherwise 
            List<Product> products = service.getAllProductsOfSeller(ownerId);
            request.setAttribute("products", products);
            requestDispatcher = request.getRequestDispatcher("products.jsp");
            requestDispatcher.forward(request, response);
        } 
        catch (SQLException ex) {
            request.setAttribute("SQL exception: ", ex.getMessage());
            requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
            return;
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
        ServletContext context = request.getServletContext();
        Object dbObject = context.getAttribute("DatabaseContext");
        
        RequestDispatcher requestDispatcher = null;   
        // If unable to get the database context, return an error page
        if (dbObject==null)
        {
            request.setAttribute("error", "DatabaseContext is null: "+request.getServletContext().getAttribute("error"));
            requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        DatabaseContext db = (DatabaseContext)dbObject;
        
        //Create product queries
        ProductService service = new ProductService(db);
        
        String productName = request.getParameter("productName");
        int instockQuantity = Integer.parseInt(request.getParameter("instockQuantity"));
        int soldQuantity = Integer.parseInt(request.getParameter("soldQuantity"));
        double purchasedPrice = Double.parseDouble(request.getParameter("purchasedPrice"));
        double retailPrice = Double.parseDouble(request.getParameter("retailPrice"));
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String productDetails = request.getParameter("productDetails");
        double ratingAverage = Double.parseDouble(request.getParameter("ratingAverage"));
        String productImage = request.getParameter("productImage");
        int ownerId = Integer.parseInt(CookieUtils.getCookieValue(request.getCookies(), "ownerId"));
        String usedBestBy = request.getParameter("usedBestBy");
        
        String productIdString = request.getParameter("productId");
        try{
            if (productIdString==null)
            {
                service.insertProduct(new Product(-1, productName, instockQuantity, soldQuantity, purchasedPrice, retailPrice, category, brand, productDetails, usedBestBy, ratingAverage, productImage, ownerId));
            }
            else
            {
                int productId = Integer.parseInt(productIdString);
                service.updateProduct(new Product(productId, productName, instockQuantity, soldQuantity, purchasedPrice, retailPrice, category, brand, productDetails, usedBestBy, ratingAverage, productImage, ownerId));
            }
             // get a list of products and displau it using a jsp page; otherwise 
            List<Product> products = service.getAllProductsOfSeller(ownerId);
            request.setAttribute("products", products);
            
            requestDispatcher = request.getRequestDispatcher("products.jsp");
            requestDispatcher.forward(request, response);
            
            return;
        }
        catch(SQLException ex)
        {
            request.setAttribute("error", "SQL exception: "+ ex.getMessage());
            requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
            return;
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
