package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.TodoItem;

public class TodoItemDAOArrayListImpl implements TodoItemDAO{
    private List<TodoItem> list;

    public TodoItemDAOArrayListImpl(){
        list = new ArrayList<>();
    }

    @Override
    public TodoItem getItemByID(int id) {
        return list.get(id);
    }

    @Override
    public TodoItem insertNewItem(TodoItem newItem) {
        list.add(newItem);
        return newItem;
    }

    @Override
    public boolean deleteItemByID(int id) {
        try{
            list.remove(id);
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public TodoItem updateItem(TodoItem newItem) {
        for(int i = 0; i < list.size(); i++){
            if(newItem.getId() == (list.get(i)).getId()){
                list.set(i, newItem);
                return newItem;
            }
        }
        return null;
    }
    
}
