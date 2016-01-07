/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.projekt.projectztp.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.projekt.projectztp.dao.PurchaseDao;
import com.projekt.projectztp.entity.Purchase;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class JpaPurchaseDao  extends GenericJpaDao<Purchase, Long> implements PurchaseDao {
    
     @Override
    public List<Purchase> findAll(){
        EntityManager em = getEntityManager();
        TypedQuery<Purchase> q = em.createNamedQuery("Purchase.findAll",Purchase.class);
        List<Purchase> result = q.getResultList();
        em.close();
        return result;
    }
    
    
    /*@Override
    public List<PurchaseDTO> findAllPurchasesForClient(int id_customer)
    {
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseDTO> q = em.createNamedQuery("PurchaseDTO.findAllPurchasesForClient", PurchaseDTO.class);
        q.setParameter(1, id_customer);
        List<PurchaseDTO> result = q.getResultList();
        em.close();
        return result;
    }
    
    @Override
    public void deleteAllPurchasesOrderedByCustomer(int id_customer)
    {
        EntityManager em = getEntityManager();
        TypedQuery q = em.createNamedQuery("PurchaseDTO.deleteAllPurchasesOrderedByCustomer", PurchaseDTO.class);
        q.setParameter(1, id_customer);
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }*/
}
