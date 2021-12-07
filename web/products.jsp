<%-- 
    Document   : products
    Created on : Dec 6, 2021, 3:07:42 AM
    Author     : Tuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mh.Entities.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock</title>
        <style>
            th, td {
                border: 1px solid black;
                padding: .2em .7em;
                text-align: left;
            }
            .color-row:nth-child(odd)
            {
                background-color: #57FB86;
            }
            
            a{
                text-decoration-line: none;
                border: 1px solid black;
                padding: 8px;
                background-color:#FFD814;
                border-radius: 5px;
                color: black;
            }
            
            button
            {
                background: none; 
                color: inherit; 
                border: none; 
                padding: 5px; 
                font: inherit; 
                cursor: pointer; 
                outline: inherit; 
                background-color:#FFD814; 
                border-color: #FCD200; 
                border-radius: 5px; 
            }
        </style>
    </head>
    <body style="font-family: Arial,sans-serif; font-size: 0.8em; margin: 40px;">
        <h1>My stock</h1>
        <table style="border: 1px solid black; border-collapse: collapse; margin: 50px;">
            <%
                // determine which row is requested to edit
                String editingProductString = request.getParameter("productId");
                
                int editingProductId = -1;
                if(editingProductString!=null)
                {
                    editingProductId = Integer.parseInt(editingProductString);
                }
                
                List<Product> products = (ArrayList<Product>)request.getAttribute("products");
                if (products.isEmpty())
                {
                    out.println("<p style=\"color: red;\">Your stock is empty.</p>");
                }
                else
                {
                    out.println("<thead>");
                    out.println("<tr>");
                        out.println("<th>Product Id</th>");
                        out.println("<th>Product Name</th>");
                        out.println("<th>In-stock Quantity</th>");
                        out.println("<th>Sold Quantity</th>");
                        out.println("<th>Purchased Price</th>");
                        out.println("<th>Retail Price</th>");
                        out.println("<th>Category</th>");
                        out.println("<th>Brand</th>");
                        out.println("<th>Product Details</th>");
                        out.println("<th>Rating Average</th>");
                        out.println("<th>Product Image</th>");
                        out.println("<th></th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    
                    out.println("<tbody>");
                    for (Product p:products)
                    {
                        int productId = p.getProductId();
                        if (editingProductId!=productId){
                            out.println("<tr class=\"color-row\">");
                                out.println("<td>"+p.getProductId()+"</td>");
                                out.println("<td>"+p.getProductName()+"</td>");
                                out.println("<td>"+p.getInstockQuantity()+"</td>");
                                out.println("<td>"+p.getSoldQuantity()+"</td>");
                                out.println("<td>"+p.getPurchasedPrice()+"</td>");
                                out.println("<td>"+p.getRetailPrice()+"</td>");
                                out.println("<td>"+p.getCategory()+"</td>");
                                out.println("<td>"+p.getBrand()+"</td>");
                                out.println("<td>"+p.getProductDetails()+"</td>");
                                out.println("<td>"+p.getRatingAverage()+"</td>");
                                out.println("<td>"+p.getProductImage()+"</td>");   
                                out.println("<td><a href=\"/shop_sellers_dashboard/products?productId="+productId+"\">Edit</a></td>");   
                            out.println("</tr>");
                        }
                        else
                        {
                            out.println("<tr class=\"color-row\">");
                            out.println("<form method=\"POST\" action=\"/shop_sellers_dashboard/products\">");
                                out.println("<td><input name=\"productId\" type=\"number\" step=1 value=\""+p.getProductId()+"\" placeholder=\""+p.getProductId()+"\"></td>");
                                out.println("<td><input name=\"productName\" value=\""+p.getProductName()+"\" placeholder=\""+p.getProductName()+"\"></input></td>");
                                out.println("<td><input name=\"instockQuantity\" type=\"number\" step=5 value=\""+p.getInstockQuantity()+"\" placeholder=\""+p.getInstockQuantity()+"\"></td>");
                                out.println("<td><input name=\"soldQuantity\" type=\"number\" step=5 value=\""+p.getSoldQuantity()+"\" placeholder=\""+p.getSoldQuantity()+"\"></td>");
                                out.println("<td><input name=\"purchasedPrice\" type=\"number\" step=0.1 value=\""+p.getPurchasedPrice()+"\" placeholder=\""+p.getPurchasedPrice()+"\"></td>");
                                out.println("<td><input name=\"retailPrice\" type=\"number\" step=0.1 value=\""+p.getRetailPrice()+"\" placeholder=\""+p.getRetailPrice()+"\"></td>");
                                out.println("<td><input name=\"category\" value=\""+p.getCategory()+"\" placeholder=\""+p.getCategory()+"\"></input></td>");
                                out.println("<td><input name=\"brand\" value=\""+p.getBrand()+"\" placeholder=\""+p.getBrand()+"\"></input></td>");
                                out.println("<td><input name=\"productDetails\" value=\""+p.getProductDetails()+"\" placeholder=\""+p.getProductDetails()+"\"></input></td>");
                                out.println("<td><input name=\"ratingAverage\" type=\"number\" step=0.1 value=\""+p.getRatingAverage()+"\" placeholder=\""+p.getRatingAverage()+"\"></td>");
                                out.println("<td><input name=\"productImage\" type=\"text\" value=\""+p.getProductImage()+"\" placeholder=\""+p.getProductImage()+"\"></td>");   
                                out.println("<td><button type=\"submit\">Update</button></td>");   
                            out.println("</form>");
                            out.println("</tr>");
                        }
                    }
                     out.println("<form method=\"POST\" action=\"/shop_sellers_dashboard/products\">");
                                out.println("<td><input name=\"productId\" type=\"number\" step=1 value=\""+"\" placeholder=\""+"\"></td>");
                                out.println("<td><input name=\"productName\" value=\""+"\" placeholder=\""+"\"></input></td>");
                                out.println("<td><input name=\"instockQuantity\" type=\"number\" step=5 value=\""+"\" placeholder=\""+"\"></td>");
                                out.println("<td><input name=\"soldQuantity\" type=\"number\" step=5 value=\""+"\" placeholder=\""+"\"></td>");
                                out.println("<td><input name=\"purchasedPrice\" type=\"number\" step=0.1 value=\""+"\" placeholder=\""+"\"></td>");
                                out.println("<td><input name=\"retailPrice\" type=\"number\" step=0.1 value=\""+"\" placeholder=\""+"\"></td>");
                                out.println("<td><input name=\"category\" value=\""+"\" placeholder=\""+"\"></input></td>");
                                out.println("<td><input name=\"brand\" value=\""+"\" placeholder=\""+"\"></input></td>");
                                out.println("<td><input name=\"productDetails\" value=\""+"\" placeholder=\""+"\"></input></td>");
                                out.println("<td><input name=\"ratingAverage\" type=\"number\" step=0.1 value=\""+"\" placeholder=\""+"\"></td>");
                                out.println("<td><input name=\"productImage\" type=\"text\" value=\""+"\" placeholder=\""+"\"></td>");   
                                out.println("<td><button type=\"submit\">Add</button></td>");   
                            out.println("</form>");
                    out.println("</tbody>");
                }        
            %>
        </table>
    </body>
</html>
