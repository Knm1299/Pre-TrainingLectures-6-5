package com.revature;

import java.util.List;

public interface CRUD<E> {

    E addElement(E element);
    List<E> getAllElements();
    E getElementById(int id);
    E updateElement(int id, E newElement);
    Boolean deleteElementById(int id);
    
}
