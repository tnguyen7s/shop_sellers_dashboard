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
public class ProductQuery {
    private Connection conn;
    public ProductQuery(DatabaseContext db)
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
                                        result.getString(10), 
                                        result.getDouble(11),  
                                        result.getString(12),
                                        result.getInt(13))
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
    
    public void insertProduct(Product product) throws SQLException
    {
        // Create query
        String query = "INSERT INTO ('ProductName', 'InStockQuantity', 'SoldQuantity', 'PurchasedPrice', 'RetailPrice', 'Category', 'Brand', 'ProductDetails', 'UsedBestBy', 'RatingAverage', 'ProductImage', 'OwnerId')  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        // Execute query
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(query);
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getInstockQuantity());
            stmt.setInt(3, product.getSoldQuantity());
            stmt.setDouble(4, product.getPurchasedPrice());
            stmt.setDouble(5, product.getRetailPrice());
            stmt.setString(6, product.getCategory());
            stmt.setString(7, product.getBrand());
            stmt.setString(8, product.getProductDetails());
            stmt.setString(9, product.getUsedBestBy());
            stmt.setDouble(10, product.getRatingAverage());
            stmt.setString(11, product.getProductImage());
            stmt.setInt(12, product.getOwnerId());
            
            stmt.executeUpdate();
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
        }
    }
    
    public void updateProduct(Product product) throws SQLException
    {
        // Create query
        String query = "UPDATE Products SET ProductName=?, InstockQuantity=?, SoldQuantity=?, PurchasedPrice=?, RetailPrice=?, Category=?, Brand=?, ProductDetails=?, UsedBestBy=?, RatingAverage=?, ProductImage=?, OwnerId=? WHERE ProductId=?;";
        
        // Execute query
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement(query);
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getInstockQuantity());
            stmt.setInt(3, product.getSoldQuantity());
            stmt.setDouble(4, product.getPurchasedPrice());
            stmt.setDouble(5, product.getRetailPrice());
            stmt.setString(6, product.getCategory());
            stmt.setString(7, product.getBrand());
            stmt.setString(8, product.getProductDetails());
            stmt.setString(9, product.getUsedBestBy());
            stmt.setDouble(10, product.getRatingAverage());
            stmt.setString(11, product.getProductImage());
            stmt.setInt(12, product.getOwnerId());
            stmt.setInt(13, product.getProductId());
            
            stmt.executeUpdate();
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
        }
    }
    
}
