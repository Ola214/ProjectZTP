/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao.jpa;

import com.projekt.projectztp.dao.UserDao;
import com.projekt.projectztp.entity.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
@Repository
public class JpaUserDao extends GenericJpaDao<User, Long> implements UserDao{
    
}
