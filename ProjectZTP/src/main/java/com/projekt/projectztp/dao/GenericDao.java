/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.projekt.projectztp.dao;
public interface GenericDao<T,K>  {
    void save(T t);
    void delete (T t);
    void update (T t);
    T findById(K id);
}
