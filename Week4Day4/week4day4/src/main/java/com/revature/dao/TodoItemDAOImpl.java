package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.TodoItem;
import com.revature.utils.ConnectionUtils;

public class TodoItemDAOImpl implements TodoItemDAO{
    private Connection conn;

    public TodoItemDAOImpl(){
        conn = ConnectionUtils.getConnection();
    }

    @Override
    public TodoItem insertNewItem(TodoItem newItem) {
        try{
            String sql = "INSERT INTO todo_item VALUES(default,?);";
    
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    
            ps.setString(1, newItem.getContents());
    
            int rows = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next()){
                newItem.setId(rs.getInt("id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return newItem;
    }

    @Override
    public TodoItem getItemByID(int id) {
        try{
            String sql = "SELECT * FROM todo_item WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new TodoItem(rs.getInt(1), rs.getString(2));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TodoItem updateItem(TodoItem newItem) {
        try{
            String sql = "UPDATE todo_item SET contents = ? WHERE id = ?";
    
            PreparedStatement ps = conn.prepareStatement(sql);
    
            ps.setString(1, newItem.getContents());
            ps.setInt(2, newItem.getId());
    
            int rows = ps.executeUpdate();

            return newItem;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteItemByID(int id) {
        try{
            String sql = "DELETE FROM todo_item WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }
    
}
