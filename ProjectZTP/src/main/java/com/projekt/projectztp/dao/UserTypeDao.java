/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.UserType;

/**
 *
 * @author Olaa
 */
public interface UserTypeDao extends GenericDao<UserType,Short>  {
    public UserType findByName(String name);
}
