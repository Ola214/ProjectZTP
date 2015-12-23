/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.entity.Purchase;
import com.projekt.projectztp.entity.User;


public class Admin implements IUser{
    
    private User admin;
    
    public Admin(){
        admin = new User();
        admin.setUserStatusId(null);
        admin.setUserTypeId(null);
    }

    @Override
    public void editAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrder(Purchase p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
