/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao.jpa;

import com.projekt.projectztp.dao.ProductDao;
import com.projekt.projectztp.entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
@Repository
public class JpaProductDao extends GenericJpaDao<Product, Long> implements ProductDao{
    
    @Override
    public List<Product> findAllNormal(){
        EntityManager em = getEntityManager();
        TypedQuery<Product> q = em.createNamedQuery("Product.findAllNormal",Product.class);
        List<Product> result = q.getResultList();
        em.close();
        return result;
    }
    
    @Override
    public List<Product> findAllExtra(){
        EntityManager em = getEntityManager();
        TypedQuery<Product> q = em.createNamedQuery("Product.findAllExtra",Product.class);
        List<Product> result = q.getResultList();
        em.close();
        return result;
    }
    
    @Override
    public List<Product> findAll(){
        EntityManager em = getEntityManager();
        TypedQuery<Product> q = em.createNamedQuery("Product.findAll",Product.class);
        List<Product> result = q.getResultList();
        em.close();
        return result;
    }
    
    @Override
    public Product findByName(String name){
        EntityManager em = getEntityManager();
        TypedQuery<Product> q = em.createNamedQuery("Product.findByName",Product.class);
        q.setParameter("name", name);
        Product result = q.getSingleResult();
        em.close();
        return result;
    }
}
