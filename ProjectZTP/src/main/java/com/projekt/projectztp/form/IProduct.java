/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public abstract class IProduct {
    
    Long id;
    
    String name;
    
    float price;
    
    long quantity;
    
    public String about(){
        return name;
    }
    
    public float price(){
        return price;
    }
    
    public long quantity(){
        return quantity;
    }
    
    public Long getId(){
        return id;
    }
    
}
