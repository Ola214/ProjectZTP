/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.UserStatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olaa
 */
@Stateless
public class UserStatusFacade extends AbstractFacade<UserStatus> {
    @PersistenceContext(unitName = "com.projekt_ProjectZTP_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserStatusFacade() {
        super(UserStatus.class);
    }
    
}
