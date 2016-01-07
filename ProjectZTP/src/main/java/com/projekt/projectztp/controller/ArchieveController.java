/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.PurchaseProductDao;
import com.projekt.projectztp.dao.UserDao;
import com.projekt.projectztp.entity.PurchaseProduct;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.formToControllers.ArchieveForm;
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
public class ArchieveController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PurchaseProductDao purchaseProductDao;
    
    @RequestMapping("/frontArchieve")
    public String frontArchieve(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        ArchieveForm archieveForm = new ArchieveForm();
        if(user == null){
            return "redirect:/";
        }else if(user.getUserTypeId().getName().equals("normalUser")){
            archieveForm.setUserLogin(user.getLogin());
            model.addAttribute("archieveForm", archieveForm);
            return "redirect:/archieveUser";
        }else{
            model.addAttribute("archieveForm", archieveForm);
            return "redirect:/archieve";
        }
    }
    
    @RequestMapping("/archieve")
    public String archieve(Model model, @ModelAttribute("archieveForm") @Valid ArchieveForm archieveForm, BindingResult result){
        archieveForm.setUsersList(userDao.findAll());
        model.addAttribute("archieveForm", archieveForm);
        return "archieve";
    }
    
    @RequestMapping("/archieveUser")
    public String archieveUser(HttpServletRequest request, Model model, @ModelAttribute("archieveForm") @Valid ArchieveForm archieveForm, BindingResult result){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        if(user.getUserTypeId().getName().equals("normalUser")){
            model.addAttribute("purchaseProductList", purchaseProductDao.findByLogin(user.getLogin())); 
            return "archieveUser";
        }
        
        model.addAttribute("purchaseProductList", purchaseProductDao.findByLogin(archieveForm.getUserLogin())); 
        return "archieveUser";
    }
}
