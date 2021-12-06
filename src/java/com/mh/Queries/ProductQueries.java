/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Queries;

import com.mh.Dao.DatabaseContext;
import com.mh.Entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuyen
 */
public class ProductQueries {
    private Connection conn;
    public ProductQueries(DatabaseContext db)
    {
        this.conn = db.getConnection();
    }
    
    public List<Product> getAllProductsOfSeller(int sellerId) throws SQLException
    {
        // Create the query
        String query = "SELECT * FROM Products WHERE OwnerId=?";
        
        // Create a list to store sellers' products
        List<Product> products = new ArrayList<>(); 
        
        // Prepare the query
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        try
        {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, sellerId);
            
            result = stmt.executeQuery();
            while(result.next())
            {
                products.add(new Product(result.getInt(1), 
                                        result.getString(2), 
                                        result.getInt(3), 
                                        result.getInt(4), 
                                        result.getDouble(5), 
                                        result.getDouble(6),  
                                        result.getString(7),
                                        result.getString(8), 
                                        result.getString(9),  
                                        result.getDouble(10), 
                                        result.getString(11),  
                                        result.getInt(12))
                );
            }

        }
        catch(SQLException ex)
        {
            throw ex;
        }
        finally
        {
            if(stmt!=null)
            {
                stmt.close();
            }
            if (result!=null)
            {
                result.close();
            }
        }
        return products;
    }
}
