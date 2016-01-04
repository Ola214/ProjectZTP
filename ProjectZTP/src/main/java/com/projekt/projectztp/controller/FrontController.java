/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.ProductDao;
import com.projekt.projectztp.entity.Product;
import com.projekt.projectztp.form.Store;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Olaa
 */
@Controller
public class FrontController {
   
    @Autowired
    ProductDao productDao;
    
    @RequestMapping("/")
    public String frontPage(Model model) {
        Iterator<Product> iterator;
        List<Product> products = productDao.findAll();
        /*Store store = new Store(products);

        iterator = store.createNameIterator();
        List<Product> produkty = new ArrayList<Product>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            produkty.add(product);
        }
        model.addAttribute("produkty", produkty);*/
        model.addAttribute("produkty", products);

        return "index";
    }
    
}
