/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.UserTypeDao;
import com.projekt.projectztp.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Olaa
 */
@Controller
public class ProbnyController {

/*   @Autowired
    UserTypeDao userTypeDao;*/

    @RequestMapping("/")
    public String listaKotow(Model model) {
     /*   UserType userType = new UserType();
        userType.setName("admin");
        userTypeDao.save(userType);*/
        
        return "index";
    }
}
