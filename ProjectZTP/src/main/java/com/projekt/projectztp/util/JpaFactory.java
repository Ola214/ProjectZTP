/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Olaa
 */
public class JpaFactory {

    private static JpaFactory instance;
    private EntityManagerFactory emf;

    private JpaFactory() {
        emf = Persistence.createEntityManagerFactory("com.projekt_ProjectZTP_war_1.0PU");
    }

    public static JpaFactory getInstanance() {
        if (instance==null) {
            instance = new JpaFactory();
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        return getInstanance().emf.createEntityManager();
    }



}
