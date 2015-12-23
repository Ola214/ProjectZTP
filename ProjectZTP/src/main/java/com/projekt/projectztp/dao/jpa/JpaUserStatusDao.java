/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao.jpa;

import com.projekt.projectztp.dao.CathegoryDao;
import com.projekt.projectztp.dao.UserStatusDao;
import com.projekt.projectztp.entity.Cathegory;
import com.projekt.projectztp.entity.UserStatus;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */

@Repository
public class JpaUserStatusDao extends GenericJpaDao<UserStatus, Short> implements UserStatusDao{
    
}
