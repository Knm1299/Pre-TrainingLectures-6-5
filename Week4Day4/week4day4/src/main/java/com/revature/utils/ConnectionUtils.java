package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TODO: build this utility class to help acces the DB from our DAO
 */
public class ConnectionUtils{
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "85949";
    private static Connection conn = null;

    public static Connection getConnection(){
        try{
            if(conn == null  || conn.isClosed()){
                conn = DriverManager.getConnection(url, username, password);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    // public static void close(){
    //     try{
    //         conn.close();
    //     }catch(SQLException e){
    //         e.printStackTrace();
    //     }
    // }
}