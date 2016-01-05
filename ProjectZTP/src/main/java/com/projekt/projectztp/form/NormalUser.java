/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.dao.UserStatusDao;
import com.projekt.projectztp.dao.UserTypeDao;
import com.projekt.projectztp.entity.Purchase;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.entity.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class NormalUser implements IUser{

    private User user;
    
    @Autowired
    private UserTypeDao userTypeDao;
    
    @Autowired
    private UserStatusDao userStatusDao;
    
    public NormalUser(){
        user = new User();
        Short userTypeId = new Short("2");
        Short userStatusId = new Short("1");
        
        user.setUserTypeId(userTypeDao.findById(Short.parseShort("2")));
        user.setUserStatusId(userStatusDao.findById(Short.parseShort("1")));
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
