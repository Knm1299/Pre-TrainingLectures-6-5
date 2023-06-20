package com.revature;

public interface CRUD {

    int NUMBER = 100;
    
    public String getByID(int id);

    public void addString(String s);
    
    public boolean deleteByID(int id);
}
