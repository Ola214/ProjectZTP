/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.entity.Purchase;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.entity.UserStatus;
import com.projekt.projectztp.entity.UserType;

/**
 *
 * @author Olaa
 */


public interface IUser {
    User getUser();
    void setUser(User user); 
    void additionalStuff(UserType userType, UserStatus userStatus);
}
