/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.UserDao;
import com.projekt.projectztp.dao.UserTypeDao;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.formToControllers.SignupForm;
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
public class ManageProfileController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserTypeDao userTypeDao;
    
    @RequestMapping("/manageProfile")
    public String frontManageProfile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        SignupForm user2 = new SignupForm();
        if (user == null) {
            return "redirect:/";
        } else {
            model.addAttribute("userForm", user2);
            return "manageProfile";
        } 
    }
    
    @RequestMapping("/editProfile")
    public String editProfile(HttpServletRequest request, @ModelAttribute("userForm") @Valid SignupForm user, BindingResult result){
        HttpSession session = request.getSession();
        User user2 = (User) session.getAttribute("User");
        user2.setName(user.getName());
        user2.setSurname(user.getSurname());
        user2.setEmail(user.getEmail());
        user2.setLogin(user.getLogin());
        user2.setPassword(user.getPassword());
        user2.setAddress(user.getAddress());
        user2.setUserTypeId(userTypeDao.findByName(user.getUserTypeId()));
        userDao.update(user2);
        session.setAttribute("User", user2);
        return "redirect:/manageProfile";
    }
    
    @RequestMapping("/deleteProfile")
    public String deleteProfile(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        session.setAttribute("User", null);
        userDao.delete(user);
        return "redirect:/";
    }
}
