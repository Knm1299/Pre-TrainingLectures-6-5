package com.revature;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCRUDImpl implements CRUD{
    private List<String> strings;

    public ArrayListCRUDImpl(){
        strings = new ArrayList<>();
    }

    @Override
    public String getByID(int id) {
        return strings.get(id);
    }

    @Override
    public void addString(String s) {
        strings.add(s);
    }

    @Override
    public boolean deleteByID(int id) {
        try{
            strings.remove(id);
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
    
}
