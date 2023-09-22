/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.beanProducto;
import interfaces.IVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Conexion;

/**
 *
 * @author carlos
 */
public class DaoVentas implements IVentas{
    private Connection cn;
    private PreparedStatement pstm;
    
    @Override
    public boolean addVenta(int idProd, String user) {
        
        ResultSet rs = null;
    
        try {
          cn=new Conexion().getCn();
          
          pstm= cn.prepareStatement("SELECT `id` FROM `ventas` WHERE usuario=? ORDER BY id DESC LIMIT 1");
          pstm.setString(1, user);
          rs=pstm.executeQuery();
          int ultimo = 1;
          if(rs !=null){
            while(rs.next()){
                ultimo = rs.getInt(1)+1;
            }
          }
          
          String Query = "INSERT INTO `ventas`(`id`, `usuario`,"
                  + "`productosID`) VALUES ("+ "\"" + ultimo + "\", "
                  + "\"" + user + "\","
                  + "" + idProd + ")";
          Statement st = cn.createStatement();
          st.executeUpdate(Query);
          if(rs != null){
            System.out.print("######## Se han insertado los datos");
          }
          st.close();
          pstm.close();
          return true;
        } catch (Exception e) {
           String error = e.toString();
           System.out.print("########ERROR: "+error);
           return false;
        }
    }
    
    @Override
    public List<beanProducto> getProductosVenta(String user) {
        
        List<beanProducto> historialList = new ArrayList<>();
        ResultSet rs = null;
        ResultSet rs2 = null;
      
        try {
          cn=new Conexion().getCn();
          pstm= cn.prepareStatement("SELECT `id`, `usuario`, `productosID` FROM `ventas` WHERE usuario = ?");
          pstm.setString(1, user);
          rs=pstm.executeQuery();
          int a;
          while(rs.next()){
              int idProd = rs.getInt(3);
              pstm= cn.prepareStatement("select id, nombre, precio, img from productos where id=? ");
              pstm.setInt(1, idProd);
              rs2=pstm.executeQuery();
              
              while(rs2.next()){
                beanProducto producto = new beanProducto();
                producto.setProductoID(rs2.getInt(1));
                producto.setNombre(rs2.getString(2));
                producto.setPrecio(rs2.getInt(3));
                producto.setImg(rs2.getString(4));
                historialList.add(producto);
             }
                      
          }
          
          pstm.close();
          return historialList;
        } catch (Exception e) {
           String err = e.toString();
           System.out.print(err);
           return null;
        }
    }
    
}
