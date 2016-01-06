/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.formToControllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class SignupForm {
    
    @NotNull
    @Size(min = 1, max = 255)
    private String address;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String userTypeId;
    private Short userStatusId;
    
    public SignupForm(){
        userStatusId = 1;
    }

    
    
    
}
