/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Class.*;
import Class.Report.ProductoReporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jotarlo
 */
public class ProductoModelo {
    
    private Connection db_conn;
    
    public ProductoModelo() {
        this.db_conn = new dbData().getConnection();
    }
    
    public boolean crear(ProductoClase clsProducto) {
        // retorna verdadero si se realiza el INSERT exitosamente
        try {
            String queryInsertProducto = "INSERT INTO `reto3`.`tb_producto` "
                    + " (`nombre`, `precio_actual`, `existencia`) "
                    + " VALUES (?, ?, ?);";
            PreparedStatement statementProducto = this.db_conn.prepareStatement(queryInsertProducto, Statement.RETURN_GENERATED_KEYS);
            statementProducto.setString(1, clsProducto.getNombre());
            statementProducto.setInt(2, clsProducto.getPrecio_actual());
            statementProducto.setInt(3, clsProducto.getExistencia());
            
            String queryInsertP_P = "INSERT INTO `reto3`.`tb_proveedor_producto` "
                    + " (`tb_proveedor_nit`, `tb_producto_id`) "
                    + " VALUES (?, ?);";
            PreparedStatement statementP_P = this.db_conn.prepareStatement(queryInsertP_P);
            statementP_P.setInt(1, clsProducto.getNit_proveedor());

            // insertar en tabla tb_producto
            int rowsInsertedCount = statementProducto.executeUpdate();  //retorna cuantas filas se insertaron

            // si se realizo insercion en la tabla pet, se procede a lo mismo en tabla dog
            ResultSet keys = statementProducto.getGeneratedKeys();
            if (keys != null) {
                keys.next();
                
                statementP_P.setInt(2, keys.getInt(1));
                // insertar en tabla tb_proveedor_producto
                System.out.println(keys.getInt(1));
                System.out.println(statementP_P);
                int rowsInsertedCount2 = statementP_P.executeUpdate();
                
                return rowsInsertedCount > 0 && rowsInsertedCount2 > 0;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public ProductoClase buscar(String nombre) {
        try {
            String query = ""
                    + " SELECT id, nombre, precio_actual, existencia "
                    + " FROM reto3.tb_producto AS p "
                    + " WHERE nombre = ?;";
            PreparedStatement statement = this.db_conn.prepareStatement(query);
            statement.setString(1, nombre);
            ResultSet resultProv = statement.executeQuery();
//            System.out.println(statement);

            // definiendo las variables que se van a usar para crear la clase proveedor
            int precio_actual, existencia;
            ProductoClase producto = new ProductoClase();
//            ArrayList<String> direccion = new ArrayList<>();
            // iteranto las filas, pero este metodo solo toma la primera
            while (resultProv.next()) {
                precio_actual = resultProv.getInt("precio_actual");
                existencia = resultProv.getInt("existencia");
//                nit_proveedor = resultProv.getString("nit_proveedor");

                producto.setNombre(nombre);
                producto.setPrecio_actual(precio_actual);
                producto.setExistencia(existencia);
                
            }
            return producto;
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public boolean editar(ProductoClase clsProducto) {

        // retorna verdadero si se realiza el UPDATE exitosamente
//        try {
//            String queryProveedor = ""
//                    + "UPDATE reto3.tb_proveedor "
//                    + "SET razon_social = ?, telefono = ?, correo_electronico = ?, representante = ?, sitio_web = ? "
//                    + "WHERE nit = ? ;";
//            PreparedStatement statementProveedor = this.db_conn.prepareStatement(queryProveedor);
//            statementProveedor.setString(1, clsProducto.getRazon_social());
//            statementProveedor.setString(2, clsProducto.getTelefono());
//            statementProveedor.setString(3, clsProducto.getCorreo_electronico());
//            statementProveedor.setString(4, clsProducto.getRepresentante());
//            statementProveedor.setString(5, clsProducto.getSitio_web());
//            statementProveedor.setInt(6, clsProducto.getNit());
//
//            String queryDireccion = ""
//                    + "UPDATE reto3.tb_direccion "
//                    + "SET calle_carrera = ?, numero = ?, barrio = ?, ciudad = ? "
//                    + "WHERE nit_proveedor = ? ;";
//            PreparedStatement statementDireccion = this.db_conn.prepareStatement(queryDireccion);
//
//            statementDireccion.setString(1, clsProducto.getDireccion().get(0));
//            statementDireccion.setString(2, clsProducto.getDireccion().get(1));
//            statementDireccion.setString(3, clsProducto.getDireccion().get(2));
//            statementDireccion.setString(4, clsProducto.getDireccion().get(3));
//            statementDireccion.setInt(5, clsProducto.getNit());
//
////            System.out.println(statementP_P);
////            System.out.println(statementDireccion);
//            int rowsUpdatedProveedor = statementProveedor.executeUpdate();
//            int rowsUpdatedDireccion = statementDireccion.executeUpdate();
//
//            return (rowsUpdatedProveedor > 0 && rowsUpdatedDireccion > 0);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
        return false;
    }
    
    public boolean eliminar(int id) {
        // retorna verdadero si se realiza el DELETE exitosamente
        try {
            String queryDeleteDireccion = "DELETE FROM `reto3`.`tb_direccion` "
                    + " WHERE (`nit_proveedor` = ?);";
            PreparedStatement statementDireccion = this.db_conn.prepareStatement(queryDeleteDireccion);
            statementDireccion.setInt(1, id);
            
            String queryDeleteProveedor = "DELETE FROM `reto3`.`tb_proveedor` "
                    + " WHERE (`nit` = ?);";
            PreparedStatement statementProveedor = this.db_conn.prepareStatement(queryDeleteProveedor);
            statementProveedor.setInt(1, id);

            // para validar los datos ingresados a base de datos
//            System.out.println(statementP_P);
//            System.out.println(statementDireccion);
            int rowsDeleted2 = statementDireccion.executeUpdate();
            int rowsDeleted1 = statementProveedor.executeUpdate();
            
            return (rowsDeleted1 > 0 && rowsDeleted2 > 0);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public ArrayList<ProveedorClase> obtenerProveedores() {
        
        return null;
    }
    
    public ArrayList<ProductoReporte> obtenerListadoProductos() throws SQLException {
        try {
            ArrayList<ProductoReporte> lista_productos = new ArrayList<>();
            String query = "SELECT nit, razon_social, ciudad, nombre, existencia, precio_actual "
                    + " FROM reto3.tb_proveedor AS pv\n"
                    + " INNER JOIN reto3.tb_proveedor_producto AS pp ON pp.tb_proveedor_nit = pv.nit\n"
                    + " INNER JOIN reto3.tb_producto AS pd ON pp.tb_producto_id = pd.id\n"
                    + " LEFT JOIN reto3.tb_direccion AS dr ON dr.nit_proveedor = pv.nit\n"
                    + " WHERE existencia > 10 \n"
                    + " ORDER BY existencia DESC;";
            PreparedStatement statement = this.db_conn.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ProductoReporte temp;
                temp = new ProductoReporte(result.getString("nombre"),
                        result.getInt("precio_actual"),
                        result.getString("razon_social"),
                        result.getInt("nit"),
                        result.getInt("existencia"));
                lista_productos.add(temp);
            }
            return lista_productos;
            
        } catch (SQLException e) {
            throw e;
        }
    }
}
