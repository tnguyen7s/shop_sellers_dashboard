/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tuyen
 */
public class DatabaseContext {
    private Connection conn = null;
    public DatabaseContext(String connectionString) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(connectionString, "root", "");
    }
    
    public Connection getConnection()
    {
        return conn;
    }
    
    public void closeConnection() throws SQLException
    {
        conn.close();
    }
}
