/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.projekt.projectztp.dao.PurchaseDao;
import com.projekt.projectztp.dao.PurchaseProductDao;
import com.projekt.projectztp.formToControllers.ManagePurchaseForm;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.entity.Purchase;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Olaa
 */
@Controller
public class ManagePurchaseController {
    
    @Autowired
    private PurchaseDao purchaseDao;
    
    @Autowired
    private PurchaseProductDao purchaseProductDao;
    
    @RequestMapping("/managePurchase")
    public String frontManagePurchase(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        
        if((user == null)||(user.getUserTypeId().getName().equals("normalUser"))){
            return "redirect:/";
        }
         
        ManagePurchaseForm managePurchaseForm = new ManagePurchaseForm();
        managePurchaseForm.setPurchaseProductList(purchaseProductDao.findAll());
        managePurchaseForm.setPurchaseListNull(purchaseDao.findAllNull());
        model.addAttribute("managePurchaseForm", managePurchaseForm);
        return "managePurchase";
    }
    
    @RequestMapping("/rejectManagePurchase")
    public String rejectManagePurchase(@ModelAttribute("managePurchaseForm") @Valid ManagePurchaseForm managePurchaseForm, BindingResult result){
        purchaseDao.delete(purchaseDao.findById(managePurchaseForm.getPurchaseToReject()));
        return "redirect:/managePurchase";
    }
    
    @RequestMapping("/acceptManagePurchase")
    public String acceptManagePurchase(@ModelAttribute("managePurchaseForm") @Valid ManagePurchaseForm managePurchaseForm, BindingResult result){
        Purchase purchase = purchaseDao.findById(managePurchaseForm.getPurchaseToAccept());
        purchase.setAcceptanceDate(new Date());
        purchaseDao.update(purchase);
        return "redirect:/managePurchase";
    }
}
