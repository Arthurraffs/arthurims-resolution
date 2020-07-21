package com.qa.ims.services;

import java.util.List;

public interface CrudServices<T> {

    List<T> readAll();
     
    T create(T t);
     
    T update(T t);
 
    void delete(int id);

}
