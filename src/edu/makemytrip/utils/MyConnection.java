/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siwar
 */
public class MyConnection {
    public String Url="jdbc:mysql://localhost:3306/makemy_trip";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static MyConnection instance;
    public static MyConnection getInstance(){
        if(instance==null){
            instance =new MyConnection();
        }
        return instance;
    }
    private MyConnection(){
        try {
            cnx=DriverManager.getConnection(Url,login,pwd);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }
    public Connection getCnx(){
        return cnx;
    }
    }   
