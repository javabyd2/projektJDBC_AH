package com.sdabyd2.programowanie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection = null;
    private final static String ADRESS = "jdbc:mysql://127.0.0.1";
    private final static String DATABASE = "rental_db";
    private final static String USER = "root";
    private final static String PASSWORD = "Z@pomin@l$k@";
    private final static String PORT = "3306";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String PARAMS = "useSSL=false&serverTimezone=UTC";

    private static void loadDriver(){
        try{
            Class.forName(DRIVER);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void loadConnection(){
        try {
            connection = DriverManager.getConnection(getFormatedURL(), USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static String getFormatedURL(){
        return  ADRESS + ":" + PORT + "/" + DATABASE + "?" + PARAMS;
    }
    public static Connection getConnection(){
        if (connection==null){
            loadDriver();
            loadConnection();
        }return connection;
    }
    public static void closeConnection(){
        if (connection ==null){
            System.out.println("nie ma co zamykać");
        }else{
            try{
                connection.close();
                connection=null;
            }catch(SQLException exception){
                exception.printStackTrace();
            }
        }
    }

}
