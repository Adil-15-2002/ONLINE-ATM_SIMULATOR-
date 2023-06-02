package com.company;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;
    String url="jdbc:mysql://localhost:3306/banksystem";
    String username= "root";
    String pasword ="";
    Statement s;
    public  Conn(){

        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");

            c= DriverManager.getConnection(url,username, pasword);
            s=c.createStatement();
        }
        catch (Exception ae){
            System.out.println(ae);
        }
    }
}
