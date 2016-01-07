/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.ProductDao;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.formToControllers.BinForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Olaa
 */
@Controller
public class BinController {
    
    @Autowired
    private ProductDao productDao;
        
    @RequestMapping("/frontBin")
    public String frontBin(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        
        if(user == null){
            return "redirect:/";
        }
        
        BinForm binForm = new BinForm();
        binForm.setUser(user);
        binForm.setProductList(productDao.findAllNormal());
        binForm.setExtraList(productDao.findAllExtra());
        
        return "bin";
    }
    
    @RequestMapping("/addPurchaseBin")
    public String addPurchaseBin(Model model, HttpServletRequest request){
        
    }
    
    @RequestMapping("/editPurchaseBin")
    public String editPurchaseBin(Model model, HttpServletRequest request){
        
    }
    
    @RequestMapping("/deletePurchaseBin")
    public String deletePurchaseBin(Model model, HttpServletRequest request){
        
    }
    
    @RequestMapping("/approveBin")
    public String approveBin(Model model, HttpServletRequest request){
        
    }
}
