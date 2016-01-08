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
import com.projekt.projectztp.form.Cake;
import com.projekt.projectztp.form.Chocolate;
import com.projekt.projectztp.form.Cookies;
import com.projekt.projectztp.form.IProduct;
import com.projekt.projectztp.form.PowderedSugar;
import com.projekt.projectztp.formToControllers.BinForm;
import java.util.ArrayList;
import java.util.Iterator;
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
            for (PurchaseProduct purchaseProduct : purchaseProductListToConvert) {
                if (!purchaseListToAdd.contains(purchaseProduct.getPurchaseId())) {
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
        for (Purchase p : purchaseList2) {
            if (p.getId() > purchase.getId()) {
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

        IProduct iproduct;
        if (extra == null) {
            if (normal.getProductId().getCathegoryId().getName().equals("Cookies")) {
                iproduct = new Cookies(normal.getProductId(), normal);
            } else {
                iproduct = new Cake(normal.getProductId(), normal);
            }
        } else {
            if (extra.getProductId().getName().equals("Chocolate")) {
                if (normal.getProductId().getCathegoryId().getName().equals("Cookies")) {
                    iproduct = new Chocolate(new Cookies(normal.getProductId(), normal), extra.getProductId());
                } else {
                    iproduct = new Chocolate(new Cake(normal.getProductId(), normal), extra.getProductId());
                }

            } else {
                if (normal.getProductId().getCathegoryId().getName().equals("Cookies")) {
                    iproduct = new PowderedSugar(new Cookies(normal.getProductId(), normal), extra.getProductId());
                } else {
                    iproduct = new PowderedSugar(new Cake(normal.getProductId(), normal), extra.getProductId());
                }

            }
        }
        List<IProduct> iproductList = (List<IProduct>)session.getAttribute("iproductList");
        if (iproductList == null) {
            iproductList = new ArrayList<IProduct>();
            iproductList.add(iproduct);
            session.setAttribute("iproductList", iproductList);
        } else {
            
            iproductList.add(iproduct);
           session.setAttribute("iproductList", iproductList);
        }
        
        model.addAttribute("binForm", binForm);
        return "redirect:/frontBin";
    }

    @RequestMapping("/editPurchaseBin")
    public String editPurchaseBin(Model model, HttpServletRequest request, @ModelAttribute("binForm") @Valid BinForm binForm, BindingResult result) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        List<IProduct> iproductList = (List<IProduct>) session.getAttribute("iproductList");
        IProduct iproductToRemove = null;
        if (iproductList != null) {
            for (IProduct iproduct : iproductList) {
                if (iproduct.getId().toString().equals(binForm.getPurchaseId())) {
                    iproductToRemove = iproduct;
                    
                }   
            }
            if(iproductToRemove != null){
                    iproductList.remove(iproductToRemove);
                }
        }
       session.setAttribute("iproductList", iproductList);
        
        Purchase purchase = purchaseDao.findById(Long.parseLong(binForm.getPurchaseId()));
        //List<PurchaseProduct> purchaseProduct3 = purchase.getPurchaseProductList();//tu size=0 za drugim razem i pozostalymi;/
       List<PurchaseProduct> purchaseProduct3 = purchaseProductDao.findAllForPurchaseId(purchase.getId());
         for (PurchaseProduct po : purchaseProduct3) {
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
        
        IProduct iproduct;
        if (extra == null) {
            if (normal.getProductId().getCathegoryId().getName().equals("Cookies")) {
                iproduct = new Cookies(normal.getProductId(), normal);
            } else {
                iproduct = new Cake(normal.getProductId(), normal);
            }
        } else {
            if (extra.getProductId().getName().equals("Chocolate")) {
                if (normal.getProductId().getCathegoryId().getName().equals("Cookies")) {
                    iproduct = new Chocolate(new Cookies(normal.getProductId(), normal), extra.getProductId());
                } else {
                    iproduct = new Chocolate(new Cake(normal.getProductId(), normal), extra.getProductId());
                }

            } else {
                if (normal.getProductId().getCathegoryId().getName().equals("Cookies")) {
                    iproduct = new PowderedSugar(new Cookies(normal.getProductId(), normal), extra.getProductId());
                } else {
                    iproduct = new PowderedSugar(new Cake(normal.getProductId(), normal), extra.getProductId());
                }

            }
        }
        List<IProduct> iproductList2 = (List<IProduct>)session.getAttribute("iproductList");
        if (iproductList2 == null) {
            iproductList2 = new ArrayList<IProduct>();
            iproductList2.add(iproduct);
            session.setAttribute("iproductList", iproductList2);
        } else {
            
            iproductList2.add(iproduct);
           session.setAttribute("iproductList", iproductList2);
        }

        model.addAttribute("binForm", binForm);
        return "redirect:/frontBin";
    }

    @RequestMapping("/deletePurchaseBin")
    public String deletePurchaseBin(Model model, HttpServletRequest request, @ModelAttribute("binForm") @Valid BinForm binForm, BindingResult result) {
        purchaseDao.delete(purchaseDao.findById(Long.parseLong(binForm.getPurchaseId())));
        
        HttpSession session = request.getSession();
        List<IProduct> iproductList = (List<IProduct>) session.getAttribute("iproductList");
        IProduct iproductToRemove = null;
        if (iproductList != null) {
            for (IProduct iproduct : iproductList) {
                if (iproduct.getId().toString().equals(binForm.getPurchaseId())) {
                    iproductToRemove = iproduct;
                }
            }
            if(iproductToRemove != null){
                    iproductList.remove(iproductToRemove);
                }
        }
       session.setAttribute("iproductList", iproductList);
        model.addAttribute("binForm", binForm);
        return "redirect:/frontBin";
    }

}
