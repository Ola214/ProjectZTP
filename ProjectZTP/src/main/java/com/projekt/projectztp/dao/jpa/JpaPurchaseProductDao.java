/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao.jpa;

import com.projekt.projectztp.dao.PurchaseProductDao;
import com.projekt.projectztp.entity.PurchaseProduct;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
@Repository
public class JpaPurchaseProductDao extends GenericJpaDao<PurchaseProduct, Long> implements PurchaseProductDao {

    @Override
    public List<PurchaseProduct> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseProduct> q = em.createNamedQuery("PurchaseProduct.findAll", PurchaseProduct.class);
        List<PurchaseProduct> result = q.getResultList();
        em.close();
        return result;
    }
}
