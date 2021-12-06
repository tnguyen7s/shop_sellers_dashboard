/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Services;

import com.mh.Dao.DatabaseContext;
import com.mh.Entities.Product;
import com.mh.Queries.ProductQueries;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tuyen
 */
public class ProductService {
    private ProductQueries query;
    public ProductService(DatabaseContext db)
    {
        query = new ProductQueries(db);
    }
    
    public List<Product> getAllProductsOfSeller(int sellerId) throws SQLException
    {
        return this.query.getAllProductsOfSeller(sellerId);
    }
}
