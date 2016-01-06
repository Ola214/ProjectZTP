/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.Product;
import com.projekt.projectztp.entity.Purchase;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
@Repository
public interface ProductDao  extends GenericDao<Product,Long>  {
    
    public List<Product> findAll();
    public Product findByName(String name);
    
}
