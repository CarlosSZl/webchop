/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import beans.beanProducto;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IProducto {
    List<beanProducto> getProductos();
    boolean addCarro(int idProd, String user);
    List<beanProducto> getProductosCarro(String user);
}
