/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Services;

import com.mh.Dao.DatabaseContext;
import com.mh.Entities.Owner;
import com.mh.Queries.OwnerQuery;
import java.sql.SQLException;

/**
 *
 * @author Tuyen
 */
public class OwnerService {
    private OwnerQuery query = null;
    public OwnerService(DatabaseContext db)
    {
        query = new OwnerQuery(db);
    }
    
    public Owner identifyAndVerifyOwner(String phone, String password) throws SQLException
    {
        return this.query.getOwner(phone, password);
    }
}
