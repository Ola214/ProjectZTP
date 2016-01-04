/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Olaa
 */
@Controller
public class SignupController {
    
    @RequestMapping("/signup")
    public String frontSignup(Model model) {
        return "signup";
    }

    @RequestMapping("/postSignup")
    public String postSignup(Model model) {
        return "index";
    }
}
