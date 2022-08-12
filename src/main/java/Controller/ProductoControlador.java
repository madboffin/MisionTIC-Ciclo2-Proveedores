/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Class.ProductoClase;
import Class.Report.ProductoReporte;
import Model.ProductoModelo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jotarlo
 */
public class ProductoControlador {

    private ProductoModelo modelProducto;

    public ProductoControlador() {
        this.modelProducto = new ProductoModelo();
    }

    public boolean crear(ProductoClase clsProveedor) {
        return this.modelProducto.crear(clsProveedor);
    }

    public ProductoClase buscar(String nombre) {
        return this.modelProducto.buscar(nombre);
    }

    public boolean editar(ProductoClase clsProducto) {
        return this.modelProducto.editar(clsProducto);
    }

    public boolean eliminar(int id) {
        return this.modelProducto.eliminar(id);
    }
    
    public ArrayList<ProductoReporte> obtenerLista()throws SQLException{
        try {
            return this.modelProducto.obtenerListadoProductos();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
}
