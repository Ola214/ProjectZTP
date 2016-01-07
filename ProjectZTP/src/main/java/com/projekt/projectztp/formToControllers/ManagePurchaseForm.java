/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.formToControllers;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.projekt.projectztp.entity.Purchase;


/**
 *
 * @author Olaa
 */
@Getter
@Setter
public class ManagePurchaseForm {
    private List<Purchase> purchaseList;
    private List<Purchase> purchaseListNull;
    private Long purchaseToAccept;
    private Long purchaseToReject;
}
