/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.CathegoryDao;
import com.projekt.projectztp.dao.ProductDao;
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
        System.out.println(manageProductForm.getProductToDelete());
        Product product = productDao.findByName(manageProductForm.getProductToDelete());
        System.out.println(product.getName());
        productDao.delete(product);
        return "redirect:/manageProduct";
    }
}
