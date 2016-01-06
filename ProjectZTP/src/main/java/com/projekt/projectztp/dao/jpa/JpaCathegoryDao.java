/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao.jpa;

import com.projekt.projectztp.dao.CathegoryDao;
import com.projekt.projectztp.entity.Cathegory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
@Repository
public class JpaCathegoryDao extends GenericJpaDao<Cathegory, Short> implements CathegoryDao {
    
    @Override
    public List<Cathegory> findAll(){
        EntityManager em = getEntityManager();
        TypedQuery<Cathegory> q = em.createNamedQuery("Cathegory.findAll",Cathegory.class);
        List<Cathegory> result = q.getResultList();
        em.close();
        return result;
    }
}
