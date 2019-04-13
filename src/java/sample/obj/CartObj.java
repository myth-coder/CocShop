/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.obj;

import java.io.Serializable;
import java.util.HashMap;
import sample.product.ProductDTO;

/**
 *
 * @author Phung Nguyen
 */
public class CartObj implements Serializable{
    private String customerName;
    private HashMap<String, ProductDTO> cart;

    public CartObj() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, ProductDTO> cart) {
        this.cart = cart;
    }
    public CartObj(String customerName){
        this.customerName = customerName;
        cart = new HashMap<>();
    }
    public void addToCart(ProductDTO dto ){
        
        if(this.cart.containsKey(dto.getProductID())){
            int quantity = this.cart.get(dto.getProductID()).getQuantity() + 1;
            dto.setQuantity(quantity);
             
        }
        this.cart.put(dto.getProductID(), dto);
       
    }
    public void remove(String id){
       if(this.cart.containsKey(id)){
           this.cart.remove(id);
       }
    }
    public float getTotal(){
        float result = 0;
        for (ProductDTO dto : this.cart.values()) {
            result += dto.getPrice() * dto.getQuantity();
        }
        return result;
    }
}
