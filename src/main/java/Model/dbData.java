/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author manuel
 */
public class dbData {
//    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "driverconn";
    private final String password = "secretpass";
    private final String database = "reto3";
    private final String url = "jdbc:mysql://localhost:3306/" + database;
    private Connection connection;
    
    public Connection getConnection(){
        try{
            this.connection = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword());
            return this.connection;
        }catch(SQLException e){
            System.out.println("Error Base Datos: " + e.getSQLState());
            return null;
        }
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getUrl() {
        return url;
    }
}
