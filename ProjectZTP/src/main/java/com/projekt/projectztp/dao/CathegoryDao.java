/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.dao;

import com.projekt.projectztp.entity.Cathegory;
import com.projekt.projectztp.entity.Purchase;
import java.util.List;

/**
 *
 * @author Olaa
 */
public interface CathegoryDao extends GenericDao<Cathegory,Short>  {
    
    public List<Cathegory> findAll();
    public Cathegory findByName(String name);
}
