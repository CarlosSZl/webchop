/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author carlos
 */
public class beanProducto {
    private int _productoID;
    private String _nombre;
    private int _precio;
    private String _img;

    /**
     * @return the _productoID
     */
    public int getProductoID() {
        return _productoID;
    }

    /**
     * @param _productoID the _productoID to set
     */
    public void setProductoID(int _productoID) {
        this._productoID = _productoID;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _precio
     */
    public int getPrecio() {
        return _precio;
    }

    /**
     * @param _precio the _precio to set
     */
    public void setPrecio(int _precio) {
        this._precio = _precio;
    }

    /**
     * @return the _img
     */
    public String getImg() {
        return _img;
    }

    /**
     * @param _img the _img to set
     */
    public void setImg(String _img) {
        this._img = _img;
    }
    
    
}
