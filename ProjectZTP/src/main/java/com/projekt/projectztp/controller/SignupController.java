/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.form.IUser;
import com.projekt.projectztp.form.UsersFactory;
import com.projekt.projectztp.formToControllers.LoginForm;
import com.projekt.projectztp.formToControllers.SignupForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    
    @RequestMapping("/signup")
    public String frontSignup(Model model) {
        SignupForm signupForm = new SignupForm();
        model.addAttribute("signupForm", signupForm);
        return "signup";
    }

    @RequestMapping("/postSignup")
    public String postSignup(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("Cos poszlo nie tak");
        }
        UsersFactory usersFactory = new UsersFactory();
        IUser user;
        if(signupForm.getUserTypeId() == 1){
            user = usersFactory.createUser("admin");
            user.setAddress(signupForm.getAddress());
            user.setEmail(signupForm.getEmail());
            user.setLogin(signupForm.getLogin());
            user.setName(signupForm.getName());
            user.setPassword(signupForm.getPassword());
            user.setSurname(signupForm.getSurname());
        }else{
            user = usersFactory.createUser("normalUser");
            user.setAddress(signupForm.getAddress());
            user.setEmail(signupForm.getEmail());
            user.setLogin(signupForm.getLogin());
            user.setName(signupForm.getName());
            user.setPassword(signupForm.getPassword());
            user.setSurname(signupForm.getSurname());
        }
        return "redirect:/";
    }
}
