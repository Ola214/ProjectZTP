/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao.jpa;

import com.projekt.projectztp.dao.UserTypeDao;
import com.projekt.projectztp.entity.UserType;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
@Repository
public class JpaUserTypeDao extends GenericJpaDao<UserType, Short> implements UserTypeDao{
    public UserType findByName(String name){
        EntityManager em = getEntityManager();
        TypedQuery<UserType> q = em.createNamedQuery("UserType.findByName",UserType.class);
        q.setParameter("name", name);
        UserType result = q.getSingleResult();
        em.close();
        return result;
    }
}
