/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.formToControllers;

import com.projekt.projectztp.entity.User;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class ManageUserForm {
    private List<User> userList;
    private String loginToDelete;
    private String loginToEdit;
    private String statusToEdit;
    private String typeToEdit;
}
