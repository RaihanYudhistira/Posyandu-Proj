/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
public class Koneksi {
    private static Connection kon;
    private static final String URL = "jdbc:mysql://localhost/posyandu2";
    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static Connection bukaKoneksi(){
        if (kon == null){
            try{
                Class.forName(DRIVERNAME);
                try{
                    kon = (com.mysql.jdbc.Connection)
                            DriverManager.getConnection(URL,USERNAME,PASSWORD);
                }
                catch(SQLException sqle){
                    System.out.println("Tidak terhubung ke database:"+sqle);
                }
            }catch(ClassNotFoundException e){
                System.out.println("Driver not found: "+e);
            }
        }
        return kon;
    }
    public static Connection tutupKoneksi(){
        if (kon != null){
            try{
                kon.close();
            }catch(SQLException e){
                System.out.println("Error: "+e);
            }
        }
        return kon;
    }
    public static void main(String[]args){
        new Koneksi();
    }
}