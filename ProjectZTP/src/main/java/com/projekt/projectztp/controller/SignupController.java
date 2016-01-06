/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.UserDao;
import com.projekt.projectztp.dao.UserStatusDao;
import com.projekt.projectztp.dao.UserTypeDao;
import com.projekt.projectztp.entity.UserStatus;
import com.projekt.projectztp.entity.UserType;
import com.projekt.projectztp.form.IUser;
import com.projekt.projectztp.form.UsersFactory;
import com.projekt.projectztp.formToControllers.LoginForm;
import com.projekt.projectztp.formToControllers.SignupForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class SignupController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserStatusDao userStatusDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @RequestMapping("/signup")
    public String frontSignup(Model model) {
        SignupForm signupForm = new SignupForm();
        model.addAttribute("signupForm", signupForm);
        return "signup";
    }

    @RequestMapping("/postSignup")
    public String postSignup(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Cos poszlo nie tak");

        }
        UsersFactory usersFactory = new UsersFactory();
        IUser user;

        UserType userType;
        UserStatus userStatus;

        if (signupForm.getUserTypeId().equals("admin")) {
            
            user = usersFactory.createUser("admin");
            user.additionalStuff(userTypeDao.findByName("admin"),userStatusDao.findByName("new"));

        } else {
            
            user = usersFactory.createUser("normalUser");
            user.additionalStuff(userTypeDao.findByName("normalUser"),userStatusDao.findByName("new"));

        }
        
        
        user.getUser().setAddress(signupForm.getAddress());
        user.getUser().setEmail(signupForm.getEmail());
        user.getUser().setLogin(signupForm.getLogin());
        user.getUser().setName(signupForm.getName());
        user.getUser().setPassword(signupForm.getPassword());
        user.getUser().setSurname(signupForm.getSurname());

        
        userDao.save(user.getUser());

        return "redirect:/";
    }
}
