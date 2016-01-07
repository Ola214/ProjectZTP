/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.projekt.projectztp.dao;
import com.projekt.projectztp.entity.Purchase;
import java.util.List;


public interface PurchaseDao  extends GenericDao<Purchase,Long>  {
    public List<Purchase> findAll();
    public List<Purchase> findAllNull();
}

