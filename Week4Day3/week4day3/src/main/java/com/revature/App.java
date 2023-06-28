package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.TodoItem;

/**
 * JDBC, DAOs, important interfaces, connection
 *
 *  Definitions:
 *      JDBC - Java DataBase Connectivity
 *             API for interfacing between Java and a database
 *             Can be used for more than SQL, but SQL is most common
 *             Needs a 'Driver' library to work, this provides implementations for our use case
 * 
 *      DAO - Data Access Object
 *            Design pattern that contains the methods that access the database
 *            Usually one class is defined for each table we interact with
 *            CRUD operations are the most common to see here, 
 *                  but more complex queries can be included if necessary
 *      
 *      Connection - an object representing the connection we have to the DB
 *                   We can obtain this from the DriverManager.getConnection method
 *                   Needs 3 things:
 *                      URL      - where to access database, 
 *                                  format is jdbc::drivername://url:port/databasename
 *                      username
 *                      password
 * 
 *      Statement - Send actual sql to the database,
 *           the statement object's purpose is to hold the actual sql
 *           and send to the db when necessary
 * 
 *      Prepared Statement
 *          Protects against sql injection attacks
 * 
 *      ResultSet
 *          contains all the rows returned from the db
 *      
 */
public class App 
{
    public static void main( String[] args )
    {
        //No UI today, walk through CRUD operations
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "85949";
        Connection conn;

        try{
            //create table
            conn = DriverManager.getConnection(url, username, password);
            String sql = "create table if not exists todoItem( id serial primary key, contents varchar(100));";
            Statement st = conn.createStatement();
            boolean result = st.execute(sql);

            TodoItem todo = new TodoItem(1000, "Clean Car");

            sql = "INSERT INTO todo_item VALUES(default,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, todo.getContents());

            int rows = ps.executeUpdate();

            System.out.println("If this is 1 then everything worked: " + rows);

            sql = "select * from todo_item";

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery(); 

            while(rs.next()){
                TodoItem item = new TodoItem(rs.getInt("id"), rs.getString("contents"));
                System.out.println(item);
            }

        }catch(SQLException e){
            System.out.println(e);
        }


    }
}
