/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.formToControllers;

import com.projekt.projectztp.entity.Cathegory;
import com.projekt.projectztp.entity.Product;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class ManageProductForm {
    private List<Product> productList;
    private List<Cathegory> cathegoryList;
    private String productToDelete;
    
}
