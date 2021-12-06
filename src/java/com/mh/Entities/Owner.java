/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Entities;

/**
 *
 * @author Tuyen
 */
public class Owner {
    private int ownerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String password;
    private String shopName;
    
    public Owner(int ownerId, String firstName, String lastName, String phoneNumber, String address, String password, String shopName)
    {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.shopName = shopName;
    }
    
    public int getOwnerId()		
    {
        return this.ownerId;
    }
    
    public String getFirstName()	
    {
        return this.firstName;
    }
    
    public String getLastName()	
    {
        return this.lastName;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public String getShopName()
    {
        return this.shopName;
    }
    
}
