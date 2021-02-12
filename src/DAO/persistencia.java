/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author rafa_
 */
public interface persistencia<T> {
    
    public int create(T obj);
    public List<T> read();
    public boolean update(T obj);
    public boolean delete(T obj);
    
}
