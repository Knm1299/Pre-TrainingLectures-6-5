package com.revature;

import java.sql.Connection;

public class ConnectionUtils {
    static Connection conn;

    static Connection getConnection(){
        if (conn == null){
            return null;//new connection object, not included bc implementation is long
        }else{
            return conn;
        }
    }

    /*
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, username, password);
                resetTestDatabase();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
     * 
     */
    
}
