/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.Product;
import com.projekt.projectztp.entity.User;
import java.util.List;

/**
 *
 * @author Olaa
 */
public interface UserDao extends GenericDao<User, Long> {

    public List<User> findAll();
    
    public User findByLogin(String login);
    
    public List<User> findAllNormal();

    public User findByLoginAndPassword(String login, String password);
}
