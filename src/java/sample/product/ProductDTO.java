/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.io.Serializable;

/**
 *
 * @author Phung Nguyen
 */
public class ProductDTO implements Serializable{
    private String productID;
    private String name;
    private String brand;
    private float price;
    private int quantity =1 ;
    private String status;
    private String type;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String name, String brand, float price, int quantity, String status, String type) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.type = type;
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
            
}
