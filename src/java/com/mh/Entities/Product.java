/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.Entities;

/**
 *
 * @author Tuyen
 */
public class Product {
    private int productId;
    private String productName;
    private int instockQuantity;
    private int soldQuantity;
    private double purchasedPrice;
    private double retailPrice;
    private String category;
    private String brand;
    private String productDetails;
    private double ratingAverage;
    private String productImage;
    private int ownerId;
    private String usedBestBy;
    
    public Product(
    int productId,
    String productName,
    int instockQuantity,
    int soldQuantity,
    double purchasedPrice,
    double retailPrice,
    String category, 
    String brand,
    String productDetails,
    String usedBestBy,
    double ratingAverage,
    String productImage,
    int ownerId)
    {
        this.productId = productId;
        this.productName = productName;
        this.instockQuantity = instockQuantity;
        this.soldQuantity = soldQuantity;
        this.purchasedPrice = purchasedPrice;
        this.retailPrice = retailPrice;
        this.category = category;
        this.brand = brand;
        this.productDetails = productDetails;
        this.ratingAverage = ratingAverage;
        this.productImage = productImage;
        this.ownerId = ownerId;
        this.usedBestBy = usedBestBy;
    }
    
    public int getProductId()               
    { 
            return this.productId;
    } 
    public String getProductName()          
    { 
            return this.productName;
    } 
    public int getInstockQuantity()         
    { 
            return this.instockQuantity;
    } 
    public int getSoldQuantity()            
    { 
            return this.soldQuantity;
    } 
    public double getPurchasedPrice()       
    { 
            return this.purchasedPrice;
    } 
    public double getRetailPrice()          
    { 
            return this.retailPrice;
    } 
    public String getCategory()             
    { 
            return this.category;
    } 
    public String getBrand()                
    { 
            return this.brand;
    } 
    public String getProductDetails()       
    { 
            return this.productDetails;
    } 
    public double getRatingAverage()        
    { 
            return this.ratingAverage;
    } 
    public String getProductImage()         
    { 
            return this.productImage;
    } 
    public int getOwnerId()                 
    { 
            return this.ownerId;
    } 

    public String getUsedBestBy()                 
    { 
            return this.usedBestBy;
    }
}
