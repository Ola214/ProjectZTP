/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.PurchaseProduct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olaa
 */
@Stateless
public class PurchaseProductFacade extends AbstractFacade<PurchaseProduct> {
    @PersistenceContext(unitName = "com.projekt_ProjectZTP_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseProductFacade() {
        super(PurchaseProduct.class);
    }
    
}
