/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao.jpa;

import com.projekt.projectztp.dao.UserDao;
import com.projekt.projectztp.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
@Repository
public class JpaUserDao extends GenericJpaDao<User, Long> implements UserDao{
    
    public User findByLoginAndPassword(String login, String password) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<User> q = em.createNamedQuery("User.findByLoginAndPassword", User.class);
            q.setParameter("login", login);
            q.setParameter("password", password);
            User result = q.getSingleResult();
            //em.close();
            return result;
        } catch (NoResultException nre) {
            return null;
        }
    }
}
