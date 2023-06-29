package com.revature.dao;

import com.revature.models.TodoItem;

public interface TodoItemDAO {
    
    public TodoItem insertNewItem(TodoItem newItem);
    
    public TodoItem getItemByID(int id);

    public TodoItem updateItem(TodoItem newItem);
    
    public boolean deleteItemByID(int id);
}
