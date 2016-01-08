/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.entity.Product;
import com.projekt.projectztp.entity.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class Cake extends IProduct{

    private Product product;
    private PurchaseProduct purchaseProduct;
    Long id;
    
    String name;
    
    float price;
    
    long quantity;
    
    public Cake(Product product, PurchaseProduct purchaseProduct){
        name = "Cake";
        price = product.getPrice();
        quantity = purchaseProduct.getQuantity();
        id = purchaseProduct.getPurchaseId().getId();
        this.product = product;
        this.purchaseProduct = purchaseProduct;
    }
    
    public float price(){
        return product.getPrice();
    }
    
    public long quantity(){
        return purchaseProduct.getQuantity();
    }
    
    public Long getId(){
        return id;
    }
    
    @Override
    public String about() {
        return "Cake";
    }
    
}
