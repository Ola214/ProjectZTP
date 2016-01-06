/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.controller;

import com.projekt.projectztp.dao.UserDao;
import com.projekt.projectztp.dao.UserStatusDao;
import com.projekt.projectztp.dao.UserTypeDao;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.entity.UserStatus;
import com.projekt.projectztp.entity.UserType;
import com.projekt.projectztp.formToControllers.ManageUserForm;
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
public class ManageUserController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserTypeDao userTypeDao;
    
    @Autowired
    private UserStatusDao userStatusDao;
    
    @RequestMapping("/manageUser")
    public String frontManageUser(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        
        if((user == null)||(user.getUserTypeId().getName().equals("normalUser"))){
            return "redirect:/";
        }
            
        
        ManageUserForm manageUserForm = new ManageUserForm();
        manageUserForm.setUserList(userDao.findAllNormal());
        model.addAttribute("manageUserForm", manageUserForm);
        return "manageUser";
    }
    
    @RequestMapping("/deleteManageUser")
    public String deleteManageUser(@ModelAttribute("manageUserForm") @Valid ManageUserForm manageUserForm, BindingResult result){
        User userToDelete = userDao.findByLogin(manageUserForm.getLoginToDelete());
        userDao.delete(userToDelete);
        return "redirect:/manageUser";
    }
    
    @RequestMapping("/editManageUser")
    public String editManageUser(@ModelAttribute("manageUserForm") @Valid ManageUserForm manageUserForm, BindingResult result){
        User userToEdit = userDao.findByLogin(manageUserForm.getLoginToEdit());
        UserType userType = userTypeDao.findByName(manageUserForm.getTypeToEdit());
        UserStatus userStatus = userStatusDao.findByName(manageUserForm.getStatusToEdit());
        userToEdit.setUserStatusId(userStatus);
        userToEdit.setUserTypeId(userType);
        userDao.update(userToEdit);
        return "redirect:/manageUser";
    }
    
    }

