/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class Conexion {
    private static String drive = "com.mysql.cj.jdbc.Driver";
    private static String usuario = "root";
    private static String password = "";
    private static String url="jdbc:mysql://localhost:3307/tienda";
    
    static{
        try{
            Class.forName(drive);
        }catch(Exception ex){
            System.out.print(ex.toString());
        }
    }
    
    public Connection getCn(){
        Connection cn=null;
        try{
            cn=DriverManager.getConnection(url, usuario, password);
        }catch(SQLException ex){
            System.out.print("############");
            String exc =ex.toString();
            System.out.print(ex.toString());
        }
        return cn;
    }
    
}
