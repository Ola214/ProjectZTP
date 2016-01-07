/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.ProductDao;
import com.projekt.projectztp.dao.PurchaseDao;
import com.projekt.projectztp.dao.PurchaseProductDao;
import com.projekt.projectztp.entity.Purchase;
import com.projekt.projectztp.entity.PurchaseProduct;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.formToControllers.BinForm;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Olaa
 */
@Controller
public class BinController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PurchaseDao purchaseDao;
    
    @Autowired
    private PurchaseProductDao purchaseProductDao;

    @RequestMapping("/frontBin")
    public String frontBin(Model model, HttpServletRequest request, @ModelAttribute("binForm") @Valid BinForm binForm2, BindingResult result) {
        if (request.getMethod().equalsIgnoreCase("get")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("User");

            if (user == null) {
                return "redirect:/";
            }

            BinForm binForm = new BinForm();
            binForm.setUser(user);
            binForm.setProductList(productDao.findAllNormal());
            binForm.setExtraList(productDao.findAllExtra());
            binForm.setPurchaseProductAddedList(purchaseProductDao.findAllNullForUser(user.getLogin()));
            List<PurchaseProduct> purchaseProductListToConvert = purchaseProductDao.findAllNullForUser(user.getLogin());
            List<Purchase> purchaseListToAdd = new ArrayList<Purchase>();
            for(PurchaseProduct purchaseProduct: purchaseProductListToConvert){
                if(!purchaseListToAdd.contains(purchaseProduct.getPurchaseId())){
                    purchaseListToAdd.add(purchaseProduct.getPurchaseId());
                }  
            }
            binForm.setPurchaseAddedList(purchaseListToAdd);
            model.addAttribute("binForm", binForm);
            return "bin";
        } else {
            model.addAttribute("binForm", binForm2);
            return "bin";
        }

    }

    @RequestMapping("/addPurchaseBin")
    public String addPurchaseBin(Model model, HttpServletRequest request, @ModelAttribute("binForm") @Valid BinForm binForm, BindingResult result) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        
        Purchase purchase = new Purchase();
        purchase.setUserId(user);
        purchaseDao.save(purchase);
        List<Purchase> purchaseList2 = purchaseDao.findAll();
        purchase = purchaseList2.get(0);
        for(Purchase p: purchaseList2){
            if(p.getId()>purchase.getId()){
                purchase = p;
            }
        }
        
        PurchaseProduct extra = null;
        PurchaseProduct normal = new PurchaseProduct();
        List<PurchaseProduct> purchaseProductAddedList = binForm.getPurchaseProductAddedList();
        
        if (!binForm.getExtraName().equals("")) {
            extra = new PurchaseProduct();
            extra.setProductId(productDao.findByName(binForm.getExtraName()));
            extra.setQuantity(Long.parseLong(binForm.getQuantity()));
            extra.setPurchaseId(purchase);
            purchaseProductDao.save(extra);
            
        } 
        normal.setProductId(productDao.findByName(binForm.getProductName()));
        normal.setQuantity(Long.parseLong(binForm.getQuantity()));
        normal.setPurchaseId(purchase);
        purchaseProductDao.save(normal);
        
        
        
        model.addAttribute("binForm", binForm);
        return "redirect:/frontBin";
    }

    @RequestMapping("/editPurchaseBin")
    public String editPurchaseBin(Model model, HttpServletRequest request, @ModelAttribute("binForm") @Valid BinForm binForm, BindingResult result) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        
        Purchase purchase = purchaseDao.findById(Long.parseLong(binForm.getPurchaseId()));
        List<PurchaseProduct> purchaseProduct3 = purchase.getPurchaseProductList();
        for(PurchaseProduct po: purchaseProduct3){
            purchaseProductDao.delete(po);
        }
        
        purchase.setPurchaseProductList(null);
        
        PurchaseProduct extra = null;
        PurchaseProduct normal = new PurchaseProduct();
        List<PurchaseProduct> purchaseProductAddedList = binForm.getPurchaseProductAddedList();
        
        if (!binForm.getExtraName().equals("")) {
            extra = new PurchaseProduct();
            extra.setProductId(productDao.findByName(binForm.getExtraName()));
            extra.setQuantity(Long.parseLong(binForm.getQuantity()));
            extra.setPurchaseId(purchase);
            purchaseProductDao.save(extra);
            
        } 
        normal.setProductId(productDao.findByName(binForm.getProductName()));
        normal.setQuantity(Long.parseLong(binForm.getQuantity()));
        normal.setPurchaseId(purchase);
        purchaseProductDao.save(normal);
        purchaseDao.update(purchase);
        
        
        model.addAttribute("binForm", binForm);
        return "redirect:/frontBin";
    }

    @RequestMapping("/deletePurchaseBin")
    public String deletePurchaseBin(Model model, HttpServletRequest request, @ModelAttribute("binForm") @Valid BinForm binForm, BindingResult result) {
        purchaseDao.delete(purchaseDao.findById(Long.parseLong(binForm.getPurchaseId())));
        model.addAttribute("binForm", binForm);
        return "redirect:/frontBin";
    }

    
}
