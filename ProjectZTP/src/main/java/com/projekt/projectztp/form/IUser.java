/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.entity.Purchase;

/**
 *
 * @author Olaa
 */


public interface IUser {
    String getAddress();
    void setAddress(String address);
    String getLogin();
    void setLogin(String login);
    String getPassword();
    void setPassword(String password);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    String getEmail();
    void setEmail(String email);
    Short getUserTypeId();

    
    void editAccount();
    void addOrder(Purchase p);   
}
