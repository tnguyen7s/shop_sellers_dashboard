/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package com.mh.AppListeners;

import com.mh.Dao.DatabaseContext;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebServlet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Web application lifecycle listener.
 *
 * @author Tuyen
 */
@WebServlet
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ServletContext context = sce.getServletContext();
       
       String connectionString = context.getInitParameter("DbConnectionString");
       
       DatabaseContext db = null;
       try 
       {
           db = new DatabaseContext(connectionString);
       } 
       catch (SQLException ex) {
            Logger.getLogger(AppContextListener.class.getName()).log(Level.SEVERE, null, ex);
            context.setAttribute("error", ex.getMessage());
       }
        
        context.setAttribute("DatabaseContext", db);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ((DatabaseContext)sce.getServletContext().getAttribute("DatabaseContext")).closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AppContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
