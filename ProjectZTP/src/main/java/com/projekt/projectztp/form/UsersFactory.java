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
public class UsersFactory {
    public IUser createUser(String userType){
        if(userType.equals("normalUser"))
            return new NormalUser();
        else if(userType.equals("admin"))
            return new Admin();
        else 
            return null;
    }
}
