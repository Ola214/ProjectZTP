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
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */

@Repository
public class JpaUserStatusDao extends GenericJpaDao<UserStatus, Short> implements UserStatusDao{
    public UserStatus findByName(String name){
        EntityManager em = getEntityManager();
        TypedQuery<UserStatus> q = em.createNamedQuery("UserStatus.findByName",UserStatus.class);
        q.setParameter("name", name);
        UserStatus result = q.getSingleResult();
        em.close();
        return result;
    }
}
