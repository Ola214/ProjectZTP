/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.dao.ProductDao;
import com.projekt.projectztp.entity.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olaa
 */
public class Store {

    List<Product> products;
    List<Product> productsToName;
    List<Product> productsToPrice;

    public Store(List<Product> products) {
        this.products = products;
        
        this.productsToName = sortByName(products);
        this.productsToPrice = sortByPrice(products);
    }

    public Iterator<Product> createNameIterator() {
        return new NameIterator(productsToName);
    }

    public Iterator<Product> createPriceIterator() {
        return new PriceIterator(productsToPrice);
    }

    class NameIterator implements Iterator<Product> {

        int x = 0;
        List<Product> productsToName;
        
        public NameIterator(List<Product> productsToName) {
             this.productsToName = productsToName;
             
        }

        @Override
        public boolean hasNext() {
            if (x < productsToName.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Product next() {
            if (hasNext()) {
                
                return (Product) productsToName.get(x++);
            } else {
                throw new NoSuchElementException("There are no elements size = " + productsToName.size());
            }
        }
        
        

    }

    class PriceIterator implements Iterator<Product> {

        int x = 0;

        List<Product> productsToPrice;
        
        public PriceIterator(List<Product> productsToPrice) {
             this.productsToPrice = productsToPrice;
        }

        @Override
        public boolean hasNext() {
            if (x < productsToPrice.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Product next() {
            if (hasNext()) {
                
                return (Product) productsToPrice.get(x++);
            } else {
                throw new NoSuchElementException("There are no elements size = " + productsToPrice.size());
            }
        }
        
        

    }

    List<Product> sortByName(List<Product> products) {
        List<Product> productsName = products;
        Product pom;
        for (int i = 0; i < productsName.size(); i++) {
            for (int j = 0; j < productsName.size() - i - 1; j++) //pętla wewnętrzna
            {
                
                if(productsName.get(j).getName().compareTo(productsName.get(j + 1).getName())>0){
                    pom = productsName.get(j);
                    productsName.set(j, productsName.get(j + 1));
                    productsName.set(j + 1, pom);
                }
            }
        }
        
        return productsName;
    }

    List<Product> sortByPrice(List<Product> products) {
        List<Product> productsPrice = products;
        
        
        Product pom;

        for (int i = 0; i < productsPrice.size(); i++) {
            for (int j = 0; j < productsPrice.size() - i - 1; j++) //pętla wewnętrzna
            {
                if(productsPrice.get(j).getPrice() > productsPrice.get(j + 1).getPrice()){
                    pom = productsPrice.get(j);
                    productsPrice.set(j, productsPrice.get(j + 1));
                    productsPrice.set(j + 1, pom);
                }
            }
        }
        
        return productsPrice;
    }

}
