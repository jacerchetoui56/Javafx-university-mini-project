package com.example.demodb.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* L classe hedhi tkhalina nconnectiw 3al base de donnee*/

public class DBHandler extends Config {
        Connection dbConnection;
    public Connection getConnection(){
            String connectionString="jdbc:mysql://"+Config.dbhost+":"+Config.dbport+"/"+Config.dbname+"?autoReconnect=true&useSSL=false";
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        try {
            dbConnection= DriverManager.getConnection(connectionString,Config.dbuser,Config.dbpass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(dbConnection);
        return dbConnection;
    }
}
