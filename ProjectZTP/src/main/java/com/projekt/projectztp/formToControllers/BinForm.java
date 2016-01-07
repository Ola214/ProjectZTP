/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.formToControllers;

import com.projekt.projectztp.entity.Product;
import com.projekt.projectztp.entity.Purchase;
import com.projekt.projectztp.entity.PurchaseProduct;
import com.projekt.projectztp.entity.User;
import com.projekt.projectztp.form.IProduct;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class BinForm {
    private User user;
    private List<Product> productList;
    private List<Product> extraList;
    private String purchaseId;
    private String productName;
    private String extraName;
    private String quantity;
    private List<PurchaseProduct> purchaseProductAddedList;
    private List<Purchase> purchaseAddedList;
}
