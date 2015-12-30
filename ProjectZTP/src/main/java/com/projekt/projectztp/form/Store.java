/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.form;

import com.projekt.projectztp.dao.ProductDao;
import com.projekt.projectztp.entity.Product;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Olaa
 */
public class Store {
    
    @Autowired
    ProductDao productDao;
    
    List<Product> products;
    List<Product> productsToName;
    List<Product> productsToPrice;
    
    public Store(){
        products = productDao.findAll();
        productsToName = products;
        productsToPrice = products;
        Collections.sort(productsToName, new Comparator<Product>(){
            @Override
            public int compare(Product product1, Product product2){
                return product1.getName().compareTo(product2.getName());
            }
        });
        Collections.sort(productsToPrice, new Comparator<Product>(){
            @Override
            public int compare(Product product1, Product product2){
                return Float.compare(product1.getPrice(),product2.getPrice());
            }
        });
    }
    
    public Iterator<Product> createNameIterator(int x, int y) {
        return new NameIterator(x, y);
    }

    public Iterator<Product> createPriceIterator(int x, int y) {
        return new PriceIterator(x, y);
    }


    class NameIterator implements Iterator<Product> {
        int x = 0, y = 0;

        public NameIterator() {
        }

        public NameIterator(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean hasNext() {
            if (y < matrix.length && x < matrix[y].length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Product next() {
            if (x == matrix[y].length - 1) {
                Product tmp = matrix[y][x];
                x = 0;
                y++;
                return tmp;
            }
            return matrix[y][x++];
        }

    }

    class PriceIterator implements Iterator<Product> {
        int x = 0, y = 0;

        public PriceIterator() {
        }

        public PriceIterator(int x, int y) {
            this.x = x;
            this.y = y;
        }

         @Override
        public boolean hasNext() {
            if (y < matrix.length && x < matrix[y].length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Product next() {
            if (x == matrix[y].length - 1) {
                Product tmp = matrix[y][x];
                x = 0;
                y++;
                return tmp;
            }
            return matrix[y][x++];
        }

    }
}