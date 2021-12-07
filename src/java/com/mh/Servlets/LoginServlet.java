/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mh.Servlets;

import com.mh.Dao.DatabaseContext;
import com.mh.Entities.Owner;
import com.mh.Services.OwnerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuyen
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/"})
public class LoginServlet extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
        
        //Get the database context from the app context
        Object dbObj = request.getServletContext().getAttribute("DatabaseContext");
        RequestDispatcher requestDispatcher = null;
        
        // If unable to get the database context, return an error page
        if (dbObj==null)
        {
            request.setAttribute("error", "DatabaseContext is null: "+request.getServletContext().getAttribute("error"));
            requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        
        DatabaseContext db= (DatabaseContext)dbObj;
        
        // Create OwnerService object
        OwnerService service = new OwnerService(db);
        
        Owner owner = null;
        if (request.getParameter("phone")!=null)
        {
            try {
                // if the seller is valid, setCookie with userId and direct user to home page; otherwise, return login page with a meassage
                if ((owner=service.identifyAndVerifyOwner(request.getParameter("phone"), request.getParameter("pwd")))!=null)
                {
                    response.addCookie(new Cookie("ownerId", Integer.toString(owner.getOwnerId())));
                    requestDispatcher = request.getRequestDispatcher("/products");
                    requestDispatcher.forward(request, response);
                }
                else
                {
                    request.setAttribute("invalidLogin", "true");
                    requestDispatcher = request.getRequestDispatcher("login.jsp");
                    requestDispatcher.forward(request, response);
                }
            } 
            catch (SQLException ex) {
                request.setAttribute("error", "SQL exception: " + ex.getMessage());
                requestDispatcher = request.getRequestDispatcher("error.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
        }
        else
        {
            // otherwise, display the login page
            requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
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
