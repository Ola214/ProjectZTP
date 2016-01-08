/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.PurchaseProduct;
import java.util.List;

/**
 *
 * @author Olaa
 */
public interface PurchaseProductDao extends GenericDao<PurchaseProduct,Long>  {
    public List<PurchaseProduct> findAllForPurchaseId(Long purchaseId);
    public List<PurchaseProduct> findByLogin(String login);
    public List<PurchaseProduct> findAll();
    public List<PurchaseProduct> findAllNull();
    public List<PurchaseProduct> findAllNullForUser(String login);
}
