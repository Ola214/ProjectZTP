/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.formToControllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Olaa
 */
public class SignupForm {
    
    @NotNull
    @Size(min = 1, max = 255)
    private String address;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Short userTypeId;
    private Short userStatusId;
    
    public SignupForm(){
        userStatusId = 1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Short userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Short getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(Short userStatusId) {
        this.userStatusId = userStatusId;
    }
    
    
}
