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
public interface IVentas {
    boolean addVenta(int idProd, String user);
    List<beanProducto> getProductosVenta(String user);
}
