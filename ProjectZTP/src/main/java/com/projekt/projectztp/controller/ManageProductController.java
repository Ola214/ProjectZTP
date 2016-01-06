/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.CathegoryDao;
import com.projekt.projectztp.dao.ProductDao;
import com.projekt.projectztp.entity.Cathegory;
import com.projekt.projectztp.entity.Product;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.formToControllers.ManageProductForm;
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
public class ManageProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CathegoryDao cathegoryDao;

    @RequestMapping("/manageProduct")
    public String frontProduct(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        ManageProductForm manageProductForm = new ManageProductForm();
        manageProductForm.setCathegoryList(cathegoryDao.findAll());
        manageProductForm.setProductList(productDao.findAll());

        if (user == null) {
            return "redirect:/";
        } else if (user.getUserTypeId().getId() == 1) {
            model.addAttribute("manageProductForm", manageProductForm);
            return "manageProduct";
        } else {
            return "redirect:/";
        }
    }
    
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@ModelAttribute("manageProductForm") @Valid ManageProductForm manageProductForm, BindingResult result){
        Product product = productDao.findByName(manageProductForm.getProductToDelete());
        productDao.delete(product);
        return "redirect:/manageProduct";
    }
    
    @RequestMapping("/addProduct")
    public String addProduct(@ModelAttribute("manageProductForm") @Valid ManageProductForm manageProductForm, BindingResult result){
        Product product = new Product();
        product.setName(manageProductForm.getAddProductForm().getName());
        product.setPrice(Float.parseFloat(manageProductForm.getAddProductForm().getPrice()));
        Cathegory cathegory = cathegoryDao.findByName(manageProductForm.getAddProductForm().getCathegoryName());
        product.setCathegoryId(cathegory);
        productDao.save(product);
        return "redirect:/manageProduct";
    }
    
    @RequestMapping("/editProduct")
    public String editProduct(@ModelAttribute("manageProductForm") @Valid ManageProductForm manageProductForm, BindingResult result){
        System.out.println(manageProductForm.getEditProductForm().getOldName());
        System.out.println(manageProductForm.getEditProductForm().getName());
        System.out.println(manageProductForm.getEditProductForm().getPrice());
        System.out.println(manageProductForm.getEditProductForm().getCathegoryName());
        Product product = productDao.findByName(manageProductForm.getEditProductForm().getOldName());
        product.setName(manageProductForm.getEditProductForm().getName());
        product.setPrice(Float.parseFloat(manageProductForm.getEditProductForm().getPrice()));
        Cathegory cathegory = cathegoryDao.findByName(manageProductForm.getEditProductForm().getCathegoryName());
        product.setCathegoryId(cathegory);
        productDao.update(product);
        return "redirect:/manageProduct";
    }
}
