/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.Cathegory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olaa
 */
@Stateless
public class CathegoryFacade extends AbstractFacade<Cathegory> {
    @PersistenceContext(unitName = "com.projekt_ProjectZTP_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CathegoryFacade() {
        super(Cathegory.class);
    }
    
}
