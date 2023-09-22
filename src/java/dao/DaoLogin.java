/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.beanLogin;
import interfaces.ILogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.Conexion;

/**
 *
 * @author carlos
 */
public class DaoLogin implements ILogin  {
    
    private Connection cn;
    private PreparedStatement pstm;
    
    @Override
    public beanLogin Logueo(beanLogin user) {
      beanLogin obj = new beanLogin();
        ResultSet rs = null;
      
        try {
          cn=new Conexion().getCn();
          pstm= cn.prepareStatement("select usuario from tb_login where usuario=? and clave=?");
          pstm.setString(1, user.getUsuario());
          pstm.setString(2, user.getClave());
          rs=pstm.executeQuery();
          
          while(rs.next()){
              obj.setUsuario(rs.getString(1));
          }
          return obj;
        } catch (Exception e) {
           System.out.print(e.toString());
           return null;
        }
    }
    
}
