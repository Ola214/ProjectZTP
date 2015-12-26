/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

/**
 *
 * @author Olaa
 */
public interface IProduct {
    
    Long id = null;
    
    String name = null;
    
    float price = 0;
    
    void add();
    
    void delete();
    
    void edit();
    
}
