/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.entity.Product;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class Chocolate extends Extra{
    
     private IProduct iproduct;
    private Product product;
    Long id;
    
    String name;
    
    float price;
    
    long quantity;
    public Chocolate(IProduct iproduct, Product product){
        price = iproduct.price() + product.getPrice();
        name = iproduct.about() + " + Chocolate";
        quantity = iproduct.quantity();
        id = iproduct.getId();
        this.iproduct = iproduct;
        this.product = product;
    }
    
    
    @Override
    public String about() {
        return iproduct.about() + " + Chocolate";
    }

    @Override
    public float price() {
        return iproduct.price() + product.getPrice();
    }

    @Override
    public long quantity() {
        return iproduct.quantity();
    }
    
    public Long getId(){
        return id;
    }
}
