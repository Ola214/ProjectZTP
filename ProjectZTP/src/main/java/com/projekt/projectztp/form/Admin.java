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

@Getter
@Setter
public class Admin implements IUser{
    
    private User user;
    
    @Autowired
    private UserTypeDao userTypeDao;
    
    @Autowired
    private UserStatusDao userStatusDao;
    
    public Admin(){
        user = new User();
        
    }
    
    public void additionalStuff(UserType userType, UserStatus userStatus){
        user.setUserStatusId(userStatus);
        user.setUserTypeId(userType);
    }

    
}
