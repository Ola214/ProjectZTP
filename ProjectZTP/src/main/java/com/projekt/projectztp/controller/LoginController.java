/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.UserDao;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.formToControllers.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class LoginController {
    
    @Autowired
    UserDao userDao;
    
    @RequestMapping("/login")
    public String frontLogin(Model model) {
        LoginForm loginForm = new LoginForm();
        model.addAttribute("loginForm", loginForm);
        return "login";
    }
    
    @RequestMapping("/postLogin")
    public String postLogin(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result) {
        String login = loginForm.getLogin();
        String password = loginForm.getPassword();
        
        User user = userDao.findByLoginAndPassword(login, password);

        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("User", user);
        }
        return "redirect:/";
    }
}
