package com.mecparts.dao.interfaces;

import java.util.List;

public interface IGenericDAO<T> {
    
    T create(T obj);

    List<T> readAll();
    
    T readById(long id);
    
    List<T> readByName(String nome);
    
    void update(T obj);
    
    void delete(long id);
}