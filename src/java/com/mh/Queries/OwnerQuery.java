/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Queries;

import com.mh.Dao.DatabaseContext;
import com.mh.Entities.Owner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tuyen
 */
public class OwnerQuery {
    private Connection conn = null;
    
    public OwnerQuery(DatabaseContext db)
    {
        conn = db.getConnection();
    }
    
    public Owner getOwner(String phone, String password) throws SQLException
    {
        // Create query
        String query = "SELECT * FROM Owners WHERE PhoneNumber=? AND Password=?;";
        
        // prepare and execute statements
        PreparedStatement stmt = null;
        ResultSet result = null;
        Owner owner = null;
        try{
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, phone);
            stmt.setString(2, password);
            
            result = stmt.executeQuery();
            
            while (result.next())
            {
                owner = new Owner(result.getInt("OwnerId"), result.getString("FirstName"), result.getString("LastName"), result.getString("PhoneNumber"), result.getString("Address"), result.getString("Password"), result.getString("ShopName"));
            }
            
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        finally
        {
            if (stmt!=null)
            {
                stmt.close();
            }
            if(result!=null)
            {
                result.close();
            }
        }
        return owner;
    }
}
