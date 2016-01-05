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
import com.projekt.projectztp.entity.UserStatus;
import com.projekt.projectztp.entity.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class NormalUser implements IUser{

    private User user;
    
    
    public NormalUser(){
        user = new User();
        
    }
    
    public void additionalStuff(UserType userType, UserStatus userStatus){
        user.setUserTypeId(userType);
        user.setUserStatusId(userStatus);
    }

    
}
